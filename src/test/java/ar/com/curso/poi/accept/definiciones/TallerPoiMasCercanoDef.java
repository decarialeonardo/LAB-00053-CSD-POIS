package ar.com.curso.poi.accept.definiciones;

import ar.com.curso.poi.kata.tdd.Poi;
import ar.com.curso.poi.kata.tdd.Ubicacion;
import ar.com.curso.poi.modelo.POI;
import ar.com.curso.poi.servicios.TallerNegocioSubte;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TallerPoiMasCercanoDef {

    Ubicacion estoyEn;
    String respuesta;

    private String port;
    private String urlBase;

    @Before
    public void setUp() throws Exception {
        port = System.getProperty("servlet.port", "8080");
        urlBase = "http://localhost:" + port + "/pois-app";
    }


    @Dado("que estoy en (.*) y (.*)")
    public void estoy_en(String  latitud, String longitud){
        Double latitudDouble = Double.parseDouble(latitud);
        Double longitudDouble = Double.parseDouble(longitud);

        estoyEn = new Ubicacion(latitudDouble, longitudDouble);

    }

    private String obtenerRespuesta(String url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        return new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream())).readLine();
    }


    @Cuando("pido el POI mas cercano")
    public void pido_el_POI_mas_cercano() throws Exception {

        String url = urlBase +"/poiMasCercano/estacionesSubte/"+estoyEn.getLatitud()+"/"+estoyEn.getLongitud();

        respuesta = this.obtenerRespuesta(url);

    }

    @Entonces("el servicio devuelve (.*)")
    public void el_servicio_devuelve(String elServicioDevuelve){
        assertThat(respuesta).contains(elServicioDevuelve);
    }
}
