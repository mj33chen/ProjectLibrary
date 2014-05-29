package CapaDominio;

import java.util.ArrayList;
import java.io.IOException;

/**
 *
 * @author Mingjian Chen 
 */

public class ControladorClasificacion
{

	private Clasificacion clasi;

	/**
	* Constructor
	*/
	public ControladorClasificacion(String nombre)
	{
		clasi = new Clasificacion(nombre);  
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
		ArrayList<String[]> list = new ArrayList<String[]>();
		for (int i = 0; i < clasi.getNumTemas(); ++i) 
		{
			String[] v = new String[2];
			Tema t = clasi.getTemaIndex(i);
			v[0] = t.getNombre();
			v[1] = t.getColor();
	        list.add(v);
	    }
	    return list;   
	}


	/**
	* Dado un nombre de tema, color, y el tema padre, lo añade a la clasificacion 
	* @param nombre Nombre de tema
	* @param color Nombre de color
	* @param padre Tema padre
	*/
	public void anadirTema(String nombre, String color, Tema padre) throws IOException
	{
		Tema tema = new Tema(nombre);
		tema.setColor(color);
        clasi.anadirTema(tema, padre);
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
	* @param nombre_padre Nombre de tema padre
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
	*/
	public boolean esTemaValido(String nombre) 
	{
		return clasi.esTemaValido(nombre);
	}

}
