package ar.com.curso.poi.accept.definiciones;

import ar.com.curso.poi.kata.tdd.Poi;
import ar.com.curso.poi.kata.tdd.Ubicacion;
import ar.com.curso.poi.modelo.POI;
import ar.com.curso.poi.servicios.TallerNegocioSubte;
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
        estacionesDeSubte = TallerNegocioSubte.getInstance().getPois();
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
