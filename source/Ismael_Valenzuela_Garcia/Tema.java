import java.io.IOException;
import java.util.ArrayList; 

/**
 * Cada nodo de la clasificación es un tema...
 * @author Isma
 */
public class Tema
{

    private String nombre;

    private Tema padre;

    private ArrayList<Tema> hijo;

    private int nivel;

    private static int totalNodos = 0;

    private String color;

    //-------------------------------------
    //-------------------------------------
    
    public Tema() 
    {
        this.nombre = null;
        this.padre = null;
        this.color = null;
        this.nivel = 0;
        this.hijo = new ArrayList<Tema>(); 
    }
    
    public Tema(String nombre) 
    {
        this.nombre = nombre;
        this.padre = null;
        this.color = null;
        this.nivel = 0;
        this. hijo = new ArrayList<Tema>(); 
    }

   
    public String getNombre() {
        return nombre;
    }

    public String getColor()
    {
        return color;
    }

    public int getNivel()
    {
        return nivel;
    }

    public int getNumHijo()
    {
        return totalNodos;
    }

    public void setNivel(int level)
    {
        this.nivel = level;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public void setPadre(Tema padre)
    {
        this.padre = padre;
    }

    public Tema getPadre()
    {
        return padre;
    }

    public ArrayList<Tema> getHijo()
    {
        return hijo;
    }


    public void addHijo(Tema t) throws IOException
    {
        if(t != null)
        {
            hijo.add(t);
        }
        else 
            throw new IOException("No se puede anadir el tema!");
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
            throw new IOException("No se puede eliminar el tema!");

    }

    public boolean esHermano(Tema t)
    {
        return (this.padre == t.padre);
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

