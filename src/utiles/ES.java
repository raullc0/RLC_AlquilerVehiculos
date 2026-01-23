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
public class ES 
{
    // Constructor
    ES(){}

    // Metodos
    
    static Scanner s = new Scanner(System.in);
    
    /**
     * Metodo: escribir(_msg: String): void
     * Escribe una cadena
     * @param _cadena Cadena a introducir
     */
    public static void escribir( String _cadena)
    {
        System.out.print( _cadena );
    }
    
    /**
     * Metodo: escribirLn(_msg: String): void
     * Escribe una linea de texto
     * @param _cadena Cadena a introducir
     */
    public static void escribirLn( String _cadena)
    {
        System.out.println( _cadena );
    }
    
    /**
     * Metodo: leerBoolean(): boolean
     * Lee y valida un boolean
     * @return Devuelve el valor del boolean
     */
    public static boolean leerBoolean()
    {
        boolean datoValido = false;
        
        boolean num = false;
        do 
        {
            try 
            {
                num = Boolean.parseBoolean( s.nextLine());
                
                datoValido = true;                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    public static boolean leerBoolean( String _msg)
    {
        boolean datoValido = false;
        
        boolean num = false;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Boolean.parseBoolean( s.nextLine());
                
                datoValido = true;                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    public static byte leerByte()
    {
        boolean datoValido = false;
        
        byte num = 0;
        do 
        {
            try 
            {
                num = Byte.parseByte( s.nextLine());
                
                datoValido = true;                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    public static byte leerByte( String _msg)
    {
        boolean datoValido = false;
        
        byte num = 0;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Byte.parseByte( s.nextLine());
                
                datoValido = true;                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    
    public static byte leerByte( String _msg, byte _min, byte _max)
    {
        
        boolean datoValido = false;
        
        byte num = 0;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Byte.parseByte(s.nextLine());
                
                if( num >= _min && num <= _max)
                    datoValido = true;
                else 
                    System.out.printf("Debe ser un número entre %d y %d.\n", _min, _max);
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    
    public static String leerCadena()
    {
        String cadena = "" ;
        
        cadena = s.nextLine();               
                
        return cadena ;
    }
    
    
    public static String leerCadena( String _msg)
    {
        String cadena = "" ;
        System.out.print( _msg);
        
        cadena = s.nextLine();               
                
        
        return cadena ;
    }
    
    public static String leerCadena( String _msg, int _longitud)
    {
        
        boolean datoValido = false;
        
        String cadena = "";
        do 
        {
            try 
            {
                System.out.print( _msg);
                cadena = s.nextLine();
                
                if( cadena.length() == _longitud)
                    datoValido = true;
                else 
                    System.out.printf("Debe ser una cadena de longitud " + _longitud);
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return cadena ;
    }
    
    public static String leerCaracter()
    {
        
        boolean datoValido = false;
        
        String cadena = "";
        do 
        {
            try 
            {
                cadena = s.nextLine();
                
                if( cadena.length() == 1)
                {
                    datoValido = true;
                }
                else 
                    System.out.printf("Debe ser solo un caracter");
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return cadena;
    }
    
    public static String leerCaracter( String _msg)
    {
        
        boolean datoValido = false;
        
        String cadena = "";
        do 
        {
            try 
            {
                System.out.print( _msg);
                cadena = s.nextLine();
                
                if( cadena.length() == 1)
                {
                    datoValido = true;
                }
                else 
                    System.out.printf("Debe ser solo un caracter");
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return cadena ;
    }
    
    
    
    public static int leerEntero()
    {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;
        
        int num = 0;
        do 
        {
            try 
            {
                num = Integer.parseInt( s.nextLine());
                
                
                datoValido = true;
                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    public static int leerEntero( String _msg)
    {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;
        
        int num = 0;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Integer.parseInt( s.nextLine());
                
                
                datoValido = true;
                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    
    public static int leerEntero( String _msg, byte _min)
    {
        
        boolean datoValido = false;
        
        int num = 0;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Integer.parseInt(s.nextLine());
                
                if( num >= _min)
                    datoValido = true;
                else 
                    System.out.printf("Debe ser un número entre mayor que " + _min);
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    public static int leerEntero( String _msg, byte _min, byte _max)
    {
        
        boolean datoValido = false;
        
        int num = 0;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Integer.parseInt(s.nextLine());
                
                if( num >= _min && num <= _max)
                    datoValido = true;
                else 
                    System.out.printf("Debe ser un número entre %d y %d.\n", _min, _max);
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    public static long leerEnteroLargo()
    {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;
        
        long num = 0;
        do 
        {
            try 
            {
                num = Long.parseLong(s.nextLine());
                
                
                datoValido = true;
                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    
    public static long leerEnteroLargo(String _msg)
    {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;
        
        long num = 0;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Long.parseLong(s.nextLine());
                
                datoValido = true;
                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    public static float leerReal()
    {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;
        
        float num = 0f;
        do 
        {
            try 
            {
                num = Float.parseFloat(s.nextLine());
                
                datoValido = true;
                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    public static float leerReal(String _msg)
    {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;
        
        float num = 0f;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Float.parseFloat(s.nextLine());
                
                datoValido = true;
                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    public static float leerReal( String _msg, byte _min)
    {
        
        boolean datoValido = false;
        
        float num = 0f;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Float.parseFloat(s.nextLine());
                
                if( num >= _min)
                    datoValido = true;
                else 
                    System.out.printf("Debe ser un número entre mayor que " + _min);
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    public static double leerRealLargo()
    {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;
        
        double num = 0;
        do 
        {
            try 
            {
                num = Double.parseDouble(s.nextLine());
                
                datoValido = true;
                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    public static double leerRealLargo(String _msg)
    {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;
        
        double num = 0;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Double.parseDouble(s.nextLine());
                
                datoValido = true;
                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    
    
    
}
