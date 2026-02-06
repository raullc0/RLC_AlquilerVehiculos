/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;

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
     * Metodo: escribir(_msg: String): void Escribe una cadena
     *
     * @param _cadena Cadena a introducir
     */
    public static void escribir(String _cadena) {
        System.out.print(_cadena);
    }

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
     * Metodo: escribirLn(_msg: String): void Escribe una linea de texto
     *
     * @param _cadena Cadena a introducir
     */
    public static void escribirLn(String _cadena) {
        System.out.println(_cadena);
    }

    /**
     * Metodo: leerBoolean(): boolean Lee y valida un boolean
     *
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

    public static String leerCadena() {
        String cadena = "";

        cadena = s.nextLine();

        return cadena;
    }

    public static String leerCadena(String _msg) {
        String cadena = "";
        System.out.print(_msg);

        cadena = s.nextLine();

        return cadena;
    }

    public static String leerCadena(String _msg, int _longitud) {

        boolean datoValido = false;

        String cadena = "";
        do {
            try {
                System.out.print(_msg);
                cadena = s.nextLine();

                if (cadena.length() == _longitud) {
                    datoValido = true;
                } else {
                    System.out.printf("Debe ser una cadena de longitud " + _longitud);
                }
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto.");
                System.out.println(" Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return cadena;
    }

    public static String leerCaracter() {

        boolean datoValido = false;

        String cadena = "";
        do {
            try {
                cadena = s.nextLine();

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

    public static String leerCaracter(String _msg) {

        boolean datoValido = false;

        String cadena = "";
        do {
            try {
                System.out.print(_msg);
                cadena = s.nextLine();

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

    public static boolean siono() {
        boolean respuesta = false;
        boolean datoValido = false;

        do {
            String cadena = "";
            cadena = s.nextLine();
            
            switch (cadena) {
                case "Si", "si", "SI", "s", "S", "Yes", "YES", "Y", "y":
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
    
    public static void simularPausa() 
    {
        Scanner waitForKeypress = new Scanner(System.in);
        ES.escribirLn("PRESIONE ENTER PARA CONTINUAR ...");
        waitForKeypress.nextLine();
    }
    
    public static String toUpperCase(String string) 
    {
        return string.toUpperCase();
    }

}
