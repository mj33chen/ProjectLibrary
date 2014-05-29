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

    private String color;


    public Tema() 
    {
        this.nombre = null;
        this.padre = null;
        this.color = null;

    }
    
    public Tema(String nombre) 
    {
        this.nombre = nombre;
        this.padre = null;
        this.color = null;
    }

   
    public String getNombre() {
        return nombre;
    }

    public String getColor()
    {
        return color;
    }

    public Tema getPadre()
    {
        return padre;
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

}

