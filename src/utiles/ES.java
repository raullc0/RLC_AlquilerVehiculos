/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


/**
 *
 * @author dam1
 */
public class ES {

    // Constructor
    ES() {
    }

    // Metodos
    static Scanner s = new Scanner(System.in);

    /**
     * Metodo: escribir(_msg: String): void Escribe una cadena.
     * @param _cadena Cadena a escribir
     */
    public static void escribir(String _cadena) {
        System.out.print(_cadena);
    }

    /**
     * Metodo: escribirCl(String _cadena, String _color): void Escribe una cadena en un color especificado.
     * @param _cadena Cadena a escribir
     * @param _color Color a utilizar. Lista limitada : "ANSI_"+[BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE]
     */
    public static void escribirCl(String _cadena, String _color) {
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";
        final String ANSI_RESET = "\u001B[0m";

        switch (_color) {
            case "ANSI_BLACK" ->
                System.out.printf(ANSI_BLACK + _cadena + ANSI_RESET);
            case "ANSI_RED" ->
                System.out.printf(ANSI_RED + _cadena + ANSI_RESET);
            case "ANSI_GREEN" ->
                System.out.printf(ANSI_GREEN + _cadena + ANSI_RESET);
            case "ANSI_YELLOW" ->
                System.out.printf(ANSI_YELLOW + _cadena + ANSI_RESET);
            case "ANSI_BLUE" ->
                System.out.printf(ANSI_BLUE + _cadena + ANSI_RESET);
            case "ANSI_PURPLE" ->
                System.out.printf(ANSI_PURPLE + _cadena + ANSI_RESET);
            case "ANSI_CYAN" ->
                System.out.printf(ANSI_CYAN + _cadena + ANSI_RESET);
            case "ANSI_WHITE" ->
                System.out.printf(ANSI_WHITE + _cadena + ANSI_RESET);
        }

    }

    /**
     * Metodo: escribirLn(String _cadena): void Escribe una linea de texto.
     * @param _cadena Cadena a introducir
     */
    public static void escribirLn(String _cadena) {
        System.out.println(_cadena);
    }

