package co.edu.uniquindio.Decorator;

import co.edu.uniquindio.Contenido;

public class EqEfecto extends EfectoDecorator {
    public EqEfecto(IReproductor envuelto) { super(envuelto); }

    @Override
    public void reproducir(Contenido cancion) {
        super.reproducir(cancion);
        System.out.println("Ecualizador aplicado");
    }
}

