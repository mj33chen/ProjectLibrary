package CapaDominio;

import CapaDatos.ControladorDatos;

import java.util.ArrayList;
import java.io.IOException;

/**
 *
 * @author Mingjian Chen 
 */

public class ControladorClasificacion
{

    private Clasificacion clasi;
    private ControladorDatos cd;


    /**
     *
     */
    public ControladorClasificacion() throws IOException
    {
        //String nombre = " ";
        clasi = Clasificacion.getInstance(null);
        cd = ControladorDatos.getInstance();
        //loadClasificacion("General");
    }

    /**
     * Constructor
     */
    public ControladorClasificacion(String nombre) throws IOException
    {
        clasi = Clasificacion.getInstance(nombre);
        cd = ControladorDatos.getInstance();
        loadClasificacion(nombre);

    }

    /**
     * Dado un nombre de tema, devuelve las informaciones(nombre, color, nombre de tema Padre, y nivel)
     *	del dicho tema
     * @param nombre Nombre de tema
     * @return list La lista de carateristicas de tema
     *
     */
    public String[] infoTema(String nombre) throws IOException
    {
        String[] list = new String[2];
        Tema t = clasi.getTema(nombre);
        list[0] = t.getNombre();
        list[1] = t.getColor();
        return list;
    }

    /**
     * Devuelve las informaciones de temas que contiene
     * @return list Lista de temas
     */
    public ArrayList<String[]> getCatalogo()
    {
        ArrayList<String[]> list = new ArrayList<>();
        int n = clasi.getNumTemas();
        for (int i = 0; i < n; ++i)
        {
            String[] v = new String[2];
            Tema t = clasi.getTemaIndex(i);
            v[0] = t.getNombre();
            if(t.getColor() == null) v[1] = " ";
            else v[1] = t.getColor();
            list.add(v);
        }
        return list;
    }

    /**
     *
     *
     */
    public ArrayList<String> getNombreTemas()
    {
        ArrayList<String> listNombres = new ArrayList<String>();
        ArrayList<String[]> list = getCatalogo();
        for(String[] s : list)
        {
            listNombres.add(s[0]);
        }
        return listNombres;
    }

    /**
     * Dado un nombre de tema, color, y el tema padre, lo añade a la clasificacion
     * @param nombre Nombre de tema
     * @param color Nombre de color
     * @param padre Tema padre
     */
    public void anadirTema(String nombre, String color, String padre) throws IOException
    {
        Tema tema = new Tema(nombre);
        Tema temapadre = new Tema(padre);
        tema.setColor(color);
        clasi.anadirTema(tema, temapadre);
    }


    /**
     * Dado un nombre de tema, lo elimina de la clasificacion
     *
     */
    public void eliminarTema(String nombre) throws IOException
    {
        clasi.eliminarTema(nombre);
    }

    /**
     * Dado un nombre de tema, color, y el nombre del tema padre, modifica el tema
     * @param nombre Nombre de tema
     * @param nombre_nuevo El nombre nuevo que va a tener el tema
     * @param color Nombre de color
     */
    public void modificarTema(String nombre, String nombre_nuevo, String color) throws IOException
    {
        clasi.modificarTema(nombre, nombre_nuevo, color);
    }


    /**
     * Devuelve el nombre de la clasificacion
     *
     */
    public String consultarNombreClasificacion()
    {
        return clasi.getNombre();
    }

    /**
     * Modifica el nombre de la clasificacion
     * @param nombre Nombre de la clasificacion
     */
    public void modificarNombreClasifi(String nombre)
    {
        clasi.setNombre(nombre);
    }


    /**
     * Consultar el numero total de temas que hay
     * @return size
     */
    public int size()
    {
        return clasi.getNumTemas();
    }

    /**
     *
     *
     * @param nombre
     */
    public boolean esTemaValido(String nombre)
    {
        return (clasi.esTemaValido(nombre));
    }

    /**
     *
     */
    public String getPadre(String nombre) throws IOException
    {
        return clasi.getPadre(nombre);
    }

    /**
     *
     */
    public void saveClasificacion() throws IOException
    {
        String s = clasi.saveClasifi();
        String nombre = clasi.getNombre();
        cd.saveClasificacion(nombre, s);
    }

    /**
     *
     */
    public void loadClasificacion(String nombre) throws IOException
    {
        clasi.loadClasifi(cd.loadClasificacion(nombre));
    }

}
