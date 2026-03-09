/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rlc_alquilervehiculos;



/**
 *
 * @author raull
 */
public abstract class Turismo extends Vehiculo 
{
    // Atributos
    
    protected int nPuertas;
    protected Enumerados.TipoCombustible combustible;
    
    // Constructor
    Turismo(String matricula, String marca, String modelo, int cilindrada, Enumerados.TipoCombustible combustible, int nPuertas)
    {
        super(matricula, marca, modelo, cilindrada);
        this.nPuertas = nPuertas;
        this.combustible = combustible;
    }
    
    // Metodos
    
    public int getPuertas() 
    {
        return nPuertas;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\nPuertas: " + nPuertas
                + "\nCombustible: " + combustible;
    }
    
    @Override
    public String escribirFichero()
    {
        int nComb = 0;
        if (combustible == Enumerados.TipoCombustible.GASOLINA)
        {
            nComb = 1;
        }
        else 
        {
            if (combustible == Enumerados.TipoCombustible.DIESEL)
            {
                nComb = 2;
            }
            else
            {
                if(combustible == Enumerados.TipoCombustible.HIBRIDO)
                {
                    nComb = 3;
                }
                else
                {
                    nComb = 4;
                }
            }
        }
        return(super.escribirFichero() + "#" + nPuertas + "#" + combustible);
    }
}
