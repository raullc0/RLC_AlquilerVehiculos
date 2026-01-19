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
    
    // Constructor
    
    Cliente(String dni, String nombre, String direccion, String localidad, String codigoPostal)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
    }
    
    Cliente (Cliente otroCliente) 
    {
        this.dni = otroCliente.dni;
        this.nombre = otroCliente.nombre;
        this.direccion = otroCliente.direccion;
        this.localidad = otroCliente.localidad;
        this.codigoPostal = otroCliente.codigoPostal;
    }
    
    // Metodos
}
