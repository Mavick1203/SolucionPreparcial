package co.edu.uniquindio.Proxy;

import co.edu.uniquindio.*;
import co.edu.uniquindio.Decorator.IReproductor;
import co.edu.uniquindio.Decorator.ReproductorBase;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ProxyReproductorTest {

    private String capturarSalida(Runnable accion) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(buffer));
        accion.run();
        System.setOut(original);
        return buffer.toString();
    }

    @Test
    void premiumPuedeReproducirAudiolibro() {
        Usuario premium = new Usuario("U01", "Victor Hugo", Usuario.TipoSuscripcion.PREMIUM);
        Contenido audiolibro = new Audiolibro("A01", "Hábitos Atómicos", 8136, "James Clear", "Narrador");
        ProxyReproductor proxy = new ProxyReproductor(new ReproductorBase(), premium);

        String salida = capturarSalida(() -> proxy.reproducir(audiolibro));

        assertTrue(salida.contains("Hábitos Atómicos"));
        assertFalse(salida.contains("exclusivos para Premium"));
    }

}