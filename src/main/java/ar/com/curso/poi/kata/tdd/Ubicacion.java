package ar.com.curso.poi.kata.tdd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Ubicacion {
    protected double latitud;
    protected double longitud;

    public static final double RADIO_TIERRA = 6371; // en Km

    public Ubicacion(){}

    public Ubicacion(double latitud, double longitud){
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Ubicacion(String latitud, String longitud){
        this.latitud = Double.parseDouble(latitud);
        this.longitud = Double.parseDouble(longitud);
    }

    public double calcularDistanciaAUbicacion(Ubicacion puntoFin) {
        double dLat = Math.toRadians(puntoFin.latitud - this.latitud);
        double dLng = Math.toRadians(puntoFin.longitud - this.longitud);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(puntoFin.latitud));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = RADIO_TIERRA * va2;

        return (double) Math.round(distancia * 100) / 100;
    }

    @XmlElement
    public double getLatitud() {
        return latitud;
    }

    @XmlElement
    public double getLongitud() {
        return longitud;
    }

    public Poi encontrarPOIMasCercano(ArrayList<Poi> estacionesDeSubte) {

        ArrayList<Double> distancias = new ArrayList<Double>();

        Iterator<Poi> iterator = estacionesDeSubte.iterator();

        while(iterator.hasNext()){
            Poi poiActual = iterator.next();
            Double distanciaActual = new Double(calcularDistanciaAUbicacion(poiActual));
            distancias.add(distanciaActual);
        }

        Poi masCercano = estacionesDeSubte.get(distancias.indexOf(Collections.min(distancias)));
        return masCercano;
    }
}
