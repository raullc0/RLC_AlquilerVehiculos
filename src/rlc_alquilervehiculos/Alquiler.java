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
    private LocalDateTime fechaFin = null;
    private int dias;
    
    private Cliente cliente;
    private Vehiculo vehiculo;
    
    // Constructores
    
    Alquiler(Cliente cliente, Vehiculo vehiculo) 
    {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = LocalDateTime.now();
        this.dias = 0;
        this.fechaFin = null;
        vehiculo.setDisponible(false);
    }
    
    // Metodos
    
    public Cliente getCliente()
    {
        return cliente;
    }
    
    public Vehiculo getVehiculo()
    {
        return vehiculo;
    }
    
    public LocalDateTime getFecha() 
    {
        return fecha;
    }
    
    public int getDias() 
    {
        int gDias;
        if (fechaFin == null)
            gDias = diferenciaDiasHoy(fecha);
        else
            gDias = diferenciaDias(fecha);
        
        return gDias;
    }
    
    public double precioAlquiler()
    {
        return PRECIO_DIA * getDias() + vehiculo.getCilindrada() / 100;
    }
    
    private int diferenciaDiasHoy(LocalDateTime fecha) 
    {
        return (int)ChronoUnit.DAYS.between(LocalDateTime.now(), fecha);
    }
    
    private int diferenciaDias(LocalDateTime fecha) 
    {
        return (int)ChronoUnit.DAYS.between(fechaFin, fecha);
    }
    
    public void cerrar() 
    {
        vehiculo.setDisponible(true);
        this.dias = getDias();
        this.fechaFin = LocalDateTime.now();
    }
    
    @Override
    public String toString()
    {
        return( this.getClass().getSimpleName() +
                "\n--------------------------------" +
                "\nCliente: " + cliente.toString() +
                "\nTurismo: " + vehiculo.toString() + 
                "\nDias: " + getDias() +
                "\nCerrado: " + vehiculo.isDisponible() +
                "\nFecha finalizacion: " + fechaFin +
                "\n--------------------------------\n"
                );
    }
    
    public String escribirFichero()
    {
        return(cliente.getDni() + "#" + vehiculo.getMatricula() + "#" + fecha + "#" + fechaFin);
    }
    
    
}
