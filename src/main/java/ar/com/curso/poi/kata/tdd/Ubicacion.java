package ar.com.curso.poi.kata.tdd;

public class Ubicacion {
    protected double latitud;
    protected double longitud;

    public static final double RADIO_TIERRA = 6371; // en Km

    public Ubicacion(double latitud, double longitud){
        this.latitud = latitud;
        this.longitud = longitud;
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

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
