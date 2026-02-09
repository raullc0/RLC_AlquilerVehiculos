/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rlc_alquilervehiculos;

import utiles.ES;

/**
 *
 * @author raull
 */
public abstract class Mercancias extends Vehiculo
{
    // Atributos
    private int pma;
    private int volumen;
    
    // Constructores
    
    Mercancias (int pma, int volumen, String matricula, String marca, String modelo, int cilindrada) 
    {
        super(matricula, marca, modelo, cilindrada);
        
        if (pma < 0) 
        {
            pma = pma * (-1);
            ES.escribirCl("El Peso Maximo Autorizado debe ser positivo, se ha cambiado a positivo.", "ANSI_RED");
        }
        
        if (volumen < 0) 
        {
            volumen = volumen * (-1);
            ES.escribirCl("El volumen debe ser positivo, se ha cambiado a positivo.", "ANSI_RED");
        }
        
        this.pma = pma;
        this.volumen = volumen;
    }
    
    Mercancias (int pma, int volumen, Vehiculo vehiculo) 
    {
        super(vehiculo);
        
        if (pma < 0) 
        {
            pma = pma * (-1);
            ES.escribirCl("El Peso Maximo Autorizado debe ser positivo, se ha cambiado a positivo.", "ANSI_RED");
        }
        
        if (volumen < 0) 
        {
            volumen = volumen * (-1);
            ES.escribirCl("El volumen debe ser positivo, se ha cambiado a positivo.", "ANSI_RED");
        }
        
        this.pma = pma;
        this.volumen = volumen;
    }
    
    // Metodos
    
    public int getPMA()
    {
        return pma;
    }
    
    public int getVolumen()
    {
        return volumen;
    }
}
