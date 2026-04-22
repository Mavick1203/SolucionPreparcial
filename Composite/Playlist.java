package co.edu.uniquindio.Composite;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements ComponentePlaylist {
    private String nombre;
    private List<ComponentePlaylist> hijos = new ArrayList<>();

    public Playlist(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ComponentePlaylist c)  { hijos.add(c); }
    public void quitar(ComponentePlaylist c)   { hijos.remove(c); }

    @Override
    public int duracionTotal() {
        int total = 0;
        for (ComponentePlaylist c : hijos) {
            total += c.duracionTotal();   // llamada RECURSIVA
        }
        return total;
    }

    @Override
    public void mostrar(String indent) {
        System.out.println(indent + "Playlist: " + nombre);
        for (ComponentePlaylist c : hijos) {
            c.mostrar(indent + "   ");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ComponentePlaylist> getHijos() {
        return hijos;
    }

    public void setHijos(List<ComponentePlaylist> hijos) {
        this.hijos = hijos;
    }
}

