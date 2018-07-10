package ar.com.curso.poi.kata.tdd;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PoiTest {

    @Test
    public void obtenerCoordenadasDeUnPoi(){
        Poi poiCongreso = new Poi("Congreso", -34.6097691, -58.3964721);
        assertThat(poiCongreso.getLatitud()).isEqualTo(-34.6097691);
        assertThat(poiCongreso.getLongitud()).isEqualTo(-58.3964721);
    }
}
