package ar.com.curso.poi.accept.definiciones;

import ar.com.curso.poi.kata.tdd.Poi;
import ar.com.curso.poi.kata.tdd.Ubicacion;
import ar.com.curso.poi.modelo.POI;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TallerPoiMasCercanoDef {

    ArrayList<Poi> estacionesDeSubte;
    Ubicacion estoyEn;
    Poi poiMasCercano;

    @Before
    public void setUp(){
        Poi estPasco = new Poi("Pasco", -34.609385, -58.398355);
        Poi estCongreso = new Poi("Congreso", -34.609167, -58.392370);
        Poi estCallao = new Poi("Callao", -34.604184, -58.392323);
        Poi estAlberti = new Poi("Alberti", -34.609667, -58.400734);
        Poi estPlazaMiserere = new Poi("PlazaMiserere", -34.607877, -58.405979);

        estacionesDeSubte = new ArrayList<Poi>();

        estacionesDeSubte.add(estPasco);
        estacionesDeSubte.add(estCongreso);
        estacionesDeSubte.add(estCallao);
        estacionesDeSubte.add(estAlberti);
        estacionesDeSubte.add(estPlazaMiserere);
    }


    @Dado("que estoy en (.*) y (.*)")
    public void estoy_en(String  latitud, String longitud){
        Double latitudDouble = Double.parseDouble(latitud);
        Double longitudDouble = Double.parseDouble(longitud);

        estoyEn = new Ubicacion(latitudDouble, longitudDouble);

    }

    @Cuando("pido el POI mas cercano")
    public void pido_el_POI_mas_cercano() throws Exception {
        poiMasCercano = estoyEn.encontrarPOIMasCercano(estacionesDeSubte);
    }

    @Entonces("el servicio devuelve (.*)")
    public void el_servicio_devuelve(String elServicioDevuelve){
        assertThat(elServicioDevuelve).isEqualTo(poiMasCercano.getNombre());
    }
}
