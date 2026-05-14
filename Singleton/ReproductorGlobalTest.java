package co.edu.uniquindio.Singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class ReproductorGlobalTest {

    @Test
    void mismaInstancia() {
        ReproductorGlobal a = ReproductorGlobal.getInstancia();
        ReproductorGlobal b = ReproductorGlobal.getInstancia();
        assertSame(a, b, "Debe retornar siempre la misma instancia");
    }

}