package CapaDominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;

/**
 * Una clase Biblioteca representa un conjunto de libros, y tiene asignado una Clasificación 
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
    * @param clasi La clasificación que le asigna a la biblioteca
    * @return la clase Biblioteca 
    */
    public Biblioteca(String nombre, Clasificacion clasi)
    {
        this.nombre = nombre;
        libros = new ArrayList<Libro>();
        clasi_actual = clasi;
    }

    /**
    * Generar una matriz del tamaño de numº de libro de la biblioteca, cada elemento
    * es el valor de similitud entre dos libro distintos
    * @return una matriz de valor de similitud 
    */
    public double[][] fluxMatrix() throws IOException
    {
        String nombre1, nombre2;
        ArrayList<Tema> temas1 = new ArrayList<Tema>();
        ArrayList<Tema> temas2 = new ArrayList<Tema>();
        int size = libros.size();
        double[][] flux = new double[size][size];

        for(int i = 0; i < size; ++i)
        {
            for(int j = 0; j < size; ++j)
            {
                Libro l1 = libros.get(i);
                Libro l2 = libros.get(j);
                temas1 = l1.getVector();
                temas2 = l2.getVector();

                if(i != j && (! temas1.isEmpty()) && (! temas2.isEmpty()))
                {  
                    flux[i][j] = 0.0;
                    for(Tema t1 : temas1)
                    {
                        nombre1 = t1.getNombre();
                        for(Tema t2 : temas2)
                        {
                            nombre2 = t2.getNombre();
                            flux[i][j] += clasi_actual.similitud(nombre1, nombre2);
                        }
                    }
                }
                else 
                    flux[i][j] = 0.0;
            }
        }
        return flux;
    }

    /**
    * Dado un id, un titulo, y un nombre de autor, modifica los parámetros del libro con 
    * este identificador
    * @param id Identificador 
    * @param titulo Nombre del titulo 
    * @param autor Nombre del autor
    */
    public void modificarLibro(int id, String titulo, String autor) throws IOException
    {
        if(esLibroValido(id))
        {  
            for (Libro l : libros) 
            {
                if (l.getId() == id) 
                {
                    l.setTitulo(titulo);
                    l.setAutor(autor);
                    break;
                }
            }
        }
        else 
            throw new IOException("Libro no existe!");
    }

    /**
    * Dado un libro, y lo añade a la biblioteca del sistema  
    * @param l Clase libro
    *
    */
    public void anadirLibro(Libro l) throws IOException
    {
        int id = l.getId();
        if(! esLibroValido(id))
        {
            Libro aux = new Libro();
            aux = l;
            libros.add(aux);
        }
        else
            throw new IOException("Libro ya existe!");
    }

    /**
    * Dado un nombre de titulo, un nombre tema, un valor de nivel, y Objecto tema padre
    * añade el tema con el nombre de la variable nombre_ al libro
    * @param id Identificador del libro
    * @param nombre_ Nombre de tema
    * @throws IOException Si la variable nombre_ no existe
    * @throws IOException Si la variable nombre titulo no existe 
    */
    public void anadirTemaLibro(int id, String nombreTema) throws IOException
    {
        if(esLibroValido(id))
        {
            Libro l = new Libro();
            l = getLibro(id);
            if(! l.esTemaRepetido(nombreTema))
            {
                Tema t = new Tema();
                t.setNombre(nombreTema);
                l.anadirTema(t);
            }
            else 
                throw new IOException("Tema ya existe!");
        }
        else 
            throw new IOException("Libro no existe!");
    }

    /**
    * Dado un identificador del libro, lo elimina de la Biblioteca
    * @param id Identificador del libro
    *
    */
    public void eliminarLibro(int id) throws IOException
    {
        if(! esLibroValido(id))
            throw new IOException("Libro no existe!");
        else 
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
    }

    /**
    * Dado un nombre del libro, devuelve Objeto del tipo Libro
    * @param nombre Nombre de libro
    * @return Libro La clase Libro si existe, si no retorna null 
    */
    public Libro _getLibro(String nombre) throws IOException
    {
        for(Libro l : libros)
        {
            if(l.getTitulo() == nombre) return l;
        }
        throw new IOException("Libro no existe!");
    }

    /**
    * Dado un identificador del libro, devuelve Objeto del tipo Libro
    * @param id Identificador de libro
    * @return Libro La clase Libro si existe, si no retorna null 
    */
    public Libro getLibro(int id) throws IOException
    {
        for(Libro l : libros)
        {
            if(l.getId() == id) return l;
        }
        throw new IOException("Libro no existe!");
    }

    /**
    * Dado un index, devuelve la clase Libro
    * @param index Valor de index
    * @return Libro La clase Libro si existe, si no retorna null 
    */
    public Libro getLibroIndex(int index)
    {
        return libros.get(index);
    }

    /**
    * Devuelv el nombre de la Biblioteca
    *
    */
    public String getNombre()
    {
        return nombre;
    }

    /**
    * Dado un nombre, y modifica el nombre la biblioteca
    * @param nombre Nombre de la Biblioteca
    */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
    * Consulta si la Biblioteca es vacía, es decir, si no contiene ningun libro
    * @return True Si no contiene ningun libro
    *          False en caso contrario
    */
    public boolean biblioEmpty()
    {
        return libros.isEmpty();
    }

    /**
    * Devuelve el numero total de libros en la Biblioteca
    * @return libros.size() El numero total de libros
    *
    */
    public int biblioSize() 
    {
        return libros.size();
    }

    /**
    *
    *
    *
    */
    public boolean esLibroValido(int id)
    {
        for (Libro l : libros) 
        {
            if (l.getId() == id) 
                return true;
        }
        return false;
    }


    
    /**
    * Devuelve el vector de libros en la Biblioteca
    * @return libros El vector de libros
    *
    */
    public ArrayList<Libro> getAllLibros()
    {
        return libros;
    }

    /**
    * Devuelve la clasificación asignada
    */
    public Clasificacion getClasificacion()
    {
        return clasi_actual;
    }

    /**
    * Asignar una clasificacion
    * @param c Clase Clasificación 
    *
    */
    public void setClasificacion(Clasificacion c)
    {
        clasi_actual = c;
    }

}
