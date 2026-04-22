package co.edu.uniquindio.Decorator;

import co.edu.uniquindio.Cancion;
import co.edu.uniquindio.Contenido;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {

    private String capturarSalida(Runnable accion) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(buffer));
        accion.run();
        System.setOut(original);
        return buffer.toString();
    }

    @Test
    void reproductorBaseReproduceContenido() {
        Contenido cancion = new Cancion("C01", "La cumbia", 180, "Artista", "Album");
        IReproductor reproductor = new ReproductorBase();

        String salida = capturarSalida(() -> reproductor.reproducir(cancion));

        assertTrue(salida.contains("La cumbia"));
    }

    @Test
    void eqEfectoAgregaMensaje() {
        Contenido cancion = new Cancion("C01", "La cumbia", 180, "Artista", "Album");
        IReproductor reproductor = new EqEfecto(new ReproductorBase());

        String salida = capturarSalida(() -> reproductor.reproducir(cancion));

        assertTrue(salida.contains("Ecualizador aplicado"));
        assertTrue(salida.contains("La cumbia"));
    }

}