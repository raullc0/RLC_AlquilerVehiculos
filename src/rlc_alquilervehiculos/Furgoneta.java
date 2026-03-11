/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rlc_alquilervehiculos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author raull
 */
public class Furgoneta extends Mercancias {
    
    // Atributos
    
    private boolean refrigerado;
    private Enumerados.Tamano tamano; // Enumerado
    
    // Constructor
    
    Furgoneta (boolean refrigerado, Enumerados.Tamano tamano, int pma, int volumen, String matricula, String marca, String modelo, int cilindrada)
    {
        super(pma, volumen, matricula, marca, modelo, cilindrada);
        
        this.refrigerado = refrigerado;
        this.tamano = tamano;

    }
    
    // Metodos
    
    public boolean getRefrigerado()
    {
        return refrigerado;
    }
    
    public Enumerados.Tamano getTamano()
    {
        return tamano;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\nRefrigeramiento: " + refrigerado
                + "\nTamano: " + tamano +
                "\n--------------------------------\n";
    }
    
    public String escribirFichero()
    {
        int nTam = 0;
        if (tamano == Enumerados.Tamano.GRANDE)
        {
            nTam = 1;
        }
        else 
        {
            if (tamano == Enumerados.Tamano.MEDIANA)
            {
                nTam = 2;
            }
            else
            {
                nTam = 3;
            }
        }
        return("3" + "#" + super.escribirFichero() + "#" + refrigerado + "#" + tamano + "\n");
    }
    
    @Override
    public Element escribirXML(Document _doc) {
        Element eUsuario = (Element) _doc.createElement("Furgoneta");

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

        
        // pma
        elemento = _doc.createElement("pma");
        textElemento = _doc.createTextNode(super.getPMA() + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        // volumen
        elemento = _doc.createElement("volumen");
        textElemento = _doc.createTextNode(super.getVolumen() + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        
        // refrigerado
        elemento = _doc.createElement("refrigerado");
        textElemento = _doc.createTextNode(refrigerado + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        // tamano
        elemento = _doc.createElement("tamano");
        textElemento = _doc.createTextNode(tamano + "");
        elemento.appendChild(textElemento);
        eUsuario.appendChild(elemento);
        
        return (eUsuario);
    }
}
