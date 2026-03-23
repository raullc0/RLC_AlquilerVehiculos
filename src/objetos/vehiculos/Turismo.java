/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos.vehiculos;

import java.util.Objects;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import rlc_alquilervehiculos.Enumerados;
import objetos.Vehiculo;


/**
 *
 * @author raull
 */
public abstract class Turismo extends Vehiculo 
{
    // Atributos
    
    protected int nPuertas;
    protected Enumerados.TipoCombustible combustible;
    
    // Constructor
    public Turismo(String matricula, String marca, String modelo, int cilindrada, Enumerados.TipoCombustible combustible, int nPuertas)
    {
        super(matricula, marca, modelo, cilindrada);
        this.nPuertas = nPuertas;
        this.combustible = combustible;
    }
    
    // Metodos
    
    public int getPuertas() 
    {
        return nPuertas;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\nPuertas: " + nPuertas
                + "\nCombustible: " + combustible;
    }
    
    @Override
    public String escribirFichero()
    {
        return(super.escribirFichero() + "#" + nPuertas + "#" + combustible);
    }
    
    @Override
    public Element escribirXML(Document _doc) {
        return (super.escribirXML(_doc));
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
