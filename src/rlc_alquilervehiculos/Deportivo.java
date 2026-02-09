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
    private int cambio; // Enumerado
    
    // Constructor
    
    Deportivo (int cambio, boolean descapotable, String matricula, String marca, String modelo, int cilindrada, int combustible, int nPuertas)
    {
        super(matricula, marca, modelo, cilindrada, combustible, nPuertas);
        
        this.descapotable = descapotable;
        this.cambio = cambio;
    }
    
    // Metodos
    
    public int getCajaCambio()
    {
        return cambio;
    }
    
    public boolean getDescapotable()
    {
        return descapotable;
    }
    
    public int getTipoCombustible()
    {
        return combustible;
    }
}
