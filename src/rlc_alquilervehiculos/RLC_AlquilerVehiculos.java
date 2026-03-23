/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rlc_alquilervehiculos;

import objetos.Cliente;
import objetos.Vehiculo;
import objetos.vehiculos.mercancias.Furgoneta;
import objetos.vehiculos.turismos.Deportivo;
import objetos.vehiculos.turismos.Familiar;
import objetos.Alquiler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utiles.ES;
import utiles.Utilidades;

/**
 *
 * @author raullc0
 */
public class RLC_AlquilerVehiculos {

// ATRIBUTOS --------------------------------------------------------------------------------------------------
    
    /*
        Importante: ya que los datos no se borran, 
        se debe establecer un limite alto si se 
        quieren cambiar datos con fecuencia
    */
    public static final String ET_ALQUILERVEHICULOS = "AquilerVehiculos";
    public static final String NOMBRE_XML = "alquilervehiculo.xml";
    
    public static final String RUTA_CLIENTES = "datos\\clientes_RLC.dat";
    public static final String RUTA_VEHICULOS = "datos\\vehiculos_RLC.dat";
    public static final String RUTA_ALQUILERES = "datos\\alquileres_RLC.dat";
    public static final String RUTA_BACKUPS = "backups\\";
    
    static ArrayList<Cliente>  lClientes;
    static ArrayList<Vehiculo>  lVehiculos;
    static ArrayList<Alquiler>  lAlquileres;
    
    
// MAIN -------------------------------------------------------------------------------------------------------
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Dar memoria a los arrays
        lClientes = new ArrayList<Cliente>();
        lVehiculos = new ArrayList<Vehiculo>();
        lAlquileres = new ArrayList<Alquiler>();
        
        // Logica del programa
        int opcionMenu;
        String dni, matricula;
        leerDatos(RUTA_CLIENTES, RUTA_VEHICULOS, RUTA_ALQUILERES);
        
        do 
        {
            try 
            {
                new ProcessBuilder("cmd", "/C", "cls").inheritIO().start().waitFor();
            }
            catch (IOException | InterruptedException e) {}
            
            menu();
            opcionMenu = ES.leerEntero();
            
            switch (opcionMenu) 
            {
                case 0:
                    ES.escribirCl("Esta a punto de salir del programa,\nesta seguro? Si / No\n", "ANSI_RED");
                    boolean respuesta = ES.siono();
                    
                    if (respuesta == false)
                        opcionMenu = -1;
                    else {
                        ES.escribirCl("Desea guardar los datos?\nSi / No\n", "ANSI_GREEN");
                        boolean guardar = ES.siono();

                        if(guardar)
                        {
                            guardarDatos(RUTA_CLIENTES, RUTA_VEHICULOS, RUTA_ALQUILERES);
                            guardarXML();
                        }
                    }
                    break;
                case 1:
                    anadirCliente(pedirDatosCliente());
                    break;
                case 2:
                    dni = pedirDNI();
                    darDeBajaACliente(dni);
                    borrarCliente(dni);
                    break;
                case 3:
                    listarClientes(false);
                    ES.simularPausa();
                    break;
                case 4:
                    listarClientes(true);
                    ES.simularPausa();
                    break;
                case 5:
                    anadirVehiculo(pedirDatosVehiculo());
                    break;
                case 6:
                    matricula = pedirMatricula();
                    darDeBajaAVehiculo(matricula);
                    borrarVehiculo(matricula);
                    break;
                case 7:
                    listarVehiculos(false);
                    ES.simularPausa();
                    break;
                case 8:
                    listarVehiculos(true);
                    ES.simularPausa();
                    break;
                case 9:
                    dni = pedirDNI();
                    matricula = pedirMatricula();
                    
                    // En el caso de no existir ningun cliente o vehiculo, escribir un dato incorrecto saltara el proceso
                    
                    if (getCliente(dni) != null)
                    {
                        if (getVehiculo(matricula) != null)
                        {
                            nuevoAlquiler(getCliente(dni), getVehiculo(matricula));
                        }
                        else
                            ES.escribirCl("Error: El vehiculo con dicha MATRICULA no existe", "ANSI_RED");
                    }
                    else
                        ES.escribirCl("Error: El cliente con dicho DNI no existe", "ANSI_RED");

                    break;
                case 10:
                    dni = pedirDNI();
                    matricula = pedirMatricula();
                    
                    // En el caso de no existir ningun cliente o vehiculo, escribir un dato incorrecto saltara el proceso
                    
                    if (getCliente(dni) != null)
                    {
                        if (getVehiculo(matricula) != null)
                        {
                            cerrarAlquiler(getCliente(dni), getVehiculo(matricula));
                        }
                        else
                            ES.escribirCl("Error: El vehiculo con dicha MATRICULA no existe", "ANSI_RED");
                    }
                    else
                        ES.escribirCl("Error: El cliente con dicho DNI no existe", "ANSI_RED");
                    
                    break;
                case 11:
                    listarAlquileres();
                    ES.simularPausa();
                    break;
                case 12:
                    guardarDatos(RUTA_CLIENTES, RUTA_VEHICULOS, RUTA_ALQUILERES);
                    guardarXML();
                    break;
                case 13:
                    crearCopiaDeSeguridad();
                    break;
                case 14:
                    recuperarCopiaDeSeguridad();
                    break;
                case 15:
                    leerXML();
                    break;
            }
        }
        while(opcionMenu != 0);
        
    }
    
