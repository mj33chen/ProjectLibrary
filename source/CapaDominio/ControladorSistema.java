package CapaDominio;

import CapaDatos.ControladorDatos;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mingjian on 02/06/2014.
 */
public class ControladorSistema
{
    private ArrayList<Topologia> listTopo;
    private ControladorDatos ccntrolDatos;
    private ControladorBiblioteca controlBiblio;
    private ControladorClasificacion controlClasi;

    public ControladorSistema()
    {
        controlBiblio = new ControladorBiblioteca();
        controlClasi = new ControladorClasificacion();
        this.loadSystem();
    }

    public void rebootController()
    {
        controlBiblio = new ControladorBiblioteca();
        controlClasi = new ControladorClasificacion();
    }

    public void anadirLibro(String titulo, String autor, int id) throws IOException
    {
        controlBiblio.anadirLibro(id, titulo, autor);
    }

    public void modificarLibro(String titulo, String autor, int id) throws IOException
    {
        controlBiblio.modificarLibro(id, titulo, autor);
    }

    public void eliminarLibro(String idLibro) throws IOException
    {
        int id = Integer.parseInt(idLibro);
        controlBiblio.eliminarLibro(id);
    }

    public boolean esEmptyBiblio()
    {
        return controlBiblio.isEmpty();
    }

    public boolean esEmptyClasifi()
    {
        return (controlClasi.size() == 0);
    }

    public ArrayList<String> getAllThemes()
    {
        return controlClasi.getNombreTemas();
    }

    public ArrayList<String> getTemas(int id) throws IOException
    {
        return controlBiblio.getTemas(id);
    }

    public String getPadre(String nombre) throws IOException
    {
        return controlClasi.getPadre(nombre);
    }

    public void eliminarTema(String nombre) throws IOException
    {
        controlClasi.eliminarTema(nombre);
    }

    public boolean esTemaValido(String nombre) throws IOException
    {
        return controlClasi.esTemaValido(nombre);
    }

    public void modificarTema(String nombre, String nombre_nuevo) throws IOException
    {
        controlClasi.modificarTema(nombre, nombre_nuevo, null);
    }

    public ArrayList<String[]> getAllLibros()
    {
        return controlBiblio.getCatalogo();
    }

    public String[] getLibro(String idLibro) throws IOException
    {
        int id = Integer.parseInt(idLibro);
        return controlBiblio.infoLibro(id);
    }

    public void asignarTemaLibro(String idL, String nombreT) throws IOException
    {
        int id = Integer.parseInt(idL);
        controlBiblio.anadirTemaLibro(id, nombreT);
    }

    public Boolean temaRepetido(String idL, String nombreT) throws IOException
    {
        int id = Integer.parseInt(idL);
        return controlBiblio.esTemaRepetido(id, nombreT);
    }

    public ArrayList<String> getTopologias()
    {
        ArrayList<String> topos = new ArrayList<String>();
        topos.add("Rectagulo");
        topos.add("Triangulo");
        return topos;
    }

    private void loadSystem()
    {


    }

}

