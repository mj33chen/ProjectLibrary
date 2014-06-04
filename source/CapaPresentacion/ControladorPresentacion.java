package CapaPresentacion;

import java.io.IOException;
import java.util.ArrayList;

import CapaDominio.ControladorSistema;

/**
 * Created by Mingjian on 29/05/2014.
 */
public class ControladorPresentacion
{

    private ControladorSistema controlSystem;
    private VistaPrincipal vistaPrin;

    public ControladorPresentacion()
    {
       vistaPrin = new VistaPrincipal(this);
       controlSystem = new ControladorSistema();
    }

    public void initPresentation()
    {
        vistaPrin.hacerVisible();
    }

    public void rebootController()
    {
        controlSystem.rebootController();
    }

    /*public void activeView(String dir, String item)
    {
        vistaPrin.activeView(dir, item);
    }*/

    public void anadirLibro(String titulo, String autor, int id) throws IOException
    {
        controlSystem.anadirLibro(titulo, autor, id);
    }

    public void modificarLibro(String titulo, String autor, int id) throws IOException
    {
        controlSystem.modificarLibro(titulo, autor, id);
    }

    public void eliminarLibro(String idLibro) throws IOException
    {
        controlSystem.eliminarLibro(idLibro);
    }

    public boolean esEmptyBiblio()
    {
        return controlSystem.esEmptyBiblio();
    }

    public boolean esEmptyClasifi()
    {
        return controlSystem.esEmptyClasifi();
    }

    public ArrayList<String> getAllThemes()
    {
        return controlSystem.getAllThemes();
    }

    public ArrayList<String> getTemas(int id) throws IOException
    {
        return controlSystem.getTemas(id);
    }

    public String getPadre(String nombre) throws IOException
    {
        return controlSystem.getPadre(nombre);
    }

    public void eliminarTema(String nombre) throws IOException
    {
        controlSystem.eliminarTema(nombre);
    }

    public boolean esTemaValido(String nombre) throws IOException
    {
        return (controlSystem.esTemaValido(nombre));
    }

    public void modificarTema(String nombre, String nombre_nuevo) throws IOException
    {
        controlSystem.modificarTema(nombre, nombre_nuevo);
    }

    public ArrayList<String[]> getAllLibros()
    {
        return controlSystem.getAllLibros();
    }

    public String[] getLibro(String idLibro) throws IOException
    {
        return controlSystem.getLibro(idLibro);
    }

    public void asignarTemaLibro(String idL, String nombreT) throws IOException
    {
        controlSystem.asignarTemaLibro(idL, nombreT);
    }

    public Boolean temaRepetido(String idL, String nombreT) throws IOException
    {
        return controlSystem.temaRepetido(idL, nombreT);
    }

  
}