    /**
     * Metodo: leerBoolean(): boolean Lee un boolean-
     * @return Devuelve el valor del boolean
     */
    public static boolean leerBoolean() {
        boolean datoValido = false;

        boolean num = false;
        do {
            try {
                num = Boolean.parseBoolean(s.nextLine());

                datoValido = true;
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerBoolean(String _msg): boolean Lee un boolean y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @return Devuelve el valor del boolean
     */
    public static boolean leerBoolean(String _msg) {
        boolean datoValido = false;

        boolean num = false;
        do {
            try {
                System.out.print(_msg);
                num = Boolean.parseBoolean(s.nextLine());

                datoValido = true;
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }
    
    /**
     * Metodo: leerByte(): byte Lee un byte.
     * @return Devuelve el valor del byte
     */
    public static byte leerByte() {
        boolean datoValido = false;

        byte num = 0;
        do {
            try {
                num = Byte.parseByte(s.nextLine());

                datoValido = true;
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerByte(String _msg): byte Lee un byte y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @return Devuelve el valor del byte
     */
    public static byte leerByte(String _msg) {
        boolean datoValido = false;

        byte num = 0;
        do {
            try {
                System.out.print(_msg);
                num = Byte.parseByte(s.nextLine());

                datoValido = true;
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto. ");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerByte(String _msg, byte _min, byte _max): byte Lee un byte (entre un minimo y un maximo) y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @param _min Minimo valor del byte
     * @param _max Maximo valor del byte
     * @return Devuelve el valor del byte
     */
    public static byte leerByte(String _msg, byte _min, byte _max) {

        boolean datoValido = false;

        byte num = 0;
        do {
            try {
                System.out.print(_msg);
                num = Byte.parseByte(s.nextLine());

                if (num >= _min && num <= _max) {
                    datoValido = true;
                } else {
                    System.out.println("Debe ser un número entre " + _min + " y " + _max);
                }
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }
    
    /**
     * Metodo: leerCadena(): String Lee una cadena.
     * @return Devuelve el valor de la cadena
     */
    public static String leerCadena() {
        String cadena = "";

        cadena = s.nextLine();
        
        cadena = cadena.replace('#', ' ');

        return cadena;
    }

    /**
     * Metodo: leerCadena(): String Lee una cadena y escribe un menaje.
     * @param _msg Mensaje a escribir
     * @return Devuleve el valor de la cadena
     */
    public static String leerCadena(String _msg) {
        String cadena = "";
        System.out.print(_msg);

        cadena = s.nextLine();
        cadena = cadena.replace('#', ' ');

        return cadena;
    }

    /**
     * Metodo: leerCadena(String _msg, int _longitud): String Lee una cadena (de una longitud indicada) y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @param _longitud Longitud de la cadena
     * @return Devuleve el valor de la cadena
     */
    public static String leerCadena(String _msg, int _longitud) {

        boolean datoValido = false;

        String cadena = "";
        do {
            try {
                System.out.print(_msg);
                cadena = s.nextLine();
                cadena = cadena.replace('#', ' ');

                if (cadena.length() == _longitud) {
                    datoValido = true;
                } else {
                    System.out.println("Debe ser una cadena de longitud " + _longitud);
                }
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println(" Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return cadena;
    }

    /**
     * Metodo: leerCaracter(): String Lee una cadena de longitud 1. Debe hacerse un parseChar() para obtener un char.
     * @return Devuleve el valor de la cadena
     */
    public static String leerCaracter() {

        boolean datoValido = false;

        String cadena = "";
        do {
            try {
                cadena = s.nextLine();
                cadena = cadena.replace('#', ' ');

                if (cadena.length() == 1) {
                    datoValido = true;
                } else {
                    System.out.println("Debe ser solo un caracter.");
                }
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return cadena;
    }

    /**
     * Metodo: leerCaracter(String _msg): String Lee una cadena de longitud 1 y escribe un mensaje. Debe hacerse un parseChar() para obtener un char.
     * @param _msg Mensaje a escribir
     * @return Devuleve el valor de la cadena
     */
    public static String leerCaracter(String _msg) {

        boolean datoValido = false;

        String cadena = "";
        do {
            try {
                System.out.print(_msg);
                cadena = s.nextLine();
                cadena = cadena.replace('#', ' ');

                if (cadena.length() == 1) {
                    datoValido = true;
                } else {
                    System.out.println("Debe ser solo un caracter.");
                }
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return cadena;
    }

    /**
     * Metodo: leerEntero(): int Lee un int.
     * @return Devuleve el valor del int
     */
    public static int leerEntero() {

        boolean datoValido = false;

        int num = 0;
        do {
            try {
                num = Integer.parseInt(s.nextLine());

                datoValido = true;

            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerEntero(String _msg): int Lee un int y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @return Devuleve el valor del int
     */
    public static int leerEntero(String _msg) {

        boolean datoValido = false;

        int num = 0;
        do {
            try {
                System.out.print(_msg);
                num = Integer.parseInt(s.nextLine());

                datoValido = true;

            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println(" Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerEntero(String _msg, byte _min): int Lee un int (con un minimo especificado) y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @param _min Minimo valor del int
     * @return Devuleve el valor del int
     */
    public static int leerEntero(String _msg, byte _min) {

        boolean datoValido = false;

        int num = 0;
        do {
            try {
                System.out.print(_msg);
                num = Integer.parseInt(s.nextLine());

                if (num >= _min) {
                    datoValido = true;
                } else {
                    System.out.println("Debe ser un número entre mayor que " + _min);
                }
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerEntero(String _msg, byte _min, byte _max): int Lee un int (con un minimo y maximo especificados) y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @param _min Minimo valor del int
     * @param _max Maximo valor del int
     * @return Devuleve el valor del int
     */
    public static int leerEntero(String _msg, byte _min, byte _max) {

        boolean datoValido = false;

        int num = 0;
        do {
            try {
                System.out.print(_msg);
                num = Integer.parseInt(s.nextLine());

                if (num >= _min && num <= _max) {
                    datoValido = true;
                } else {
                    System.out.println("Debe ser un número entre " + _min + " y " + _max);
                }
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }
    
    /**
     * Metodo: leerEntero(String _msg, int _min, int _max): int Lee un int (con un minimo y maximo especificados) y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @param _min Minimo valor del int
     * @param _max Maximo valor del int
     * @return Devuleve el valor del int
     */
    public static int leerEntero(String _msg, int _min, int _max) {

        boolean datoValido = false;

        int num = 0;
        do {
            try {
                System.out.print(_msg);
                num = Integer.parseInt(s.nextLine());

                if (num >= _min && num <= _max) {
                    datoValido = true;
                } else {
                    System.out.println("Debe ser un número entre " + _min + " y " + _max);
                }
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerEnteroLargo(): long Lee un long.
     * @return Devuelve el valor del long
     */
    public static long leerEnteroLargo() {

        boolean datoValido = false;

        long num = 0;
        do {
            try {
                num = Long.parseLong(s.nextLine());

                datoValido = true;

            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerEnteroLargo(String _msg): long Lee un long y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @return Devuelve el valor del long
     */
    public static long leerEnteroLargo(String _msg) {

        boolean datoValido = false;

        long num = 0;
        do {
            try {
                System.out.print(_msg);
                num = Long.parseLong(s.nextLine());

                datoValido = true;

            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerReal(): float Lee un float.
     * @return Devuelve el valor del float
     */
    public static float leerReal() {

        boolean datoValido = false;

        float num = 0f;
        do {
            try {
                num = Float.parseFloat(s.nextLine());

                datoValido = true;

            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerReal(String _msg): float Lee un float y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @return Devuelve el valor del float
     */
    public static float leerReal(String _msg) {

        boolean datoValido = false;

        float num = 0f;
        do {
            try {
                System.out.print(_msg);
                num = Float.parseFloat(s.nextLine());

                datoValido = true;

            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerReal(String _msg, byte _min): float Lee un float (con un minimo especificado) y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @param _min Valor minimo del float
     * @return Devuelve el valor del float
     */
    public static float leerReal(String _msg, byte _min) {

        boolean datoValido = false;

        float num = 0f;
        do {
            try {
                System.out.print(_msg);
                num = Float.parseFloat(s.nextLine());

                if (num >= _min) {
                    datoValido = true;
                } else {
                    System.out.println("Debe ser un número entre mayor que " + _min);
                }
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerRealLargo(): double Lee un double.
     * @return Devuelve el valor del double
     */
    public static double leerRealLargo() {

        boolean datoValido = false;

        double num = 0;
        do {
            try {
                num = Double.parseDouble(s.nextLine());

                datoValido = true;

            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    /**
     * Metodo: leerRealLargo(String _msg): double Lee un double y escribe un mensaje.
     * @param _msg Mensaje a escribir
     * @return Devuelve el valor del double
     */
    public static double leerRealLargo(String _msg) {

        boolean datoValido = false;

        double num = 0;
        do {
            try {
                System.out.print(_msg);
                num = Double.parseDouble(s.nextLine());

                datoValido = true;

            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println("Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }
    
    /**
     * Metodo: siono(): boolean Lee mensajes arbitrarios del usuario de si y no.
     * @return Devuelve un boolean. Si(true),  No(false)
     */
    public static boolean siono() {
        boolean respuesta = false;
        boolean datoValido = false;

        do {
            String cadena = "";
            cadena = s.nextLine();
            
            switch (cadena) {
                case "Si", "si", "SI", "s", "S", "Yes", "yes","YES", "y", "Y":
                    respuesta = true;
                    datoValido = true;
                    break;
                case "No", "no", "NO", "n", "N":
                    respuesta = false;
                    datoValido = true;
                    break;
            }
        }
        while (!datoValido);

        return respuesta;
    }
    
    /**
     * Metodo: simularPausa(): void Simula una pausa y espera a que el usuario pulse intro.
     */
    public static void simularPausa() 
    {
        Scanner waitForKeypress = new Scanner(System.in);
        ES.escribirLn("\nPRESIONE ENTER PARA CONTINUAR ...");
        waitForKeypress.nextLine();
    }
    
    /**
     * Metodo: toUpperCase(String string): String Cambia una cadena a MAYUSCULAS.
     * @param string Cadena a introducir
     * @return Cadena en mayusculas
     */
    public static String toUpperCase(String string) 
    {
        return string.toUpperCase();
    }
    
    /**
     * Metodo: escribirArchivo(String ruta, String datos, boolean sobreescribir): boolean Escribe datos en un archivo de ruta elegida, sobreescribiendo o no
     * @param ruta Ruta del archivo
     * @param datos Datos a escribir
     * @param sobreescribir Boolean que indica si el dato debe sobreescribir o no.
     * @return Indica si los datos se han escrito con exito
     */
    public static boolean escribirArchivo(String ruta, String datos, boolean sobreescribir)
    {
        FileWriter archivo;
        boolean exito = false;
        
        try
        {
            archivo = new FileWriter(ruta, !sobreescribir);
            
            archivo.write(datos);
            archivo.close();
            exito = true;
        }
        catch(FileNotFoundException e) 
        {
            ES.escribirCl("Error (escribirArchivo): Archivo no encontrado. " + e, "ANSI_RED");
        }
        catch(Exception e)
        {
            ES.escribirCl("Error (escribirArchivo): " + e, "ANSI_RED");
        }
        
        return exito;
    }
    
    /**
     * Metodo: leerArchivo(String ruta): String Lee datos de un archivo de una ruta elegida.
     * @param ruta Ruta del archivo
     * @return Indica si los datos se han escrito con exito
     */
    public static String leerArchivo(String ruta)
    {
        String contenido = null;
        
        try {
            contenido = Files.readString(Path.of(ruta));
            if (!contenido.isEmpty())
                ES.escribirLn("Leyendo el contenido del fichero...");
        } catch (IOException e) {
            ES.escribirLn("No se ha encontrado el archivo " + ruta);
        } catch (Exception e) {
            ES.escribirCl("ERROR (leerArchivo): " + e, "ANSI_RED");
        }
        
        return contenido;
    }
    
 
}
