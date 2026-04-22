package co.edu.uniquindio.FactoryMethod;

import co.edu.uniquindio.Contenido;
import co.edu.uniquindio.Podcast;

public class PodcastFactory extends ContenidoFactory {
    @Override
    public Contenido crearContenido(String id, String titulo, int duracionSeg,
                                    String presentador, String genero) {
        return new Podcast(id, titulo, duracionSeg, presentador, genero);
    }
}
