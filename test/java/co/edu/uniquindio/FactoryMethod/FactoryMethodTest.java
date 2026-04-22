package co.edu.uniquindio.FactoryMethod;

import co.edu.uniquindio.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest {

    @Test
    void cancionFactoryCreaCancion() {
        ContenidoFactory factory = new CancionFactory();
        Contenido c = factory.crearContenido("C01", "Mi canción", 200, "Artista", "Pop");
        assertInstanceOf(Cancion.class, c);
        assertEquals("Mi canción", c.getTitulo());
        assertEquals(200, c.getDuracionSeg());
    }

}