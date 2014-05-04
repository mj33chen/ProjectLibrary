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
    private Clasificacion clasi_actual;
    private ArrayList<Libro> libros;


    /**
    * Crear una nueva biblioteca
    * @param nombre El nombre de la biblioteca creada
    * @return la clase Biblioteca 
    */
    public Biblioteca(String nombre, Clasificacion clasi)
    {
        this.nombre = nombre;
        libros = new ArrayList<Libro>();
        clasi_actual = clasi_actual;
    }



    public double[][] fluxMatrix()
    {
        int size = libros.size();
        double[][] flux = new double[size][size];
        for(int i = 0; i < size; ++i)
        {
            for(int j = 0; j < size; ++j)
            {
                if(i != j)
                {  
                    Libro l1 = libros.get(i);
                    Tema t1 = l1.temaMaxLVL();
                    Libro l2 = libros.get(j);
                    Tema t2 = l2.temaMaxLVL();
                    flux[i][j] = t1.calcularSimilitud(t2);
                }
                else 
                    flux[i][j] = 0.0;
            }
        }
        return flux;
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
    public void anadirTemaLibro(String nombre, String nombre_, int nivel, Tema padre) throws IOException
    {
        Libro l = _getLibro(nombre);
        if(l != null)
        {
            if(l.noExistido(nombre_))
            {
                Tema t = new Tema(nombre_);
                t.setNivel(nivel);
                t.setPadre(padre);
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
            if (id == l.getId()) 
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

    /**
    *
    *
    */
    public ArrayList<Libro> getAllLibros()
    {
        return libros;
    }

    public Clasificacion getClasificacion()
    {
        return clasi_actual;
    }

    public void setClasificacion(Clasificacion c)
    {
        clasi_actual = c;
    }

}
