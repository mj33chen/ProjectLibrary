

import java.io.IOException;

/**
 * Una posicon representa una location donde coloca el libro, puede ser una 
 * posicion vacía si no haya libro. 
 * @author Mingjian Chen 
 */
public class Posicion 
{
    
    private int posX;
    private int posY;
    private boolean empty;
    private Libro libro;
    
    public Posicion() 
    {   
        this.empty = true;
    }
    
    public Posicion(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
        this.empty = true;
    }

    public Posicion(int posX, int posY, Libro l) 
    {
        this.posX = posX;
        this.posY = posY;
        this.libro = l; 
        this.empty = false;
    }
    
    public int getPosX() 
    {
        return posX;
    }
    
    public int getPosY() 
    {
        return posY;
    }
   
    public void setPosX(int x) 
    {
        posX = x;
    }
    
    public void setPosY(int y) 
    {
        posY = y;
    }

    public boolean esEmpty()
    {
        return empty;
    }

    public Libro getLibro()
    {
        return libro;
    }

    public void quitarLibro(int x, int y) throws IOException
    {
        if(! this.esEmpty())
        {
            Posicion p = new Posicion(x, y);
            p.empty = true;
            p.libro = null;
        }
        else 
            throw new IOException("No hay libro para quitar en la posicion " + x + " " + y);
    }

    /**
     *
     * 
     *
     */
    public void colocarLibro(Libro l)
    {
        this.libro = l;
        this.empty = false;
    }
}
