/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rlc_alquilervehiculos;

import utiles.ES;
import utiles.Utilidades;

/**
 *
 * @author dam1
 */
public class RLC_AlquilerVehiculos {

    // Atributos
    
    /*
        Importante: ya que los datos no se borran, 
        se debe establecer un limite alto si se 
        quieren cambiar datos con fecuencia
    */
    private static final int MAX_VEHICULOS = 50; 
    private static final int MAX_CLIENTES = 50;
    private static final int MAX_ALQUILERES = 50;
    
    private static Vehiculo [] vehiculos;
    private static Cliente [] clientes;
    private static Alquiler [] alquileres;
    
    public static int nClientes = 0;
    public static int nVehiculos = 0;
    public static int nAlquileres = 0;
    
    
    // Main
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Dar memoria a los arrays
        vehiculos = new Vehiculo[MAX_VEHICULOS];
        clientes = new Cliente[MAX_CLIENTES];
        alquileres = new Alquiler[MAX_ALQUILERES];
        
        // Logica del programa
        int opcionMenu = 0;
        String dni, matricula;
        
        do 
        {
            try 
            {
                new ProcessBuilder("cmd", "/C", "cls").inheritIO().start().waitFor();
            }
            catch (Exception e) {}
            menu();
            opcionMenu = ES.leerEntero();
            
            switch (opcionMenu) 
            {
                case 0:
                    ES.escribirCl("Esta a punto de salir del programa,\nesta seguro? Si / No\n", "ANSI_RED");
                    boolean respuesta = ES.siono();
                    
                    if (respuesta == false)
                        opcionMenu = -1;
                    break;
                case 1:
                    anadirCliente(pedirDatosCliente());
                    break;
                case 2:
                    borrarCliente(pedirDNI());
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
                    borrarVehiculo(pedirMatricula());
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
            }
        }
        while(opcionMenu != 0);
        
    }
    
    // Metodos
    
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
        ES.escribirCl("0. SALIR\n", "ANSI_BLACK");
        ES.escribirCl("--------------------------------\n", "ANSI_PURPLE");
        ES.escribirCl("Escriba la opcion: ", "ANSI_CYAN");
        
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
    
    private static Cliente getCliente(String _dni) 
    {
        boolean encontrado = false;
        Cliente cliente = null;
        
        for( int i = 0; i < nClientes && !encontrado; i++)
        {
            if(clientes[i] != null)
            {
                if(clientes[i].getDni().equals(_dni)) 
                {
                    encontrado = true;
                    cliente = clientes[i];
                }
            }  
        }
        
        return cliente;
    }
    
    private static void anadirCliente(Cliente nuevoCliente) 
    {
        if (nClientes < MAX_CLIENTES) 
        {
            if (getCliente(nuevoCliente.getDni()) == null) 
            {
                clientes[nClientes] = nuevoCliente;
                nClientes++;
            }
            else
                ES.escribirCl("Error: El cliente con dicho DNI ya existe\n", "ANSI_RED");
        }
        else
            ES.escribirCl("Error: No hay mas espacio para nuevos clientes\n", "ANSI_RED");
    }
    
    private static void borrarCliente(String _dni) 
    {
        // Debido a que no queremos perder datos, daremos de baja en vez de establecer a nulo
        if (getCliente(_dni) != null) 
        {
            getCliente(_dni).toString();
            ES.escribirCl("Esta seguro de dar de baja al cliente? Si/No\n", "ANSI_RED");
            if (ES.siono() == true)
                getCliente(_dni).darDeBaja();
        }
        else
            ES.escribirCl("Error: El cliente con dicho DNI no existe.\n", "ANSI_RED");
    }
    
    private static void listarClientes(boolean deBaja) 
    {
        for (int i = 0; i < nClientes; i++) {
            if (clientes[i].estaDeBaja() == deBaja)
            {
                ES.escribir(clientes[i].toString());
                ES.escribirLn("");
            }
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
        modelo = ES.leerCadena("Intruzca el modelo del vehiculo: ");
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
            case 1 -> vehiculo = datosDeportivo(matricula, marca, modelo, cilindrada);
            case 2 -> vehiculo = datosFamiliar(matricula, marca, modelo, cilindrada);
            case 3 -> vehiculo = datosFurgoneta(matricula, marca, modelo, cilindrada);
        }
        
        return vehiculo;
    }
    
    private static Deportivo datosDeportivo(String matricula, String marca, String modelo, int cilindrada)
    {
        
        int nPuertas = ES.leerEntero("Introduza el numero de puertas: ");

        Enumerados.TipoCombustible combustible =
            Enumerados.TipoCombustible.valueOf(
                ES.leerCadena("Introduzca el tipo de combustible (Gasolina/Diesel/Hibrido/Electrico): ").toUpperCase()
            );

        Enumerados.CajaCambio cambio =
            Enumerados.CajaCambio.valueOf(
                ES.leerCadena("Introduzca el tipo de caja der cambio (Manual/Automatica): ").toUpperCase()
            );

        ES.escribirLn("Es el deportivo descapotable? Si/No");
        boolean descapotable = ES.siono();

        return new Deportivo(cambio, descapotable, matricula, marca, modelo, cilindrada, combustible, nPuertas);
    }
    
    private static Familiar datosFamiliar(String matricula, String marca, String modelo, int cilindrada)
    {
        int nPuertas = ES.leerEntero("Introduza el numero de puertas: ");
        int nPlazas = ES.leerEntero("Introduzca el numero de plazas (4-7): ", (byte) 4, (byte) 7);
        
        ES.escribirLn("Tiene silla de bebe? Si/No");
        boolean sillaBebe = ES.siono();

        Enumerados.TipoCombustible combustible =
            Enumerados.TipoCombustible.valueOf(
                ES.leerCadena("Introduzca el tipo de combustible (Gasolina/Diesel/Hibrido/Electrico): ").toUpperCase()
            );


        return new Familiar(nPlazas, sillaBebe, matricula, marca, modelo, cilindrada, combustible, nPuertas);
    }
    
    private static Furgoneta datosFurgoneta(String matricula, String marca, String modelo, int cilindrada)
    {
        
        int pma = ES.leerEntero("Introduzca el Peso Maximo Autorizado: ", (byte)1);
        int volumen = ES.leerEntero("Introduzca el volumen: ", (byte)1);

        ES.escribirLn("Esta refrigerada? Si/No: ");
        boolean refrigerado = ES.siono();

        
        
        Enumerados.Tamano tamano =
            Enumerados.Tamano.valueOf(
                ES.leerCadena("Introduzca el tamano (Grande/Mediana/Pequenia): ").toUpperCase()
            );

        return new Furgoneta(refrigerado, tamano, pma, volumen, matricula, marca, modelo, cilindrada);
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
    
    private static Vehiculo getVehiculo(String _matricula)
    {
        boolean encontrado = false;
        Vehiculo vehiculo = null;
        
        for( int i = 0; i < nVehiculos && !encontrado; i++)
        {
            if(vehiculos[i].getMatricula().equals(_matricula)) 
            {
                encontrado = true;
                vehiculo = vehiculos[i];
            }
        }
        
        return vehiculo;
    }
    
    private static void anadirVehiculo(Vehiculo nuevoVehiculo) 
    {
        if (nVehiculos < MAX_VEHICULOS) 
        {
            if (getVehiculo(nuevoVehiculo.getMatricula()) == null) 
            {
                vehiculos[nVehiculos] = nuevoVehiculo;
                nVehiculos++;
            }
            else
                ES.escribirCl("Error: El vehiculo con dicha matrícula ya existe\n", "ANSI_RED");
        }
        else
            ES.escribirCl("Error: No hay mas espacio para nuevos vehiculos\n", "ANSI_RED");
    }
    
    private static void borrarVehiculo(String _matricula) 
    {
        // Debido a que no queremos perder datos, daremos de baja en vez de establecer a nulo
        if (getVehiculo(_matricula) != null) 
        {
            getVehiculo(_matricula).toString();
            ES.escribirCl("Esta seguro de dar de baja al vehiculo? Si/No\n", "ANSI_RED");
            if (ES.siono() == true)
                getVehiculo(_matricula).darDeBaja();
        }
        else
            ES.escribirCl("Error: El vehiculo con dicha MATRICULA no existe.\n", "ANSI_RED");
    }
    
    private static void listarVehiculos(boolean deBaja) 
    {
        for (int i = 0; i < nVehiculos; i++) {
            if(vehiculos[i].estaDeBaja() == deBaja)
            {
                ES.escribir(vehiculos[i].toString());
                ES.escribirLn("");
            }
        }
    }
    
    private static void nuevoAlquiler(Cliente cliente, Vehiculo vehiculo)
    {
        if (vehiculo.isDisponible() == true) 
        {
            if (nAlquileres < MAX_ALQUILERES) 
            {
                    alquileres[nAlquileres] = new Alquiler(cliente, vehiculo);
                    nAlquileres++;
            }
            else
                ES.escribirCl("Error: No hay mas espacio para nuevos alquileres\n", "ANSI_RED");
        }
        else
            ES.escribirCl("ERROR: El vehiculo no esta disponible para alquilar. ", "ANSI_RED");
    }
    
    
    private static void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo)
    {
        boolean encontrado = false;
        
        if (vehiculo.isDisponible() == false) 
        {
            for (int i = 0; i < nAlquileres; i++) 
            {
                if(alquileres[i].getCliente() == cliente)
                {
                    alquileres[i].cerrar();
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
        for (int i = 0; i < nAlquileres; i++) 
        {
            if(alquileres[i].getVehiculo().isDisponible() == false)
            {
                ES.escribir(alquileres[i].toString());
                ES.escribirLn("");
            }
        }
    }
    
    
    
}
