package co.edu.uniquindio.Decorator;

import co.edu.uniquindio.Contenido;

public class Efecto8D extends EfectoDecorator {
    public Efecto8D(IReproductor envuelto) { super(envuelto); }

    @Override
    public void reproducir(Contenido cancion) {
        super.reproducir(cancion);
        System.out.println("Efecto 8D aplicado");
    }
}

