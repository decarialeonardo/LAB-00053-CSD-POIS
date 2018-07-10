package ar.com.curso.poi.kata.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;


public class CalculadorDistanciasTest {

    @Test
    public void calcularDistanciaEntreDosPuntos(){
        Ubicacion puntoInicio = new Ubicacion(-34.609509, -58.396681);
        Ubicacion puntoFin = new Ubicacion (-34.609385, -58.398355);

        double distancia = puntoInicio.calcularDistanciaAUbicacion(puntoFin);
        assertThat(distancia).isEqualTo(0.15);
    }

    @Test
    public void obtenerMinimaDistanciaDentreDeUnConjunto(){

    }

}
