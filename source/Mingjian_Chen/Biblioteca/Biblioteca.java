import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;

/**
 * Una clase Biblioteca representa un conjunto de libros.  
 * @author Mingjian Chen
 */

public class Biblioteca
{
    private String nombre;
    //private Clasificacion clasi_actual;
	ArrayList<Libro> libros;


	/**
    * Crear una nueva biblioteca
    * @param nombre El nombre de la biblioteca creada
    * @return la clase Biblioteca 
    */
    public Biblioteca(String nombre)
    {
    	this.nombre = nombre;
    	libros = new ArrayList<Libro>();
        //clasi_actual = null;
    }

    public void modificarLibro(int id, String titulo, String autor)
    {
        for (Libro l : libros) {
            if (l.getId() == id) 
            {
                l.setTitulo(titulo);
                l.setAutor(autor);
                break;
            }
        }
    }

    /**
    * Añadir libro a la biblioteca del sistema    // unique 
    * @param l
    */
    public void anadirLibro(Libro l) 
    {
        // comprobar el id
        Libro aux = new Libro();
        aux = l;
        libros.add(aux);
    }

    /**
    *
    *
    */
    public void anadirTemaLibro(String nombre, String nombre_) throws IOException
    {
        Libro l = _getLibro(nombre);
        if(l != null)
        {
            if(l.noExistido(nombre_))
            {
                Tema t = new Tema(nombre_);
                l.anadirTema(t);
            }
            else 
                throw new IOException("Tema existido!");
        }
        else 
            throw new IOException("Titulo incorrecto!");
    }

	/**
    *
    *
    *
    */
    public void eliminarLibro(int id)
    {
       	int i = 0;        
        for (Libro l : libros) 
        {
            if (l.getId() == id) 
            {
                libros.remove(i);
                break;
            }
            ++i;
        }
    }

    /**
    *
    *
    *
    */
    public Libro _getLibro(String nombre) 
    {
        for(Libro l : libros)
        {
            if(l.getTitulo().equals(nombre)) return l;
        }
        return null;
    }

    /**
    *
    *
    *
    */
    public Libro getLibro(int id) 
    {
    	for(Libro l : libros)
        {
            if(l.getId() == id) return l;
        }
        return null;
    }

    /**
    *
    *
    */
    public Libro getLibroIndex(int index)
    {
        return libros.get(index);
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public boolean biblioEmpty()
    {
        return libros.isEmpty();
    }

    public int librosSize() 
    {
        return libros.size();
    }

    /*public Clasificacion getClasificacion()
    {
        return clasi_actual;
    }*/
}
