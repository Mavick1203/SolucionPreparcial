package co.edu.uniquindio.FactoryMethod;

import co.edu.uniquindio.Contenido;

public abstract class ContenidoFactory {
    public abstract Contenido crearContenido(String id, String titulo,
                                             int duracionSeg, String artista, String genero);
}
