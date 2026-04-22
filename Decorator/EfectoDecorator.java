package co.edu.uniquindio.Decorator;

import co.edu.uniquindio.Contenido;

public abstract class EfectoDecorator implements IReproductor {
    protected IReproductor envuelto;

    public EfectoDecorator(IReproductor envuelto) {
        this.envuelto = envuelto;
    }

    @Override
    public void reproducir(Contenido cancion) {
        envuelto.reproducir(cancion);
    }
}