// METODOS ----------------------------------------------------------------------------------------------------
    
    private static void menu() 
    {
        ES.escribirCl("--------------------------------\n", "ANSI_PURPLE");
        ES.escribirCl("Menu de opciones: \n", "ANSI_BLACK");
        ES.escribirLn("");
        ES.escribirCl("\t1. Anadir cliente\n", "ANSI_GREEN");
        ES.escribirCl("\t2. Dar de baja a cliente\n", "ANSI_GREEN");
        ES.escribirCl("\t3. Listar clientes\n", "ANSI_GREEN");
        ES.escribirCl("\t4. Listar clientes dados de baja\n", "ANSI_GREEN");
        ES.escribirCl("\t5. Anadir vehiculo\n", "ANSI_CYAN");
        ES.escribirCl("\t6. Dar de baja a vehiculo\n", "ANSI_CYAN");
        ES.escribirCl("\t7. Listar vehiculos\n", "ANSI_CYAN");
        ES.escribirCl("\t8. Listar vehiculos dados de baja\n", "ANSI_CYAN");
        ES.escribirCl("\t9. Abrir un alquiler\n", "ANSI_BLUE");
        ES.escribirCl("\t10. Cerrar un alquiler\n", "ANSI_BLUE");
        ES.escribirCl("\t11. Listar alquileres\n", "ANSI_BLUE");
        ES.escribirLn("");
        ES.escribirLn("\t12. Guardar datos (.dat y XML)");
        ES.escribirLn("");
        ES.escribirLn("\t13. Realizar copia de seguridad");
        ES.escribirLn("\t14. Recuperar copia de seguridad");
        ES.escribirLn("");
        ES.escribirLn("\t15. Cargar datos del XML");
        ES.escribirCl("0. SALIR\n", "ANSI_BLACK");
        ES.escribirCl("--------------------------------\n", "ANSI_PURPLE");
        ES.escribirCl("Escriba la opcion: ", "ANSI_CYAN");
        
    }
    
    // CLIENTES ----------------------------------------------------------------------------------------------------
    
    private static Cliente getCliente(String _dni)
    {
        Cliente cliente = lClientes.stream().filter(c -> c.getDni().equals(_dni))
        .findFirst()
        .orElse(null); // Devuelve null si no lo encuentra
        
        return cliente ;
    }
    
    private static void anadirCliente(Cliente cliente)
    {
        
        if( getCliente(cliente.getDni()) == null)
        {
            lClientes.add(cliente);
        }
        else
            ES.escribirCl("Error: El cliente con dicho DNI ya existe\n", "ANSI_RED");
       
    }
    
    public static void crearClienteConDatos(String [] _datos)
    {
        String dni = _datos[0];
        dni = ES.toUpperCase(dni);

        if (Utilidades.comprobarDni(dni) == true) 
        {
            String nombre = _datos[1];
            String direccion = _datos[2];
            String localidad = _datos[3];


            if (Utilidades.comprobarCodigoPostal(_datos[4]) == true)
            {
                String codigoPostal = _datos[4];

                Cliente cliente = new Cliente(dni, nombre, direccion, localidad, codigoPostal);

                if (Boolean.parseBoolean(_datos[5]) == true)
                    cliente.darDeBaja();

                anadirCliente(cliente); 
            }
            else
                ES.escribirCl("Error: Codigo postal no valido\n", "ANSI_RED");
        }
        else
            ES.escribirCl("Error: DNI no valido\n", "ANSI_RED");
            
        
    }
    
    private static Cliente pedirDatosCliente() 
    {
        String dni, nombre, direccion, localidad, codigoPostal;
        
        do 
        {
            dni = ES.leerCadena("Introduca su DNI/NIE: ", 9);
        }
        while (Utilidades.comprobarDni(dni) == false);
        
        dni = ES.toUpperCase(dni);
        
        nombre = ES.leerCadena("Introduzca su nombre: ");
        direccion = ES.leerCadena("Intruzca su direccion: ");
        localidad = ES.leerCadena("Introduzca su localidad: ");
        
        do
        {
            codigoPostal = ES.leerCadena("Introduzca su codigo postal: ", 5);
        }
        while (Utilidades.comprobarCodigoPostal(codigoPostal) == false);
        
        Cliente cliente = new Cliente(dni, nombre, direccion, localidad, codigoPostal);
        return cliente;
    }
    
    
    private static String pedirDNI() 
    {
        String dni;
        
        do 
        {
            dni = ES.leerCadena("Introduca su DNI/NIE: ", 9);
        }
        while (Utilidades.comprobarDni(dni) == false);
        
        dni = ES.toUpperCase(dni);
        
        return dni;
    }
    
    private static void borrarCliente(String _dni)
    {
        if (getCliente(_dni) != null) 
        {
            ES.escribirCl("Esta seguro de ELIMINAR DEFINITIVAMENTE al cliente? Si/No\n", "ANSI_RED");
            if (ES.siono() == true)
                lClientes.remove(getCliente(_dni));
        }
        else
            ES.escribirCl("Error: El cliente con dicho DNI no existe.\n", "ANSI_RED");
    }
    
    private static void darDeBajaACliente(String _dni)
    {
        if (getCliente(_dni) != null) 
        {
            ES.escribirCl("Esta seguro de dar de baja al cliente? Si/No\n", "ANSI_RED");
            if (ES.siono() == true)
            {
                int i = lClientes.indexOf(getCliente(_dni));
                lClientes.get(i).darDeBaja();
            }
        }
        else
            ES.escribirCl("Error: El cliente con dicho DNI no existe.\n", "ANSI_RED");
    }
    
    private static void listarClientes(boolean deBaja)
    {
        if(!lClientes.isEmpty())
        {
            for (int i = 0; i < lClientes.size(); i++)
            {
                if (lClientes.get(i).estaDeBaja() == deBaja)
                {
                    ES.escribir(lClientes.get(i).toString());
                    ES.escribirLn("");
                }
            }
        }
    }
    
    // VEHICULOS ---------------------------------------------------------------------------------------------------------------------------
    
    private static Vehiculo getVehiculo(String _matricula)
    {
        Vehiculo vehiculo = lVehiculos.stream().filter(v -> v.getMatricula().equals(_matricula))
        .findFirst()
        .orElse(null); // Devuelve null si no lo encuentra
        
        return vehiculo ;
    }
    
    private static void anadirVehiculo(Vehiculo vehiculo) 
    {
       
        if (getVehiculo(vehiculo.getMatricula()) == null) 
        {
            lVehiculos.add(vehiculo);
        }
        else
            ES.escribirCl("Error: El vehiculo con dicha matrícula ya existe\n", "ANSI_RED");
    }
    
    public static void crearVehiculoConDatos(String [] _datos) 
    {
        if (Utilidades.comprobarMatricula(_datos[1]) == true)
        {
            String matricula = _datos[1];
            matricula = ES.toUpperCase(matricula);
            
            
            String marca = _datos[2];
            String modelo = _datos[3];
            
            try
            {
                if(Integer.parseInt(_datos[4]) >= 1)
                {
                    int cilindrada = Integer.parseInt(_datos[4]);
                    
                    int tipoVehiculo = Integer.parseInt(_datos[0]);
                    boolean tipoValido = false;
                    Vehiculo vehiculo = null;
                    
                    switch (tipoVehiculo)
                    {
                        case 1: 
                            vehiculo = datosDeportivo(matricula, marca, modelo, cilindrada, _datos);
                            tipoValido = true;
                            break;
                        case 2: 
                            vehiculo = datosFamiliar(matricula, marca, modelo, cilindrada, _datos);
                            tipoValido = true;
                            break;
                        case 3: 
                            vehiculo = datosFurgoneta(matricula, marca, modelo, cilindrada, _datos);
                            tipoValido = true;
                            break;
                    }
                    
                    if(tipoValido) // CREACION DEL VEHICULO
                    {
                        if (vehiculo != null)
                            anadirVehiculo(vehiculo);
                        
                        try
                        {
                            boolean disponible = Boolean.parseBoolean(_datos[5]);
                            
                            if (!disponible)
                                lVehiculos.get(lVehiculos.indexOf(vehiculo)).setDisponible(disponible);
                            
                            boolean baja = Boolean.parseBoolean(_datos[6]);
                            
                            if (baja)
                                lVehiculos.get(lVehiculos.indexOf(vehiculo)).darDeBaja();
                            
                        }
                        catch(Exception e){}
                    }
                }
            } catch (NumberFormatException e){}
  
        }
    }
    
    private static Vehiculo pedirDatosVehiculo()
    {
        String matricula, marca, modelo;
        int cilindrada;
        
        do 
        {
            matricula = ES.leerCadena("Introduca la matricula del vehiculo: ", 7);
        }
        while (Utilidades.comprobarMatricula(matricula) == false);
        
        matricula = ES.toUpperCase(matricula);
        
        marca = ES.leerCadena("Introduzca la marca del vehiculo: ");
        modelo = ES.leerCadena("Introduzca el modelo del vehiculo: ");
        byte minimoCilindrada = 1;
        cilindrada = ES.leerEntero("Introduzca la cilindrada del vehiculo: ", minimoCilindrada);
        
        // Separacion por vehiculo
        
        int tipoVehiculo;
        Vehiculo vehiculo = null;

        ES.escribirLn("\nEliga el tipo de vehiculo.");
        ES.escribirLn("1.- Deportivo");
        ES.escribirLn("2.- Familiar");
        ES.escribirLn("3.- Furgoneta");

        tipoVehiculo = ES.leerEntero("", (byte) 1, (byte) 3);

        switch (tipoVehiculo) {
            case 1 -> vehiculo = datosDeportivo(matricula, marca, modelo, cilindrada, null);
            case 2 -> vehiculo = datosFamiliar(matricula, marca, modelo, cilindrada, null);
            case 3 -> vehiculo = datosFurgoneta(matricula, marca, modelo, cilindrada, null);
        }
        
        return vehiculo;
    }
    
    private static Deportivo datosDeportivo(String matricula, String marca, String modelo, int cilindrada, String [] _datos)
    {
        
        Deportivo deportivo = null;
        try
        {
            if (_datos != null)
            {
                int nPuertas = Integer.parseInt(_datos[7]);
                
                Enumerados.TipoCombustible combustible = Enumerados.TipoCombustible.valueOf(_datos[8]);
            
                boolean descapotable = Boolean.parseBoolean(_datos[9]);
            
                Enumerados.CajaCambio cambio = Enumerados.CajaCambio.valueOf(_datos[10]);
            
                deportivo = new Deportivo(cambio, descapotable, matricula, marca, modelo, cilindrada, combustible, nPuertas);
            }
            else // Pedir datos
            {
                int nPuertas = ES.leerEntero("Introduza el numero de puertas: ");

                Enumerados.TipoCombustible combustible = tipoCombustible();

                Enumerados.CajaCambio cambio = cajaCambio();

                ES.escribirLn("Es el deportivo descapotable? Si/No");
                boolean descapotable = ES.siono();
                
                deportivo = new Deportivo(cambio, descapotable, matricula, marca, modelo, cilindrada, combustible, nPuertas);
            }
            
        }
        catch(NumberFormatException e) {}
        
        return deportivo;
    }
    
    private static Familiar datosFamiliar(String matricula, String marca, String modelo, int cilindrada, String [] _datos)
    {
        Familiar familiar = null;
        
        try
        {
            if (_datos != null) 
            {
                int nPuertas = Integer.parseInt(_datos[7]);

                Enumerados.TipoCombustible combustible = Enumerados.TipoCombustible.valueOf(_datos[8]);

                int nPlazas = Integer.parseInt(_datos[9]);

                if (nPlazas < 4)
                        nPlazas = 4;
                    if (nPlazas > 7)
                        nPlazas = 7;
                    
                boolean sillaBebe = Boolean.parseBoolean(_datos[10]);

                familiar = new Familiar(nPlazas, sillaBebe, matricula, marca, modelo, cilindrada, combustible, nPuertas);
            }
            else 
            {
                int nPuertas = ES.leerEntero("Introduza el numero de puertas: ");
                int nPlazas = ES.leerEntero("Introduzca el numero de plazas (4-7): ", (byte) 4, (byte) 7);

                ES.escribirLn("Tiene silla de bebe? Si/No");
                boolean sillaBebe = ES.siono();

                Enumerados.TipoCombustible combustible = tipoCombustible();
                
                familiar = new Familiar(nPlazas, sillaBebe, matricula, marca, modelo, cilindrada, combustible, nPuertas);
            }
        }
        catch(NumberFormatException e) {}
        
        return familiar;
    }
    
    private static Furgoneta datosFurgoneta(String matricula, String marca, String modelo, int cilindrada, String [] _datos)
    {
        Furgoneta furgoneta = null;
        try 
        {
            if (_datos != null) 
            {
                int pma = Integer.parseInt(_datos[7]);
                if (pma < 1)
                    pma = 1;

                int volumen = Integer.parseInt(_datos[8]);
                if (volumen < 1)
                    volumen = 1;

                boolean refrigerado = Boolean.parseBoolean(_datos[9]);

                Enumerados.Tamano tamano = null;
                tamano = Enumerados.Tamano.valueOf(_datos[10]);

                furgoneta = new Furgoneta(refrigerado, tamano, pma, volumen, matricula, marca, modelo, cilindrada);
            }
            else
            {
                int pma = ES.leerEntero("Introduzca el Peso Maximo Autorizado: ", (byte)1);
                int volumen = ES.leerEntero("Introduzca el volumen: ", (byte)1);

                ES.escribirLn("Esta refrigerada? Si/No: ");
                boolean refrigerado = ES.siono();

                Enumerados.Tamano tamano = tamano();
                
                furgoneta = new Furgoneta(refrigerado, tamano, pma, volumen, matricula, marca, modelo, cilindrada);
            }
        }
        catch(Exception e) {}
        
        return furgoneta;
    }
    
    private static Enumerados.TipoCombustible tipoCombustible()
    {
        int nComb = ES.leerEntero("Introduzca el tipo de combustible:\n\t1 - Gasolina\n\t2 - Diesel\n\t3 - Hibrido\n\t4 - Electrico\n", (byte) 1, (byte) 4);
        Enumerados.TipoCombustible combustible = null;
        
        switch (nComb) 
        {
            case 1 -> combustible = Enumerados.TipoCombustible.GASOLINA;
            case 2 -> combustible = Enumerados.TipoCombustible.DIESEL;
            case 3 -> combustible = Enumerados.TipoCombustible.HIBRIDO;
            case 4 -> combustible = Enumerados.TipoCombustible.ELECTRICO;
        }
        
        return combustible;
    }
    
    
    private static Enumerados.CajaCambio cajaCambio()
    {
        int nCamb = ES.leerEntero("Introduzca el tipo de caja de cambio:\n\t1 - Manual\n\t2 - Automatica\n", (byte) 1, (byte) 2);
        Enumerados.CajaCambio cambio = null;
        
        switch (nCamb) 
        {
            case 1 -> cambio = Enumerados.CajaCambio.MANUAL;
            case 2 -> cambio = Enumerados.CajaCambio.AUTOMATICA;
        }
        
        return cambio;
    }
    
    
    private static Enumerados.Tamano tamano()
    {
        int nTam = ES.leerEntero("Introduzca el tamano:\n\t1 - Grande\n\t2 - Mediana\n\t3 - Pequena\n", (byte) 1, (byte) 3);
        Enumerados.Tamano tamano = null;
        
        switch (nTam) 
        {
            case 1 -> tamano = Enumerados.Tamano.GRANDE;
            case 2 -> tamano = Enumerados.Tamano.MEDIANA;
            case 3 -> tamano = Enumerados.Tamano.PEQUENA;
        }
        
        return tamano;
    }
    
    
    private static String pedirMatricula() 
    {
        String matricula;
        
        do 
        {
            matricula = ES.leerCadena("Introduca la matricula del vehiculo: ", 7);
        }
        while (Utilidades.comprobarMatricula(matricula) == false);
        
        matricula = ES.toUpperCase(matricula);
        
        return matricula;
    }
    
    private static void borrarVehiculo(String _matricula)
    {
        if (getVehiculo(_matricula) != null) 
        {
            ES.escribirCl("Esta seguro de ELIMINAR DEFINITIVAMENTE al vehiculo? Si/No\n", "ANSI_RED");
            if (ES.siono() == true)
                lVehiculos.remove(getVehiculo(_matricula));
        }
        else
            ES.escribirCl("Error: El vehiculo con dicha MATRICULA no existe.\n", "ANSI_RED");
    }
    
    private static void darDeBajaAVehiculo(String _matricula)
    {
        if (getVehiculo(_matricula) != null) 
        {
            ES.escribirCl("Esta seguro de dar de baja al vehiculo? Si/No\n", "ANSI_RED");
            if (ES.siono() == true)
            {
                int i = lVehiculos.indexOf(getVehiculo(_matricula));
                lVehiculos.get(i).darDeBaja();
            }
        }
        else
            ES.escribirCl("Error: El vehiculo con dicha MATRICULA no existe.\n", "ANSI_RED");
    }
    
    private static void listarVehiculos(boolean deBaja) 
    {
        if(!lVehiculos.isEmpty())
        {
            for (int i = 0; i < lVehiculos.size(); i++)
            {
                if (lVehiculos.get(i).estaDeBaja() == deBaja)
                {
                    ES.escribir(lVehiculos.get(i).toString());
                    ES.escribirLn("");
                }
            }
        }
    }
    
    // ALQUILERES ----------------------------------------------------------------------------------------------------
    
    
    private static void nuevoAlquiler(Cliente cliente, Vehiculo vehiculo)
    {
        if (vehiculo.isDisponible() == true) 
        {
            lAlquileres.add(new Alquiler(cliente, vehiculo));
        }
        else
            ES.escribirCl("ERROR: El vehiculo no esta disponible para alquilar. ", "ANSI_RED");
    }
    
    
    private static void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo)
    {
        boolean encontrado = false;
        
        if (vehiculo.isDisponible() == false) 
        {
            for (int i = 0; i < lAlquileres.size() && !encontrado; i++) 
            {
                if(lAlquileres.get(i).getCliente() == cliente && lAlquileres.get(i).getVehiculo() == vehiculo)
                {
                    lAlquileres.get(i).cerrar();
                    encontrado = true;
                    ES.escribirCl("Alquiler cerrado con exito\n", "ANSI_GREEN");
                    ES.simularPausa();
                }
            }
        }
        else
            ES.escribirCl("ERROR: El vehiculo no esta en ningun alquiler actualmente. ", "ANSI_RED");
        
        if (encontrado == false)
        {
            ES.escribirCl("ERROR: No se ha encontrado un alquiler con los requisitos especificados. ", "ANSI_RED");
        }
    }
    
    private static void listarAlquileres() 
    {
        if(!lAlquileres.isEmpty())
        {
            for (int i = 0; i < lAlquileres.size(); i++)
            {
            
                ES.escribir(lAlquileres.get(i).toString());
                ES.escribirLn("");
            }
        }
    }
    
    public static void crearAlquilerConDatos(String [] _datos)
    {
        
        
        if (Utilidades.comprobarDni(_datos[0]) == true)
        {
            String dni = _datos[0];
            dni = dni.toUpperCase();
            
            if(Utilidades.comprobarMatricula(_datos[1]) == true)
            {
                String matricula = _datos[1];
                matricula = matricula.toUpperCase();
                
                try 
                {
                    LocalDateTime fecha = LocalDateTime.parse(_datos[2]);
                    LocalDateTime fechaFin = null;
                    if (!"".equals(_datos[3]))
                        fechaFin = LocalDateTime.parse(_datos[3]);

                    lAlquileres.add(new Alquiler(getCliente(dni), getVehiculo(matricula), fecha, fechaFin));
                }
                catch(Exception e){}
            }
        }
    }
    
    // L/E DATOS ----------------------------------------------------------------------------------------------------
    
    public static boolean guardarDatos(String _rutaCli, String _rutaVeh, String _rutaAlq)
    {
        boolean exito = false;
        
        try {
            ES.escribirLn("Guardando informacion de los clientes.");
            for (int i = 0; i < lClientes.size(); i++) {
                ES.escribirArchivo(_rutaCli, lClientes.get(i).escribirFichero(), (i==0));
                ES.escribir("-");
            }
            ES.escribirLn("Informacion CLIENTE guardada.");

            ES.escribirLn("Guardando informacion de los vehiculos.");
            for (int i = 0; i < lVehiculos.size(); i++) {
                ES.escribirArchivo(_rutaVeh, lVehiculos.get(i).escribirFichero(), (i==0));
                ES.escribir("-");
            }
            ES.escribirLn("Informacion VEHICULOS guardada.");

            ES.escribirLn("Guardando informacion de los alquileres.");
            for (int i = 0; i < lAlquileres.size(); i++) {
                ES.escribirArchivo(_rutaAlq, lAlquileres.get(i).escribirFichero(), (i==0));
                ES.escribir("-");
            }
            ES.escribirLn("Informacion ALQUILERES guardada.");
            
            exito = true;
        }
        catch(Exception e) 
        {
            ES.escribirCl("Error al guardar los datos: " + e + "\n", "ANSI_RED");
        }
        
        return exito;
    } 
    
    public static boolean leerDatos(String _rutaCli, String _rutaVeh, String _rutaAlq)
    {
        boolean exito = false;
        
        ES.escribirLn("\nLeyendo datos...");
        try 
        {
            String cadenaClientes = ES.leerArchivo(_rutaCli);
            
            if (cadenaClientes != null) 
            {
                String [] datosClientes = cadenaClientes.split("\n");
            
                for (int i = 0; i < datosClientes.length; i++) {
                    String [] datos = datosClientes[i].split("#");
                    crearClienteConDatos(datos);
                }
            }
            
            
            String cadenaVehiculos = ES.leerArchivo(_rutaVeh);
            if (cadenaVehiculos != null)
            {
                String [] datosVehiculos = cadenaVehiculos.split("\n");
            
                for (int i = 0; i < datosVehiculos.length; i++) {
                    String [] datos = datosVehiculos[i].split("#");
                    crearVehiculoConDatos(datos);
                }
            }
            
            
            String cadenaAlquileres = ES.leerArchivo(_rutaAlq);
            if (cadenaAlquileres != null && cadenaClientes != null && cadenaVehiculos !=null)
            {
                String [] datosAlquileres = cadenaAlquileres.split("\n");
            
                for (int i = 0; i < datosAlquileres.length; i++) {
                    String [] datos = datosAlquileres[i].split("#");
                    crearAlquilerConDatos(datos);
                }
            }
            
            
        }
        catch (Exception e)
        {
            ES.escribirCl("Error al leer los datos: " + e + "\n", "ANSI_RED");
        }
        
        return exito;
    }
    
    
    public static void crearCopiaDeSeguridad() {
        // Definimos un formato seguro para archivos (sin ":" ni "/")
        DateTimeFormatter formatoSeguro = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String fechaTexto = LocalDateTime.now().format(formatoSeguro);

        String directorio = RUTA_BACKUPS + fechaTexto;
        crearDirectorio(directorio);

        guardarDatos(directorio + "\\clientes_RLC.dat" , directorio + "\\vehiculos_RLC.dat", directorio + "\\alquileres_RLC.dat");
    
    }

    public static void crearDirectorio(String _directorio) {
        try {
            File directorio = new File(_directorio);
            // .mkdirs() crea carpetas de forma recursiva si los padres no existen
            if (directorio.mkdirs()) {
                ES.escribirLn("Copia de seguridad: " + _directorio + " creada");
            } else if (directorio.exists()) {
                ES.escribirLn("El directorio ya existe.");
            } else {
                System.err.println("No se pudo crear el directorio.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public static void recuperarCopiaDeSeguridad()
    {
        File [] copias = listarCopiasDeSeguridad();
        
        if (copias == null || copias.length == 0) {
            System.out.println("No hay copias de seguridad disponibles.");
            return;
        }
        
        // DELICADO: LIMPIAR DATOS ANTES DE CARGAR
        
        limpiarDatosDeListas();
        
        // El rango es de 1 hasta el total de copias
        int opcion = ES.leerEntero("Elija el numero de copia: ", 1, copias.length);

        File copiaSeleccionada = copias[opcion - 1];
        
        leerDatos(copiaSeleccionada.getPath() + "\\clientes_RLC.dat", copiaSeleccionada.getPath() + "\\vehiculos_RLC.dat", copiaSeleccionada.getPath() + "\\alquileres_RLC.dat");
    }
    
    public static File[] listarCopiasDeSeguridad() {
        File carpetaPadre = new File(RUTA_BACKUPS);

        File[] copias = null;
        // Verificamos si la ruta existe y es un directorio
        if (carpetaPadre.exists() && carpetaPadre.isDirectory()) {

            // Filtramos para obtener solo los directorios
            copias = carpetaPadre.listFiles(File::isDirectory);

            if (copias != null && copias.length > 0) {
                ES.escribirLn("--- Lista de Copias de Seguridad ---");
                int contador = 1;
                for (File copia : copias) {
                    System.out.println(contador + ".- " + copia.getName());
                    contador++;
                }
            } else {
                ES.escribirLn("No se encontraron copias de seguridad.");
            }
        } else {
            System.err.println("La ruta de backups no es válida o no existe.");
        }
        
        return copias;
    }
    
    private static void guardarXML()
    {
        try
        {
            
            // 1. CREAR DOCUMENTO
             // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
             // Crear un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
             // Crear un DOMImplementation
             // DOMImplementation implementation = builder.getDOMImplementation();
             // Crear un documento con un elemento raiz
            Document documento = builder.newDocument() ;
             // documento.setXmlVersion("1.0");

            // 2. DEFINIR ELEMENTO RAÍZ
            ES.escribirLn(" --------->   Escribiendo fichero XML");
            Element elementoRaiz = documento.createElement(ET_ALQUILERVEHICULOS);
            documento.appendChild(elementoRaiz);
            
            // 3. AÑADIR DATOS
            ES.escribirLn("Guardando informacion de los clientes.");
            for(  int i = 0; i < lClientes.size(); i++) 
            {
                Element eUsuario = lClientes.get(i).escribirXML( documento) ;
                elementoRaiz.appendChild( eUsuario);
                ES.escribir("-");
            }
            ES.escribirLn("Informacion CLIENTE guardada.");
            
            ES.escribirLn("Guardando informacion de los vehiculos.");
            for(  int i = 0; i < lVehiculos.size(); i++) 
            {
                Element eUsuario = lVehiculos.get(i).escribirXML( documento) ;
                elementoRaiz.appendChild( eUsuario);
                ES.escribir("-");
            }
            ES.escribirLn("Informacion VEHICULOS guardada.");
            
            ES.escribirLn("Guardando informacion de los alquileres.");
            for(  int i = 0; i < lAlquileres.size(); i++) 
            {
                Element eUsuario = lAlquileres.get(i).escribirXML( documento) ;
                elementoRaiz.appendChild( eUsuario);
                ES.escribir("-");
            }
            ES.escribirLn("Informacion ALQUILERES guardada.");
           
            // 4. TRANSFORMAR Y GUARDAR
            // Asociar el source con el Document
            Source fuente = new DOMSource(documento);

            // Crear el Result, indicado que fichero se va a crear
            Result resultado = new StreamResult(new File( NOMBRE_XML));

            // Creo un transformer, se crea el fichero XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            //Insertar saltos de línea al final de cada línea
            transformer.setOutputProperty( OutputKeys.INDENT, "yes");
            transformer.transform( fuente, resultado);
           

            System.out.println("----------------------------------------------");
      }
      catch( ParserConfigurationException | TransformerException ex)
      {
         System.out.println(ex.getMessage());         
      }
      
    }
    
    private static void leerXML()
    {
        // DELICADO: LIMPIAR DATOS ANTES DE CARGAR
        
        limpiarDatosDeListas();
      
        System.out.println(" --------->   Lectura fichero XML");
        try{
         
            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Crear un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Obtener el documento, a partir del XML
            Document documento = builder.parse(new File(NOMBRE_XML));
            

            // lectura y cargar los clientes
            // Coger todas las etiquetas
            NodeList listaNodosClientes = null;
            listaNodosClientes = documento.getElementsByTagName("Cliente");
            
            
            for (int i = 0; i < listaNodosClientes.getLength(); i++) {
                // Cojo el nodo actual
                Node nodoClientes = listaNodosClientes.item(i);

                // Comprobar si el nodo es un elemento
                if (nodoClientes.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element e = (Element) nodoClientes;
      
                    String [] datosCliente = new String [6];
                    datosCliente[0] = e.getElementsByTagName("DNI").item(0).getTextContent();
                    datosCliente[1] = e.getElementsByTagName("nombre").item(0).getTextContent();
                    datosCliente[2] = e.getElementsByTagName("direccion").item(0).getTextContent();
                    datosCliente[3] = e.getElementsByTagName("localidad").item(0).getTextContent();
                    datosCliente[4] = e.getElementsByTagName("cp").item(0).getTextContent();
                    datosCliente[5] = e.getElementsByTagName("baja").item(0).getTextContent();
                    
                    
                    crearClienteConDatos(datosCliente);
                }
            }
            
            // lectura y cargar los deportivos
            // Coger todas las etiquetas
            NodeList listaNodosDeportivos = null;
            listaNodosDeportivos = documento.getElementsByTagName("Deportivo");
            
            
            for (int i = 0; i < listaNodosDeportivos.getLength(); i++) {
                // Cojo el nodo actual
                Node nodoDeportivos = listaNodosDeportivos.item(i);

                // Comprobar si el nodo es un elemento
                if (nodoDeportivos.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element e = (Element) nodoDeportivos;
      
                    String [] datosDeportivo = new String [11];
                    
                    String matricula = e.getElementsByTagName("matricula").item(0).getTextContent();
                    String marca = e.getElementsByTagName("marca").item(0).getTextContent();
                    String modelo = e.getElementsByTagName("modelo").item(0).getTextContent();
                    int cilindrada = Integer.parseInt( e.getElementsByTagName("cilindrada").item(0).getTextContent());
                    datosDeportivo[7] = e.getElementsByTagName("npuertas").item(0).getTextContent();
                    datosDeportivo[8] = e.getElementsByTagName("combustible").item(0).getTextContent();
                    datosDeportivo[9] = e.getElementsByTagName("descapotable").item(0).getTextContent();
                    datosDeportivo[10] = e.getElementsByTagName("cambio").item(0).getTextContent();
                    
                    anadirVehiculo(datosDeportivo(matricula, marca, modelo, cilindrada, datosDeportivo));
                }
            }
            
            // lectura y cargar los familiares
            // Coger todas las etiquetas
            NodeList listaNodosFamiliares = null;
            listaNodosFamiliares = documento.getElementsByTagName("Familiar");
            
            
            for (int i = 0; i < listaNodosFamiliares.getLength(); i++) {
                // Cojo el nodo actual
                Node nodoFamiliares = listaNodosFamiliares.item(i);

                // Comprobar si el nodo es un elemento
                if (nodoFamiliares.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element e = (Element) nodoFamiliares;
      
                    String [] datosFamiliar = new String [11];
                    
                    String matricula = e.getElementsByTagName("matricula").item(0).getTextContent();
                    String marca = e.getElementsByTagName("marca").item(0).getTextContent();
                    String modelo = e.getElementsByTagName("modelo").item(0).getTextContent();
                    int cilindrada = Integer.parseInt( e.getElementsByTagName("cilindrada").item(0).getTextContent());
                    datosFamiliar[7] = e.getElementsByTagName("npuertas").item(0).getTextContent();
                    datosFamiliar[8] = e.getElementsByTagName("combustible").item(0).getTextContent();
                    datosFamiliar[9] = e.getElementsByTagName("nplazas").item(0).getTextContent();
                    datosFamiliar[10] = e.getElementsByTagName("sillabebe").item(0).getTextContent();
                    
                    anadirVehiculo(datosFamiliar(matricula, marca, modelo, cilindrada, datosFamiliar));
                }
            }
            
            // lectura y cargar las furgonetas
            // Coger todas las etiquetas
            NodeList listaNodosFurgonetas = null;
            listaNodosFurgonetas = documento.getElementsByTagName("Furgoneta");
            
            
            for (int i = 0; i < listaNodosFurgonetas.getLength(); i++) {
                // Cojo el nodo actual
                Node nodoFurgonetas = listaNodosFurgonetas.item(i);

                // Comprobar si el nodo es un elemento
                if (nodoFurgonetas.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element e = (Element) nodoFurgonetas;
      
                    String [] datosFamiliar = new String [11];
                    
                    String matricula = e.getElementsByTagName("matricula").item(0).getTextContent();
                    String marca = e.getElementsByTagName("marca").item(0).getTextContent();
                    String modelo = e.getElementsByTagName("modelo").item(0).getTextContent();
                    int cilindrada = Integer.parseInt( e.getElementsByTagName("cilindrada").item(0).getTextContent());
                    datosFamiliar[7] = e.getElementsByTagName("pma").item(0).getTextContent();
                    datosFamiliar[8] = e.getElementsByTagName("volumen").item(0).getTextContent();
                    datosFamiliar[9] = e.getElementsByTagName("refrigerado").item(0).getTextContent();
                    datosFamiliar[10] = e.getElementsByTagName("tamano").item(0).getTextContent();
                    
                    anadirVehiculo(datosFurgoneta(matricula, marca, modelo, cilindrada, datosFamiliar));
                }
            }
            
            // lectura y cargar los alquileres
            // Coger todas las etiquetas
            NodeList listaNodosAlquileres = null;
            listaNodosAlquileres = documento.getElementsByTagName("Alquiler");
            
            
            for (int i = 0; i < listaNodosAlquileres.getLength(); i++) {
                // Cojo el nodo actual
                Node nodoAlquileres = listaNodosAlquileres.item(i);

                // Comprobar si el nodo es un elemento
                if (nodoAlquileres.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element e = (Element) nodoAlquileres;
      
                    String [] datosAlquiler = new String [5];
                    
                    datosAlquiler[0] = e.getElementsByTagName("cliente").item(0).getTextContent();
                    datosAlquiler[1] = e.getElementsByTagName("vehiculo").item(0).getTextContent();
                    datosAlquiler[2] = e.getElementsByTagName("fecha").item(0).getTextContent();
                    datosAlquiler[3] = e.getElementsByTagName("fDevolucion").item(0).getTextContent();
                    
                    crearAlquilerConDatos(datosAlquiler);
                }
            }
            

        } catch (IOException | ParserConfigurationException | DOMException | SAXException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private static void limpiarDatosDeListas()
    {
        lClientes.clear();
        lVehiculos.clear();
        lAlquileres.clear();
    }
    
}