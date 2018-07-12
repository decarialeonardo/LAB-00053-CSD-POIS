package ar.com.curso.poi.rest;

import ar.com.curso.poi.kata.tdd.Poi;
import ar.com.curso.poi.kata.tdd.Ubicacion;
import ar.com.curso.poi.servicios.TallerNegocioSubte;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;

@Path("/")
public class TallerServicioWeb {

    @GET
    @Path("/test")
    public String hola(){
        return "Test";
    }

    @GET
    @Path("/poiMasCercano/estacionesSubte/{latitud}/{longitud}")
    @Produces("application/xml")
    public Poi obtenerPoiMasCercano(@PathParam("latitud") String latitud,
                                    @PathParam("longitud")String longitud) {

        ArrayList<Poi> pois =  TallerNegocioSubte.getInstance().getPois();
        Ubicacion poiActual = new Ubicacion(latitud, longitud);
        Poi poiMasCercano = poiActual.encontrarPOIMasCercano(pois);

        return poiMasCercano;
    }
}
