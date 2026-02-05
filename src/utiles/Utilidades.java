/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dam1
 */
public class Utilidades {
    // Contructor
    
    Utilidades(){}
    
    // Metodos
    
    public static boolean comprobarMatricula(String matricula) 
    {
        boolean valido = false;
        Pattern patronMatricula = Pattern.compile("^\\d{4}[A-Z]{3}$");
        Matcher coincidirMatricula = patronMatricula.matcher(matricula);
        
        if(coincidirMatricula.find()) 
            valido = true;
    
        
        return valido;
    }
    
    public static boolean comprobarDni(String dni) 
    {
        boolean valido = false;
        
        Pattern patronDni = Pattern.compile("^\\d{8}[A-Z]$");
        Matcher coincidirDni = patronDni.matcher(dni);
        
        Pattern patronNie = Pattern.compile("^[XYZ]\\d{7}[A-Z]$");
        Matcher coincidirNie = patronNie.matcher(dni);
        String num = "";
        
        
        if(coincidirDni.find()) 
        {
            String [] letrasDni = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
            
            String dniSinLetra = dni.substring(0, 8);
            int numerosDni = Integer.parseInt(dniSinLetra);
            
            if (letrasDni[numerosDni%23].equals(dni.substring(8, 9)))
                valido = true;
            
        }
        
        
        if(coincidirNie.find()) 
        {
            String [] letrasNie = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
            
            switch (dni.substring(0, 1)) 
            {
                case "x, X" -> num = "0";
                case "y, Y" -> num = "1";
                case "z, Z" -> num = "2";
            }
            
                    
            String nieSinLetra = num + dni.substring(1, 8);
            int numerosNie = Integer.parseInt(nieSinLetra);
            
            
            if (letrasNie[numerosNie%23].equals(dni.substring(8, 9)))
                valido = true;
              
        }
        
        
        return valido;
    }
    
    public static boolean comprobarCodigoPostal(String codPostal) 
    {
        boolean valido = false;
        Pattern patronCodPostal = Pattern.compile("^([0-4][0-9])|(5[0-2])\\d{3}$");
        Matcher coincidirCodPostal = patronCodPostal.matcher(codPostal);
        
        if(coincidirCodPostal.find()) 
            valido = true;
        
        return valido;
    }
    
    
    
}
