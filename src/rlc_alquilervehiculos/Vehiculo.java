/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rlc_alquilervehiculos;

/**
 *
 * @author dam1
 */
public class Vehiculo {
    // Atributos
    
    private String matricula, marca, modelo;
    private int cilindrada;
    private boolean disponible;
    private boolean deBaja;
    
    // Constructores
    
    Vehiculo(String matricula, String marca, String modelo, int cilindrada)
    {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        disponible = true;
        deBaja = false;
    }
    
    Vehiculo(Vehiculo otroVehiculo) // Constructor copia
    {
        this.matricula = otroVehiculo.matricula;
        this.marca = otroVehiculo.marca;
        this.modelo = otroVehiculo.modelo;
        this.cilindrada = otroVehiculo.cilindrada;
        this.disponible = otroVehiculo.disponible;
        this.deBaja = otroVehiculo.deBaja;
    }
    
    // Metodos
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public String getMatricula() 
    {
        return(matricula);
    }
    
    public String getMarca() 
    {
        return(marca);
    }
    
    public String getModelo() 
    {
        return(modelo);
    }
    
    public int getCilindrada() 
    {
        return(cilindrada);
    }
    
    public boolean isDisponible() 
    {
        return(disponible);
    }
    
    public boolean estaDeBaja() 
    {
        return(deBaja);
    }
    
    public void darDeBaja() 
    {
        deBaja = true;
    }
    
    @Override
    public String toString()
    {
        return( this.getClass().getSimpleName() +
                "\n--------------------------------" +
                "\nMatricula: " + matricula +
                "\nMarca: " + marca + 
                "\nModelo: " + modelo +
                "\nCilindrada: " + cilindrada +
                "\nDisponible: " + disponible) +
                "\n--------------------------------\n";
    }
}
