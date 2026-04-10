/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos.vehiculos.turismos;

import java.util.Objects;
import objetos.Vehiculo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import rlc_alquilervehiculos.Enumerados;
import objetos.vehiculos.Turismo;

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
    
    public Deportivo (Enumerados.CajaCambio cambio, boolean descapotable, String matricula, String marca, String modelo, int cilindrada, Enumerados.TipoCombustible combustible, int nPuertas)
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
    
    @Override
    public Element escribirXML(Document _doc) {
        Element eUsuario = (Element) _doc.createElement("Deportivo");

        super.escribirXML(_doc);
        // matricula
        Element elemento = _doc.createElement("matricula");
        Text textElemento = _doc.createTextNode(super.getMatricula());
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        // marca
        elemento = _doc.createElement("marca");
        textElemento = _doc.createTextNode(super.getMarca());
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);

        // modelo
        elemento = _doc.createElement("modelo");
        textElemento = _doc.createTextNode(super.getModelo());
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);

        // cilindrada
        elemento = _doc.createElement("cilindrada");
        textElemento = _doc.createTextNode(super.getCilindrada() + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);

        
        // disponible
        elemento = _doc.createElement("disponible");
        textElemento = _doc.createTextNode(super.isDisponible() + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        // deBaja
        elemento = _doc.createElement("baja");
        textElemento = _doc.createTextNode(super.estaDeBaja() + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);

        
        // npuertas
        elemento = _doc.createElement("npuertas");
        textElemento = _doc.createTextNode(super.getPuertas() + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        // combustible
        elemento = _doc.createElement("combustible");
        textElemento = _doc.createTextNode(combustible + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        
        // descapotable
        elemento = _doc.createElement("descapotable");
        textElemento = _doc.createTextNode(descapotable + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        // cambio
        elemento = _doc.createElement("cambio");
        textElemento = _doc.createTextNode(cambio + "");
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
            Vehiculo vehiculo = (Vehiculo) o;
            iguales = Objects.equals( super.getMatricula(), vehiculo.getMatricula());
        }
        
        return iguales ;
    }
}
