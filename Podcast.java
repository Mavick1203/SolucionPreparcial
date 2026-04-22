package co.edu.uniquindio;

public class Podcast extends Contenido {
    private String presentador;
    private String generoPodcast;

    public Podcast(String id, String titulo, int duracionSeg, String presentador, String genero) {
        super(id, titulo, duracionSeg);
        this.presentador = presentador;
        this.generoPodcast = genero;
    }

    @Override
    public void reproducir() {
        System.out.println("Podcast: " + titulo + " Genero" + generoPodcast);
    }
}


