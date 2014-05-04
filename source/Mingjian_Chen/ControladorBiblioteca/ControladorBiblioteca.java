import java.util.ArrayList;
import java.io.IOException;

/**
 *
 * @author Mingjian Chen 
 */

public class ControladorBiblioteca
{

	private Biblioteca biblio;

	public ControladorBiblioteca(String nombre, Clasificacion clasi)
	{
		this.biblio = new Biblioteca(nombre, clasi);  
	}

	/**
	*
	*
	*/
	public String[] infoLibro(int id)
	{
		String[] list = new String[4];
		Libro l = biblio.getLibro(id);
		list[0] = Integer.toString(l.getId());
		list[1] = l.getTitulo();
        list[2] = l.getAutor();
        list[3] = Integer.toString(l.getNumTemas());
        return list;
	}

	/**
	*
	*
	*/
	public ArrayList<String[]> getCatalogo() 
	{
		ArrayList<String[]> list = new ArrayList<String[]>();
		for (int i = 0; i < biblio.librosSize(); ++i) 
		{
			String[] v = new String[4];
			Libro l = biblio.getLibroIndex(i);
			v[0] = Integer.toString(l.getId());
			v[1] = l.getTitulo();
	        v[2] = l.getAutor();
	        v[3] = Integer.toString(l.getNumTemas());
	        list.add(v);
	    }
	    return list;   
	}

	/**
	*
	*
	*
	*/
	public double[][] GenerarMatriz()
	{
		return biblio.fluxMatrix();
	}

	/**
	*
	*
	*/
	public String consultarNombreBiblio()
	{
		return biblio.getNombre();
	}

	/**
	*
	*
	*/
	public void modificarNombreBiblio(String nombre) 
	{
		biblio.setNombre(nombre);
	}
	/**
	*
	*
	*/
	public String consultarNombreClasificacion()
	{
		return biblio.getClasificacion().getNombre();
	}

	/**
	*
	*
	*/
	public void setClasificacion(Clasificacion c)
	{
		biblio.setClasificacion(c);
	}


	/**
	*
	*
	*/
	public void modificarLibro(int id, String titulo, String autor) 
	{
		biblio.modificarLibro(id, titulo, autor);
	}

	/**
	* PRIMERO CREAR EL LIBRO, Y LUEGO ASIGNAR LOS TEMAS AL LIBRO !!!!!!·$%"·$·%·"
	*
	*/
	public void anadirLibro(int id, String titulo, String autor)
	{
		Libro l = new Libro();
		l.setId(id);
		l.setTitulo(titulo);
        l.setAutor(autor);
        biblio.anadirLibro(l);
	}

	/**
	*
	*
	*/
	public void anadirTemaLibro(String nombre, String tema, int nivel, Tema padre) throws IOException
	{
		//Tema t = new Tema();
		//t.setNombre(tema);
		biblio.anadirTemaLibro(nombre, tema, nivel, padre);
	}

	/**
	*
	*
	*/
	public void eliminarLibro(int id) 
	{
		biblio.eliminarLibro(id);
	}

	/**
	*
	*
	*/
	public boolean isEmpty()
	{
		return biblio.biblioEmpty();
	}

	/**
	*
	*
	*/
	public int size()
	{
		return biblio.librosSize();
	}

}
