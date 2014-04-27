import java.io.IOException;
import java.util.ArrayList; 

/**
 * Cada nodo de la clasificación es un tema...
 * @author Isma
 */
public class Tema {

    private String nombre;

    private Tema padre;

    //private Tema[] hijo;
    private ArrayList<Tema> hijo;

    private int totalNodos;

    //private String color;
    //No decidido
    //private ArrayList<Libro> libros;

    //-------------------------------------
    //-------------------------------------
    
    public Tema() 
    {
        this.nombre = null;
        this.padre = null;
        this.hijo = null;
        this.totalNodos = 0;  
    }
    
    public Tema(String nombre) {
        this.nombre = nombre;
        this.padre = null;
        this.hijo = null;
        this.totalNodos = 0;
        //this.libros = new ArrayList<Libro>();
    }

    /**
     *Crear un nodo con los parametros tema, nombre, y array hijo
     *@param tema El nodo pare 
     *@param nombre El nombre del nodo 
     *@param child Un array de los nodos hijo
     */ 
    public Tema(Tema tema, String nombre, ArrayList<Tema> child)
    {
        this.padre = tema;
        this.hijo = child;
        this.totalNodos = child.size();
        this.nombre = nombre;
    }

   
    public String getNombre() {
        return nombre;
    }

    public Tema getPadre()
    {
        return padre;
    }

    public ArrayList<Tema> getHijo()
    {
        return hijo;
    }

    public int getNumHijo()
    {
        return totalNodos;
    }

    public void addHijo(Tema t) throws IOException
    {
        if(t != null)
        {

            hijo.add(t);
        }
        else 
            throw new IOException("Nodo Invalido!");
    }

    public void deleteHijo(Tema t) throws IOException
    {
        if(t != null)
        {
            if(t.totalNodos != 0)
                hijo.remove(t);
            else 
                throw new IOException("No tiene ningun nodo hijo");
        }
        else
            throw new IOException("Nodo Invalido!");

    }

   public boolean esHermano(Tema t)
   {
        return (this.padre == t.padre);
   }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     /*public String getColor() {
        return color;
    }*/
    
    /*public Libro getLibro(Integer posicion) {
        return libros.get(posicion);
    }*/

    /*public void setColor(String color) {
        this.color = color;
    }*/
    
    //No decidido
    /*public void anadirLibro(Libro libro) 
    {
	Libro aux = new Libro();
        aux = libro;
        libros.add(aux);
    }
    //No decidido
    public void eliminarLibro(int id) {
        int i = 0;
	for(Libro l : libros)
	{
		if(l.getId().equal(id))
		{
			libros.remove(id);
			break;
		}
		++i;
	}
    }*/
    
}

