package co.edu.uniquindio.Decorator;

import co.edu.uniquindio.Contenido;

public class ReverbEfecto extends EfectoDecorator {
    public ReverbEfecto(IReproductor envuelto) { super(envuelto); }

    @Override
    public void reproducir(Contenido cancion) {
        super.reproducir(cancion);
        System.out.println("Efecto Reverb aplicado");
    }
}

