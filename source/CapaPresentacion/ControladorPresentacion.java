package CapaPresentacion;

import java.io.IOException;
import java.util.ArrayList;
import CapaDominio.ControladorBiblioteca;
import CapaDominio.ControladorClasificacion;

/**
 * Created by Mingjian on 29/05/2014.
 */
public class ControladorPresentacion
{
    private ControladorClasificacion controlClasi;
    private ControladorBiblioteca controlBiblio;

    public ControladorPresentacion()
    {
        this.controlClasi = new ControladorClasificacion();
        this.controlBiblio = new ControladorBiblioteca();
    }

    public void anadirLibro(String titulo, String autor, int id) throws IOException
    {
        controlBiblio.anadirLibro(id, titulo, autor);
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

    public ArrayList<String> getAllThemes()
    {
        return controlClasi.getNombreTemas();
    }

    public ArrayList<String> getTemas(int id) throws IOException
    {
        return controlBiblio.getTemas(id);
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
}
