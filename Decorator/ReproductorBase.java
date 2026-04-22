package co.edu.uniquindio.Decorator;

import co.edu.uniquindio.Contenido;

public class ReproductorBase implements IReproductor {
    @Override
    public void reproducir(Contenido cancion) {
        System.out.println("Reproduciendo: " + cancion.getTitulo());
        cancion.reproducir();
    }
}
