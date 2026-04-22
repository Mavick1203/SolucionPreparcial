package co.edu.uniquindio.Singleton;

import co.edu.uniquindio.Contenido;
import co.edu.uniquindio.Usuario;

public class ReproductorGlobal {

    private static ReproductorGlobal instancia;
    private Usuario usuarioActivo;
    private Contenido contenidoActual;

    private ReproductorGlobal() {

    }

    public static ReproductorGlobal getInstancia() {
        if (instancia == null) {
            instancia = new ReproductorGlobal();
        }
        return instancia;
    }
    public void iniciarSesion(Usuario u) {
        this.usuarioActivo = u;
        System.out.println("Sesión iniciada:" + u.getNombre() +
                " (" + u.getSuscripcion() + ")");
    }
    public Usuario getUsuarioActivo() { return usuarioActivo; }
    public void reproducir(Contenido cancion) {
        this.contenidoActual = cancion;
        cancion.reproducir();
    }
}