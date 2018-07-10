package ar.com.curso.poi.kata.tdd;

public class Poi extends Ubicacion{

    private String nombre;

    public Poi(String nombre, double latitud, double longitud){
        super(latitud, longitud);
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
}
