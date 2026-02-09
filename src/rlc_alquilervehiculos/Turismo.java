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
    protected Enumerados.TipoCombustible combustible; // Tipo enumerado??
    
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
                + "\n Puertas: " + nPuertas
                + "\n Combustible: " + combustible;
    }
}
