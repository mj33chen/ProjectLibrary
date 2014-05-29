package CapaDominio;

import java.util.ArrayList;
import java.io.IOException;

/**
 *
 * @author Mingjian Chen 
 */

public class ControladorBiblioteca
{

	private Biblioteca biblio;

	/**
	* Constructor default
	*/
	public ControladorBiblioteca()
	{
		biblio = null;  
	}

	/**
	* Constructor 
	*/
	public ControladorBiblioteca(String nombre, Clasificacion clasi)
	{
		this.biblio = new Biblioteca(nombre, clasi);  
	}

	/**
	* Dado un id del libro, devuelve las informaciones(id, titulo, autor, y numero de temas del libro
	* @param id Identificador
	* @return list La lista de carateristicas de libro
	*/
	public String[] infoLibro(int id) throws IOException
	{
		String[] list = new String[3];
		Libro l = biblio.getLibro(id);
		list[0] = Integer.toString(l.getId());
		list[1] = l.getTitulo();
        list[2] = l.getAutor();
        return list;
	}

	/**
	* Devuelve las informaciones de libros que contiene
	* @return list Lista de libros
	*/
	public ArrayList<String[]> getCatalogo() 
	{
		ArrayList<String[]> list = new ArrayList<String[]>();
		for (int i = 0; i < biblio.biblioSize(); ++i) 
		{
			String[] v = new String[3];
			Libro l = biblio.getLibroIndex(i);
			v[0] = Integer.toString(l.getId());
			v[1] = l.getTitulo();
	        v[2] = l.getAutor();
	        list.add(v);
	    }
	    return list;   
	}

	/**
	* Generar la matriz de flujo 
	*
	*/
	public double[][] generarMatriz() throws IOException
	{
		return biblio.fluxMatrix();
	}

	/**
	* Consultar el nombre de la biblioteca
	* @return biblio.getNombre() El nombre de la biblioteca 
	*/
	public String consultarNombreBiblio()
	{
		return biblio.getNombre();
	}

	/**
	* Modificar el nombre de la bibliteca
	* @param nombre 
	*/
	public void modificarNombreBiblio(String nombre) 
	{
		biblio.setNombre(nombre);
	}

	/**
	* Consultar el nombre de la clasificacion asignada
	* @return biblio.getClasificacion().getNombre() Nombre de la clasificacion
	*/
	public String consultarNombreClasificacion()
	{
		return biblio.getClasificacion().getNombre();
	}

	/**
	* Reasignar la clasificacion a la biblioteca
	* @param c La clase Clasificacion
	*/
	public void setClasificacion(Clasificacion c)
	{
		biblio.setClasificacion(c);
	}


	/**
	* Dado un id, un titulo, y nombre de autor, modifica las carateristicas del libro
	* @param id identificador
	* @param titulo Nombre del titulo
	* @param autor Nombre del autor
	*/
	public void modificarLibro(int id, String titulo, String autor) throws IOException
	{
		biblio.modificarLibro(id, titulo, autor);
	}

	/**
	* Dado un id, un titulo, y nombre de autor, añade un libro con estas carateristicas 
	* @param id identificador
	* @param titulo Nombre del titulo
	* @param autor Nombre del autor
	*/
	public void anadirLibro(int id, String titulo, String autor) throws IOException
	{
		Libro l = new Libro();
		l.setId(id);
		l.setTitulo(titulo);
        l.setAutor(autor);
        biblio.anadirLibro(l);
	}

	/**
    * Dado un nombre de titulo, un nombre tema añade el tema con el nombre de la variable nombre_ al libro
    * @param id Identificador del libro
    * @param nombre_ Nombre de tema
    */
	public void anadirTemaLibro(int id, String tema) throws IOException
	{
		biblio.anadirTemaLibro(id, tema);
	}

	/**
    * Dado un identificador del libro, lo elimina de la Biblioteca
    * @param id Identificador del libro
    */
	public void eliminarLibro(int id) throws IOException
	{
		biblio.eliminarLibro(id);
	}

	/**
    * Consulta si la Biblioteca es vacía, es decir, si no contiene ningun libro
    * @return True Si no contiene ningun libro
    *          False en caso contrario
    */
	public boolean isEmpty()
	{
		return biblio.biblioEmpty();
	}

	/**
    *
    *
    *
    */
    public boolean esLibroValido(int id)
    {
    	return biblio.esLibroValido(id);
    }

	/**
    * Devuelve el numero total de libros en la Biblioteca
    * @return libros.size() El numero total de libros
    *
    */
	public int size()
	{
		return biblio.biblioSize();
	}

	/**
	*
	*
	*/
	public Biblioteca getBiblioteca()
	{
		return biblio;
	}

}
