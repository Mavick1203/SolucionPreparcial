package co.edu.uniquindio.Singleton;

import co.edu.uniquindio.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReproductorGlobalTest {

    @Test
    void mismaInstancia() {
        ReproductorGlobal a = ReproductorGlobal.getInstancia();
        ReproductorGlobal b = ReproductorGlobal.getInstancia();
        assertSame(a, b, "Debe retornar siempre la misma instancia");
    }

}