package ar.com.curso.poi.servicios;

import ar.com.curso.poi.kata.tdd.Poi;

public class TallerNegocioSubte extends TallerNegocio{

    private static TallerNegocioSubte instance = new TallerNegocioSubte();

    public static TallerNegocioSubte getInstance(){
        return instance;
    }

    private TallerNegocioSubte() {
        super("estacionesSubte");
        crearPoisSubtes();
    }


    private void crearPoisSubtes() {

        Poi estPasco = new Poi("Pasco", -34.609385, -58.398355);
        Poi estCongreso = new Poi("Congreso", -34.609167, -58.392370);
        Poi estCallao = new Poi("Callao", -34.604184, -58.392323);
        Poi estAlberti = new Poi("Alberti", -34.609667, -58.400734);
        Poi estPlazaMiserere = new Poi("PlazaMiserere", -34.607877, -58.405979);
        Poi estOnce = new Poi("Once", -34.607877, -58.405979);

        pois.add(estPasco);
        pois.add(estCongreso);
        pois.add(estCallao);
        pois.add(estAlberti);
        pois.add(estPlazaMiserere);
        pois.add(estOnce);
    }


}
