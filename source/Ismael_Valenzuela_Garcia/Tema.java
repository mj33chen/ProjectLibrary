import java.io.IOException;
import java.util.ArrayList; 

/**
 * Cada nodo de la clasificación es un tema...
 * @author Isma
 */
public class Tema
{

    private String nombre;

    private String nombre_padre;

    private Tema padre;

    private ArrayList<Tema> hijo;

    private int nivel;

    private int totalNodos = 0;

    private String color;

    //-------------------------------------
    //-------------------------------------
    
    public Tema() 
    {
        this.nombre = null;
        this.nombre_padre = null;
        this.padre = null;
        this.color = null;
        this.nivel = 0;
        this.hijo = new ArrayList<Tema>(); 
    }
    
    public Tema(String nombre) 
    {
        this.nombre = nombre;
        this.nombre_padre = null;
        this.padre = null;
        this.color = null;
        this.nivel = 0;
        this. hijo = new ArrayList<Tema>(); 
    }

   
    public String getNombre() {
        return nombre;
    }

    public String getNombrePadre() 
    {
        return nombre_padre;
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

    public Tema getPadre()
    {
        return padre;
    }

    public ArrayList<Tema> getHijo()
    {
        return hijo;
    }

    public void setNumHijo(int num)
    {
        this.totalNodos = num;
    }

    public void setNivel(int level)
    {
        this.nivel = level;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombrePadre(String nombre_padre) 
    {
        this.nombre_padre = nombre_padre;
    }


    public void setColor(String color)
    {
        this.color = color;
    }

    public void setPadre(Tema padre)
    {
        this.padre = padre;
    }

    public void sumaNodoHijo()
    {
        ++totalNodos;
    }

    public void restaNodoHijo()
    {
        --totalNodos;
    }

    public void addHijo(Tema t)
    {
        Tema help = new Tema();
        help = t;
        hijo.add(help);
        
        //System.out.println("numero total de hijos es " + totalNodos);
    }

    public void deleteHijo(String nombre) 
    {
        int i = 0;        
        for (Tema t : hijo) 
        {
            if (t.getNombre().equals(nombre)) 
            {
                hijo.remove(i);            
                break;
            }
            ++i;
        }
    }

    public boolean esHermano(Tema t)
    {
        return (this.padre == t.padre);
    }
    
    public double calcularSimilitud(Tema t1)
    {
        int lvl1 = t1.getNivel();
        int lvl2 = this.getNivel();
        if(this == t1) return ((double)nivel);

        Tema padre1 = t1.getPadre();
        int dif = Math.abs(nivel-lvl2);
        if(dif == 0 && (padre1.equals(this.padre))) return ((double)lvl1)-1.0;  

        Tema help, aux;

        if(lvl1 > (this.nivel))
        {
            aux = t1;
            help = this;
        }
        else
        {
            aux = this;
            help = t1;
        }

        int i = 0;
        while(i < dif)
        {
            aux = aux.getPadre();
            ++i;
        }

        if(aux.equals(help)) return ((double)aux.getNivel());
        else if(aux.esHermano(help)) return ((double)aux.getNivel())-1.0;

        while(! aux.esHermano(help))
        {
            aux = aux.getPadre();
            help = help.getPadre();
        }
        return ((double)(aux.getNivel() - 1));
    }

    public String toString()
    {
        String s = "Sub-temas: ";
        for(Tema t : hijo)
            s += t.getNombre() + " ";
        s += "\n";
        return s;
    }
    
}

