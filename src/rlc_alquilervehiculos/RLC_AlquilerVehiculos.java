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
    
    private static final int MAX_VEHICULOS = 5;
    private static final int MAX_CLIENTES = 5;
    private static final int MAX_ALQUILERES = 5;
    
    private static Vehiculo [] vehiculos;
    private static Cliente [] clientes;
    private static Alquiler [] alquileres;
    
    public static int nClientes = 0;
    public static int nVehiculos = 0;
    
    
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
        
        do 
        {
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
                    if (nClientes < clientes.length)
                        
                        anadirCliente(clientes[nClientes]);
                    else
                        ES.escribirCl("Error: No se pueden anadir mas clientes", "ANSI_RED");
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
        ES.escribirCl("\t2. Borrar cliente\n", "ANSI_GREEN");
        ES.escribirCl("\t3. Listar clientes\n", "ANSI_GREEN");
        ES.escribirCl("\t4. Anadir vehiculo\n", "ANSI_YELLOW");
        ES.escribirCl("\t5. Borrar vehiculo\n", "ANSI_YELLOW");
        ES.escribirCl("\t6. Listar vehiculos\n", "ANSI_YELLOW");
        ES.escribirCl("\t7. Abrir un alquiler\n", "ANSI_BLUE");
        ES.escribirCl("\t8. Cerrar un alquiler\n", "ANSI_BLUE");
        ES.escribirCl("\t9. Listar alquileres\n", "ANSI_BLUE");
        ES.escribirLn("");
        ES.escribirCl("0. SALIR\n", "ANSI_BLACK");
        ES.escribirCl("--------------------------------\n", "ANSI_PURPLE");
        ES.escribirCl("Escriba la opcion: ", "ANSI_CYAN");
        
    }
    
    private static Cliente getCliente(String _dni) 
    {
        boolean encontrado = false;
        Cliente cliente = null;
        
        for( int i = 0; i < nClientes && !encontrado; i++)
        {
            if(clientes[i].getDni().equals(_dni)) 
            {
                encontrado = true;
                cliente = clientes[i];
            }
        }
        
        return cliente;
    }
    
    private static void anadirCliente(Cliente nuevoCliente) 
    {
        String dni, nombre, direccion, localidad, codigoPostal;
        
        do 
        {
            dni = ES.leerCadena("Introduca su DNI/NIE: ", 9);
        }
        while (Utilidades.comprobarDni(dni) == false);
        
        if (getCliente(dni) == null) 
        {
            nombre = ES.leerCadena("Introduzca su nombre: ");
            direccion = ES.leerCadena("Intruzca su direccion: ");
            localidad = ES.leerCadena("Introduzca su localidad: ");
        
            do
            {
                codigoPostal = ES.leerCadena("Introduzca su codigo postal: ", 5);
            }
            while (Utilidades.comprobarCodigoPostal(codigoPostal) == false);
        
            nuevoCliente = new Cliente(dni, nombre, direccion, localidad, codigoPostal);
            nClientes++;
        } else
        {
            nuevoCliente = null;
            System.out.println("El cliente ya existe. ");
        }
        
    }
    
    private static void borrarCliente(String _dni) 
    {
        
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
    
    private static void anadirVehiculo(Cliente nuevoVehiculo) 
    {
        
    }
    
    private static void borrarVehiculo(String blabla) 
    {
        
    }
    
    private static void nuevoAlquiler(Cliente cliente, Vehiculo vehiculo)
    {
        
    }
    
    private static void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo)
    {
        
    }
    
    
    
}
