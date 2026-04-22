package co.edu.uniquindio.Composite;

import co.edu.uniquindio.Cancion;
import co.edu.uniquindio.Contenido;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompositeTest {

    @Test
    void elementoRetornaDuracionCorrecta() {
        Contenido cancion = new Cancion("C01", "Titulo", 180, "Artista", "Album");
        ElementoContenido elemento = new ElementoContenido(cancion);
        assertEquals(180, elemento.duracionTotal());
    }

}