package co.edu.uniquindio;

import co.edu.uniquindio.Decorator.IReproductor;
import co.edu.uniquindio.Proxy.ProxyReproductor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void premiumEsPremium() {
        Usuario u = new Usuario("U01", "Ana", Usuario.TipoSuscripcion.PREMIUM);
        assertTrue(u.esPremium());
    }

}