package co.edu.uniquindio.FactoryMethod;

import co.edu.uniquindio.Audiolibro;
import co.edu.uniquindio.Contenido;

public class AudiolibroFactory extends ContenidoFactory {
    @Override
    public Contenido crearContenido(String id, String titulo, int duracionSeg,
                                    String autor, String narrador) {
        return new Audiolibro(id, titulo, duracionSeg, autor, narrador);
    }
}

