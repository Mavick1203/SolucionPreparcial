package co.edu.uniquindio.Proxy;

import co.edu.uniquindio.Audiolibro;
import co.edu.uniquindio.Contenido;
import co.edu.uniquindio.Decorator.IReproductor;
import co.edu.uniquindio.Usuario;

public class ProxyReproductor implements IReproductor {
    private IReproductor reproductorReal;
    private Usuario usuario;
    private int saltosRealizados = 0;
    private static final int MAX_SALTOS_GRATIS = 3;

    public ProxyReproductor(IReproductor reproductorReal, Usuario usuario) {
        this.reproductorReal = reproductorReal;
        this.usuario = usuario;
    }

    @Override
    public void reproducir(Contenido cancion) {
        if (usuario == null) {
            System.out.println("No hay sesión activa.");
            return;
        }


        if (usuario.esPremium()) {
            reproductorReal.reproducir(cancion);
            return;
        }

        System.out.println(" Puedes Suscríbete a Premium para evitar anuncios!!!");


        if (cancion instanceof Audiolibro) {
            System.out.println(" Recurrda: Los audiolibros son exclusivos para Premium.");
            return;
        }

        reproductorReal.reproducir(cancion);
    }

    public boolean puedeSaltar() {
        if (usuario.esPremium()) return true;
        return saltosRealizados < MAX_SALTOS_GRATIS;
    }

    public void saltar() {
        if (puedeSaltar()) {
            saltosRealizados++;
            System.out.println("Salto realizado (" + saltosRealizados + ")");
        } else {
            System.out.println("El Límite de saltos ha sido alcanzado. Actualiza a Premium para saltar libremente.");
        }
    }

    public class ValidadorAcceso {
        public static boolean puedeReproducir(Usuario usuario, Contenido cancion) {
            if (usuario == null) return false;
            if (usuario.esPremium()) return true;
            if (cancion instanceof Audiolibro) return false;
            return true;
        }
    }

}

