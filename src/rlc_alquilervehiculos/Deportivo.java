/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rlc_alquilervehiculos;

/**
 *
 * @author raull
 */
public class Deportivo extends Turismo 
{
    // Atributos
    
    private boolean descapotable;
    private Enumerados.CajaCambio cambio; // Enumerado
    
    // Constructor
    
    Deportivo (Enumerados.CajaCambio cambio, boolean descapotable, String matricula, String marca, String modelo, int cilindrada, Enumerados.TipoCombustible combustible, int nPuertas)
    {
        super(matricula, marca, modelo, cilindrada, combustible, nPuertas);
        
        this.descapotable = descapotable;
        this.cambio = cambio;
    }
    
    // Metodos
    
    public Enumerados.CajaCambio getCajaCambio()
    {
        return cambio;
    }
    
    public boolean getDescapotable()
    {
        return descapotable;
    }
    
    public Enumerados.TipoCombustible getTipoCombustible()
    {
        return combustible;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\nDescapotable: " + descapotable
                + "\nCaja de cambios: " + cambio +
                "\n--------------------------------\n";
    }
    
    @Override
    public String escribirFichero()
    {
        return("1" + "#" + super.escribirFichero() + "#" + descapotable + "#" + cambio + "\n");
    }
}
