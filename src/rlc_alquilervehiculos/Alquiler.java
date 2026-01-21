/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rlc_alquilervehiculos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author dam1
 */
public class Alquiler {
    
    // Atributos
    
    private final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final double PRECIO_DIA = 300;
    private LocalDateTime fecha;
    private int dias;
    
    private Cliente cliente;
    private Vehiculo turismo;
    
    // Constructores
    
    Alquiler(Cliente cliente, Vehiculo turismo) 
    {
        this.cliente = cliente;
        this.turismo = turismo;
        this.fecha = LocalDateTime.now();
        this.dias = 0;
        turismo.setDisponible(false);
    }
    
    // Metodos
    
    public Cliente getCliente()
    {
        return cliente;
    }
    
    public Vehiculo getVehiculo()
    {
        return turismo;
    }
    
    public LocalDateTime getFecha() 
    {
        return fecha;
    }
    
    public int getDias() 
    {
        return diferenciaDias(fecha);
    }
    
    public double precioAlquiler()
    {
        return PRECIO_DIA * getDias() + turismo.getCilindrada() / 100;
    }
    
    private int diferenciaDias(LocalDateTime fecha) 
    {
        return (int)ChronoUnit.DAYS.between(LocalDateTime.now(), fecha);
    }
    
    public void cerrar() 
    {
        turismo.setDisponible(true);
        this.dias = getDias();
    }
    
    @Override
    public String toString()
    {
        return( this.getClass().getSimpleName() +
                "\nCliente: " + cliente.toString() +
                "\nTurismo: " + turismo.toString() + 
                "\nDias: " + dias +
                "\nCerrado: " + turismo.isDisponible()
                );
    }
    
    
    
    
}
