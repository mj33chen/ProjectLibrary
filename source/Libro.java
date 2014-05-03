

import java.util.ArrayList;
import biblioteca_1.Tema;

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
    public Libro() {}
    
    public Libro(String titulo, String autor, int id, ArrayList<Tema> temas) {
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
    
    public int getId () {
        return id;
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
    
    public void anadirTema() {
        
    }
    
    public void eliminarTema() {
        
    }
    
}






