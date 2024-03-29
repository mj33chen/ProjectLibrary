package CapaDominio;

import java.lang.*;
import java.util.ArrayList; 

/**
 * La clase Libro gestiona toda la información relacionada con un libro, permite
 * crear y  modificar un libro y sus temas asociados.
 * 
 * @author Xavier Navarro Ciurana
 */

public class Libro {
    
    private String titulo;
    private String autor;
    private int id;             
    private ArrayList<Tema> temas;
    
    
    /* Creadoras */
    public Libro()
    {
        this.titulo = null;
        this.autor = null;
        this.id = 0;
        temas = new ArrayList<Tema>(); 
    }
    
    public Libro(String titulo, String autor, int id) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.temas = new ArrayList<Tema>();    
    }
    
    /**
     * GETTERS
     * =======
     */
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public int getId() {
        return id;
    }

    public int getNumTemas()
    {
        return temas.size();
    }
    
    public ArrayList<Tema> getVector() {
        return temas;
    }
    
    /**
     * SETTERS
     * =======
     */
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setVector(ArrayList<Tema> temas) {
        this.temas = temas;
    }

    public void anadirTema(Tema t)
    {
        Tema aux = new Tema();
        aux = t;
        temas.add(aux);
    }

    public Boolean libroEmpty() 
    {
        return temas.isEmpty();
    }

    public Boolean esTemaRepetido(String nombre)
    {
        for(Tema tema : temas)
        {  
            if(tema.getNombre().equals(nombre))
            {
                return true;
            }
        }
        return false;
    }

    /**
    *
    *
    *
    */
    public void showTema()
    {
        for(int i = 0; i < temas.size(); ++i)
        {   
            Tema t = temas.get(i);
            System.out.println("Tema " + (i+1) + ": " + t.getNombre() + "\n");
        }
    }

    /**
    *
    *
    *
    */
    public void eliminarTema(String nombre)
    {
        int i = 0;
        for(Tema t : temas)
        {
            if(t.getNombre().equals(nombre))
            {
                temas.remove(i);
                break;
            }
            ++i;
        }
    }
  
}
