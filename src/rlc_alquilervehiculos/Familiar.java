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
public class Familiar extends Turismo {
    
    // Atributos
    private int nPlazas;
    private boolean sillaBebe;
    
    final private int MIN_PLAZAS = 4;
    final private int MAX_PLAZAS = 7;
    
    // Constructor
    
    Familiar (int nPlazas, boolean sillaBebe, String matricula, String marca, String modelo, int cilindrada, Enumerados.TipoCombustible combustible, int nPuertas)
    {
        super(matricula, marca, modelo, cilindrada, combustible, nPuertas);
        
        if (nPlazas < MIN_PLAZAS)
        {
            nPlazas = MIN_PLAZAS;
            ES.escribirCl("El numero minimo de plazas es de 4, se ha establecido el numero de plazas a 4.", "ANSI_RED");
        }
        
        if (nPlazas > MAX_PLAZAS)
        {
            nPlazas = MAX_PLAZAS;
            ES.escribirCl("El numero maximo de plazas es de 7, se ha establecido el numero de plazas a 7.", "ANSI_RED");
        }
        
        this.nPlazas = nPlazas;
        this.sillaBebe = sillaBebe;
    }
    
    // Metodos
    
    public void setSillaBebe(boolean sillaBebe) 
    {
        this.sillaBebe = sillaBebe;
    }
    
    public boolean getSillaBebe() 
    {
        return sillaBebe;
    }
    
    public int getNPlazas() 
    {
        return nPlazas;
    }
    
    public Enumerados.TipoCombustible getTipoCombustible()
    {
        return combustible;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\nSilla bebe: " + sillaBebe
                + "\nNumero de plazas: " + nPlazas +
                "\n--------------------------------\n";
    }
    
    public String escribirFichero()
    {
        return("2" + "#" + super.escribirFichero() + "#" + nPlazas + "#" + sillaBebe + "\n");
    }
}
