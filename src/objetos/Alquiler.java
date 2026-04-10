/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

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
    
    public Alquiler(Cliente cliente, Vehiculo vehiculo) 
    {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = LocalDateTime.now();
        this.dias = 0;
        this.fechaFin = null;
        vehiculo.setDisponible(false);
    }
    
    public Alquiler(Cliente cliente, Vehiculo vehiculo, LocalDateTime fecha, LocalDateTime fechaFin) 
    {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.fechaFin = fechaFin;
        
        
        this.dias = getDias();
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
    
    public Element escribirXML(Document _doc) {
        Element eUsuario = (Element) _doc.createElement("Alquiler");

        // cliente
        Element elemento = _doc.createElement("cliente");
        Text textElemento = _doc.createTextNode(cliente.getDni());
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        // vehiculo
        elemento = _doc.createElement("vehiculo");
        textElemento = _doc.createTextNode(vehiculo.getMatricula());
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);

        // estadoAlquiler
        elemento = _doc.createElement("estadoAlquiler");
        textElemento = _doc.createTextNode((fechaFin == null) + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);

        // fecha
        elemento = _doc.createElement("fecha");
        textElemento = _doc.createTextNode(fecha + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);

        // fDevolucion
        elemento = _doc.createElement("fDevolucion");
        if (fechaFin != null)
        {
            textElemento = _doc.createTextNode(fechaFin + "");
            elemento.appendChild(textElemento);
        }
        eUsuario.appendChild(elemento);

        return (eUsuario);
    }
}

