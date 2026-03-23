/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos.vehiculos;

import java.util.Objects;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utiles.ES;
import objetos.Vehiculo;

/**
 *
 * @author raull
 */
public abstract class Mercancia extends Vehiculo
{
    // Atributos
    private int pma;
    private int volumen;
    
    // Constructores
    
    public Mercancia (int pma, int volumen, String matricula, String marca, String modelo, int cilindrada) 
    {
        super(matricula, marca, modelo, cilindrada);
        
        if (pma < 0) 
        {
            pma = pma * (-1);
            ES.escribirCl("El Peso Maximo Autorizado debe ser positivo, se ha cambiado a positivo.", "ANSI_RED");
        }
        
        if (volumen < 0) 
        {
            volumen = volumen * (-1);
            ES.escribirCl("El volumen debe ser positivo, se ha cambiado a positivo.", "ANSI_RED");
        }
        
        this.pma = pma;
        this.volumen = volumen;
    }
    
    public Mercancia (int pma, int volumen, Vehiculo vehiculo) 
    {
        super(vehiculo);
        
        if (pma < 0) 
        {
            pma = pma * (-1);
            ES.escribirCl("El Peso Maximo Autorizado debe ser positivo, se ha cambiado a positivo.", "ANSI_RED");
        }
        
        if (volumen < 0) 
        {
            volumen = volumen * (-1);
            ES.escribirCl("El volumen debe ser positivo, se ha cambiado a positivo.", "ANSI_RED");
        }
        
        this.pma = pma;
        this.volumen = volumen;
    }
    
    // Metodos
    
    public int getPMA()
    {
        return pma;
    }
    
    public int getVolumen()
    {
        return volumen;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\nPeso Maximo Autorizado: " + pma
                + "\nVolumen: " + volumen;
    }
    
    @Override
    public String escribirFichero()
    {
        return(super.escribirFichero() + "#" + pma + "#" + volumen);
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
