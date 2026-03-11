/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rlc_alquilervehiculos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import utiles.ES;

/**
 *
 * @author raull
 */
public class Familiar extends Turismo {
    
    // Atributos
    private int nPlazas;
    private boolean sillaBebe;
    
    final private int MIN_PLAZAS = 4;
    final private int MAX_PLAZAS = 7;
    
    // Constructor
    
    Familiar (int nPlazas, boolean sillaBebe, String matricula, String marca, String modelo, int cilindrada, Enumerados.TipoCombustible combustible, int nPuertas)
    {
        super(matricula, marca, modelo, cilindrada, combustible, nPuertas);
        
        if (nPlazas < MIN_PLAZAS)
        {
            nPlazas = MIN_PLAZAS;
            ES.escribirCl("El numero minimo de plazas es de 4, se ha establecido el numero de plazas a 4.", "ANSI_RED");
        }
        
        if (nPlazas > MAX_PLAZAS)
        {
            nPlazas = MAX_PLAZAS;
            ES.escribirCl("El numero maximo de plazas es de 7, se ha establecido el numero de plazas a 7.", "ANSI_RED");
        }
        
        this.nPlazas = nPlazas;
        this.sillaBebe = sillaBebe;
    }
    
    // Metodos
    
    public void setSillaBebe(boolean sillaBebe) 
    {
        this.sillaBebe = sillaBebe;
    }
    
    public boolean getSillaBebe() 
    {
        return sillaBebe;
    }
    
    public int getNPlazas() 
    {
        return nPlazas;
    }
    
    public Enumerados.TipoCombustible getTipoCombustible()
    {
        return combustible;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\nSilla bebe: " + sillaBebe
                + "\nNumero de plazas: " + nPlazas +
                "\n--------------------------------\n";
    }
    
    public String escribirFichero()
    {
        return("2" + "#" + super.escribirFichero() + "#" + nPlazas + "#" + sillaBebe + "\n");
    }
    
    @Override
    public Element escribirXML(Document _doc) {
        Element eUsuario = (Element) _doc.createElement("Familiar");

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
        
        
        // nplazas
        elemento = _doc.createElement("nplazas");
        textElemento = _doc.createTextNode(nPlazas + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        // sillabebe
        elemento = _doc.createElement("sillabebe");
        textElemento = _doc.createTextNode(sillaBebe + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        return (eUsuario);
    }
}
