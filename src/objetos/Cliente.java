/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.Objects;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author dam1
 */
public class Cliente {
    
    // Atributos
    
    private String dni, nombre, direccion, localidad, codigoPostal;
    private boolean deBaja;
    
    // Constructor
    
    public Cliente(String dni, String nombre, String direccion, String localidad, String codigoPostal)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        deBaja= false;
    }
    
    public Cliente (Cliente otroCliente) 
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
                "\n--------------------------------" +
                "\nDNI: " + dni +
                "\nNombre: " + nombre + 
                "\nDireccion: " + direccion +
                "\nLocalidad: " + localidad +
                "\nCodigo Postal: " + codigoPostal) +
                "\n--------------------------------\n";
    }
    
    public String escribirFichero()
    {
        return(dni + "#" + nombre + "#" + direccion + "#" + localidad + "#" + codigoPostal + "#" + deBaja + "\n");
    }
    
    public Element escribirXML(Document _doc) {
        Element eUsuario = (Element) _doc.createElement("Cliente");

        // DNI
        Element elemento = _doc.createElement("DNI");
        Text textElemento = _doc.createTextNode(dni);
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        // nombre
        elemento = _doc.createElement("nombre");
        textElemento = _doc.createTextNode(nombre);
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);

        // direccion
        elemento = _doc.createElement("direccion");
        textElemento = _doc.createTextNode(direccion);
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);

        // localidad
        elemento = _doc.createElement("localidad");
        textElemento = _doc.createTextNode(localidad);
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);

        // codigoPostal
        elemento = _doc.createElement("cp");
        textElemento = _doc.createTextNode(codigoPostal);
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        // deBaja
        elemento = _doc.createElement("baja");
        textElemento = _doc.createTextNode(deBaja + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);

        return (eUsuario);
    }
    
    @Override
    public boolean equals(Object o)
    {
        boolean iguales = false ;
        
        if (this == o)
            iguales =  true;
        
        else if (o == null || getClass() != o.getClass())
            iguales = false;
        
        else
        {
            Cliente cliente = (Cliente) o;
            iguales = Objects.equals( dni, cliente.dni);
        }
        
        return iguales ;
    }
}
