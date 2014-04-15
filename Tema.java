/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biblioteca_1;

import java.util.ArrayList;

/**
 *
 * @author Isma
 */
public class Tema {
    private String nombre;
    private String color;
    //No decidido
    private ArrayList<Libro> libros;

    //-------------------------------------
    //-------------------------------------
    
    public Tema() {
    }
    
    public Tema(String nombre, String color) {
        this.color = color;
        this.nombre = nombre;
    }
    
    //No decidido
    public Tema(String nombre, String color, ArrayList<Libro> libros) {
        this.color = color;
        this.nombre = nombre;
        this.libros = new ArrayList<>(libros);
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }
    
    public Libro getLibro(Integer posicion) {
        return libros.get(posicion);
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public void setColor(String color) {
        this.color = color;
    }
    
    //No decidido
    public void anadirLibro(Integer posicion, Libro libro) {
        this.libros.add(posicion, libro);
    }
    //No decidido
    public void eliminarLibro(Integer posicion) {
        this.libros.remove(posicion);
    }
    
}
