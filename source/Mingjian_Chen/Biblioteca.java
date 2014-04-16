import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.tree;
import java.io.IOException;

/**
 * Una clase Biblioteca representa un conjunto de libros,
 * una biblioteca puede contener una o más clasificaciones. 
 * @author Mingjian Chen
 */

public class Biblioteca extends FacilitySet
{
	private ArrayList<Clasificacion> clasifi;
	private ArrayList<Libro> libros;


	/**
    * Crear una nueva biblioteca
    * @param nombre El nombre de la biblioteca creada
    * @return la clase Biblioteca 
    */
    public Biblioteca(String n)
    {
    	super(n);
    	libros = new ArrayList<Libro>();
    	clasifi = new ArrayList<Clasificacion>();
    }


    /**
    *
    *
    *
    */
    public int getNumClasifi()
    {
    	clasifi.size();
    }


    /**
    *
    *
    *
    */
    public boolean existeClasifi(String nombre) 
    {
        if (Clasificacion c : clasifi)
        {
            if(c.getNombre() == nombre) return true;
        }
        return false;
    }

    /**
    * Añadir una clasificación a la biblioteca del sistema
    * @param nombre Indica el nombre de la clasificación. 
    * @param tree Indica la estrutura de datos de la clasificación. 
    * @throws IOException Si la clasificación existe en la biblioteca
    *           con el dicho nombre  
    */
    public void anadirClasifi(String nombre, TreeNode tree) throws IOException
    {

        if(not this.existeClasifi(nombre))
        {
            Clasificacion clasi = new Clasificacion(nombre, tree);
            clasi.add(c);
        } 
        else 
        {
            throw new IOException("Clasificacion existida");
        }	
    }

	/**
    *
    *
    *
    */
    public void eliminarClasifi(String nombre)
    {
       	Iterator it = clasifi.iterator();
   		while (it.hasNext()) 
        {
            Clasificacion clasi = new Clasificacion();
            clasi = (Clasificacion) it.next();
            if (clasi.getnombreClasifi() == tree.getnombreClasifi()) 
                it.remove(clasi); 
        }  
    }

    /**
    *
    *
    *
    */
    public Clasificacion getClasificacion(String nombre)
    {
    	Iterator it = clasifi.iterator();
        while (it.hasNext()) {
            Clasificacion clasi = new Clasificacion();
            clasi = (Clasificacion) it.next();
            if (clasi.getnombreClasifi() == tree.getnombreClasifi()) return clasi;
        }
        return null;
    }

    /**
    *
    *
    *
    */
    public ArrayList<Clasificacion> getAllClasificacion()
    {
        return clasifi;
    }
}
