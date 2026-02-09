/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rlc_alquilervehiculos;

/**
 *
 * @author raull
 */
public class Furgoneta extends Mercancias {
    
    // Atributos
    
    private boolean refrigerado;
    private Enumerados.Tamano tamano; // Enumerado
    
    // Constructor
    
    Furgoneta (boolean refrigerado, Enumerados.Tamano tamano, int pma, int volumen, String matricula, String marca, String modelo, int cilindrada)
    {
        super(pma, volumen, matricula, marca, modelo, cilindrada);
        
        this.refrigerado = refrigerado;
        this.tamano = tamano;

    }
    
    // Metodos
    
    public boolean getRefrigerado()
    {
        return refrigerado;
    }
    
    public Enumerados.Tamano getTamano()
    {
        return tamano;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\n Refrigeramiento: " + refrigerado
                + "\n Tamanio: " + tamano;
    }
}
