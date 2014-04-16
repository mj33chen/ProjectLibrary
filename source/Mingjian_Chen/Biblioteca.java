import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.tree;

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
    public anadirClasifi(TreeNode tree)
    {
    	Clasificacion c = new Clasificacion(tree);
    	clasifi.add(c);
    }

	/**
    *
    *
    *
    */
    public eliminarClasifi(TreeNode tree)
    {
   	    Iterator it = clasifi.iterator();
   	    while (it.hasNext()) 
   	    {
	    	Clasificacion clasi = new Clasificacion();
	        clasi = (Clasificacion) it.next();
	        if (clasi.getnombreClasifi() == tree.getnombreClasifi()) it.remove(clasi);
            }
    }

    /**
    *
    *
    *
    */
    public Clasificacion getClasificacion(TreeNode tree)
    {
    	Iterator it = clasifi.iterator();
        while (it.hasNext()) 
        {
            Clasificacion clasi = new Clasificacion();
            clasi = (Clasificacion) it.next();
            if (clasi.getnombreClasifi() == tree.getnombreClasifi()) return clasi;
        }
        return null;
    }
}
