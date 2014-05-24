

import java.io.IOException;

/**
 * Una posicon representa una location donde coloca el libro, puede ser una 
 * posicion vacía si no haya libro. 
 * @author Mingjian Chen 
 */
public class Posicion 
{
    
    private double posX;
    private double posY;
    private boolean empty;
    private Libro libro;
    
    /**
    * Constructor por defecto, x = 0, y = 0
    */
    public Posicion() 
    {   
        this.empty = true;
    }
    
    /**
    * Dado valor x, y, substituyen a los parametros x, y
    * @param posX
    * @param posY
    */
    public Posicion(double posX, double posY)
    {
        this.posX = posX;
        this.posY = posY;
        this.empty = true;
    }

    /**
    * Dado la clase Libro, y el valor x, y, substituyen a los parametros implicito x, y
    * @param posX
    * @param posY
    * @param l La clase Libro
    */
    public Posicion(double posX, double posY, Libro l) 
    {
        this.posX = posX;
        this.posY = posY;
        this.libro = l; 
        this.empty = false;
    }
    
    /**
    * Devuelve el eje x de la posicion 
    */
    public double getPosX() 
    {
        return posX;
    }
    
    /**
    * Devuelve el eje y de la posicion 
    */
    public double getPosY() 
    {
        return posY;
    }
   
    /**
    * Dado un valor x, modifica el eje x de la posicion 
    * @param x Valor x
    */
    public void setPosX(double x) 
    {
        posX = x;
    }
    
    /**
    * Dado un valor y, modifica el eje y de la posicion 
    * @param y Valor y
    */
    public void setPosY(double y) 
    {
        posY = y;
    }

    /**
    * Consultar si la posicion no contiene ningun libro
    * @return True si es vacio, false en caso contrario
    *
    */
    public boolean esEmpty()
    {
        return empty;
    }

    /**
    * Devuelve la clase libro de la posicion
    * @return libro
    */
    public Libro getLibro()
    {
        return libro;
    }

    /**
    * Quita un libro de la posicion
    */
    public void quitarLibro()
    {
        this.empty = true;
        this.libro = null;
    }

    /**
     * Dado una clase libro l, coloca a la posicion
     * @param l La clase Libro
     */
    public void colocarLibro(Libro l)
    {
        this.libro = l;
        this.empty = false;
    }
}
