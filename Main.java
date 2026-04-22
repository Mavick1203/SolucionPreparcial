package co.edu.uniquindio;

import co.edu.uniquindio.Composite.ElementoContenido;
import co.edu.uniquindio.Composite.Playlist;
import co.edu.uniquindio.Decorator.*;
import co.edu.uniquindio.FactoryMethod.AudiolibroFactory;
import co.edu.uniquindio.FactoryMethod.CancionFactory;
import co.edu.uniquindio.FactoryMethod.ContenidoFactory;
import co.edu.uniquindio.FactoryMethod.PodcastFactory;
import co.edu.uniquindio.Proxy.ProxyReproductor;
import co.edu.uniquindio.Singleton.ReproductorGlobal;

import static co.edu.uniquindio.Usuario.construirReproductor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // ===== SINGLETON =====
        ReproductorGlobal global = ReproductorGlobal.getInstancia();

        Usuario carolina = new Usuario("U2112", "Milton Miguel", Usuario.TipoSuscripcion.PREMIUM);
        Usuario juan     = new Usuario("U1203", "Victor Hugo",     Usuario.TipoSuscripcion.FREE);

        global.iniciarSesion(carolina);

        // ===== FACTORY METHOD =====
        ContenidoFactory cancionF    = new CancionFactory();
        ContenidoFactory podcastF    = new PodcastFactory();
        ContenidoFactory audiolibroF = new AudiolibroFactory();

        Contenido c1 = cancionF.crearContenido("C01", "En Barranquilla me quedo",    310, "Joe Arroyo","Salsa");
        Contenido c2 = cancionF.crearContenido("C02", "Marlboro Rojo", 120, "Fuerza Regida","Regional Mexicano");
        Contenido c3 = podcastF.crearContenido("P01", "De las Drogas a vender $500,000 para Tony Robbins: La historia de Renzo Martos.",4716 ,"Josue Peña","Habitos de la vida");
        Contenido c4 = audiolibroF.crearContenido("A01", "Habitos Atomicos", 8136 , "James Clear","Libro de autoayuda");

        // ===== COMPOSITE =====
        Playlist favoritas = new Playlist("Favoritas");
        favoritas.agregar(new ElementoContenido(c1));
        favoritas.agregar(new ElementoContenido(c2));

        Playlist aprender = new Playlist("Lecciones");
        aprender.agregar(new ElementoContenido(c3));
        aprender.agregar(new ElementoContenido(c4));

        Playlist miSemana = new Playlist("Descubrimiento de la semana");
        miSemana.agregar(favoritas);   // playlist anidada
        miSemana.agregar(aprender);    // playlist anidada

        miSemana.mostrar("");
        System.out.println("Duración total: " + miSemana.duracionTotal() + " segundos");

        // ===== DECORATOR + PROXY =====
        IReproductor paraCarolina = construirReproductor(carolina, true, true, false);
        IReproductor paraJuan     = construirReproductor(juan,     true, false, true);

        System.out.println("\n--- Milton Miguel (PREMIUM) reproduce un audiolibro ---");
        paraCarolina.reproducir(c4);

        System.out.println("\n--- Victor Hugo (FREE) intenta un audiolibro (bloqueado) ---");
        paraJuan.reproducir(c4);

        System.out.println("\n--- Victor Hugo (FREE) escucha una canción (con anuncio) ---");
        paraJuan.reproducir(c1);
    }

}

