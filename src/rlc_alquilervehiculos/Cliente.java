/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rlc_alquilervehiculos;

/**
 *
 * @author dam1
 */
public class Cliente {
    
    // Atributos
    
    private String dni, nombre, direccion, localidad, codigoPostal;
    private boolean deBaja;
    
    // Constructor
    
    Cliente(String dni, String nombre, String direccion, String localidad, String codigoPostal)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        deBaja= false;
    }
    
    Cliente (Cliente otroCliente) 
    {
        this.dni = otroCliente.dni;
        this.nombre = otroCliente.nombre;
        this.direccion = otroCliente.direccion;
        this.localidad = otroCliente.localidad;
        this.codigoPostal = otroCliente.codigoPostal;
        this.deBaja = otroCliente.deBaja;
    }
    
    // Metodos
    
    public String getDni() 
    {
        return(dni);
    }
    
    public String getNombre() 
    {
        return(nombre);
    }
    
    public String getDireccion() 
    {
        return(direccion);
    }
    
    public String getLocalidad() 
    {
        return(localidad);
    }
    
    public String getCodigoPostal() 
    {
        return(codigoPostal);
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
                "\n---------------------------------" +
                "\nDNI: " + dni +
                "\nNombre: " + nombre + 
                "\nDireccion: " + direccion +
                "\nLocalidad: " + localidad +
                "\nCodigo Postal: " + codigoPostal) +
                "\n--------------------------------\n";
    }
}
