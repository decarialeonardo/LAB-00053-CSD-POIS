package ar.com.curso.poi.servicios;

import ar.com.curso.poi.kata.tdd.Poi;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TallerNegocio {

    ArrayList<Poi> pois;
    String nombreNegocio;

    public TallerNegocio(String nombreNegocio, ArrayList<Poi> pois){
        this.pois = pois;
        this.nombreNegocio = nombreNegocio;
    }

    public TallerNegocio(String nombreNegocio){
        this.nombreNegocio = nombreNegocio;
        this.pois = new ArrayList<Poi>();
    }

    public void setPois(ArrayList<Poi> pois){
        this.pois = pois;
    }

    public ArrayList<Poi> getPois(){
        return pois;
    }

}
