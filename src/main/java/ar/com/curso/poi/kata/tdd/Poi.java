package ar.com.curso.poi.kata.tdd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Poi extends Ubicacion{

    private String nombre;

    public Poi(){}

    public Poi(String nombre, double latitud, double longitud){
        super(latitud, longitud);
        this.nombre = nombre;
    }

    @XmlElement
    public String getNombre() {
        return this.nombre;
    }

}
