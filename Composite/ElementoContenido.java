package co.edu.uniquindio.Composite;

import co.edu.uniquindio.Contenido;

//LEAF

public class ElementoContenido implements ComponentePlaylist {
    private Contenido contenido;

    public ElementoContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    @Override
    public int duracionTotal() {
        return contenido.getDuracionSeg();
    }

    @Override
    public void mostrar(String indentacion) {
        System.out.println(indentacion + contenido.getTitulo() +
                " (" + contenido.getDuracionSeg() + "s)");
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }
}

