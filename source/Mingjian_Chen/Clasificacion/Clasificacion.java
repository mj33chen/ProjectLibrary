package CapaDominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Una clasificación consiste una jerarquia del árbol donde 
 * cada nodo del árbol es un nombre de tema, el root de la jerarquia
 * es el tema general, un tema puede tener vario subtemas o ninguno.
 * @author Mingjian Chen 
 */
public class Clasificacion
{

    private String nombre;

    private static int numTemas = 0;

    private HashMap<String, Integer> m1;

    private HashMap<String, Tema> m2;

    private HashMap<String, ArrayList<Tema>> m3;

    private ArrayList<Tema> temas;

    private Tema general;

    private static Clasificacion singeton = null;

    /**
     * Cuando crea una clasificacion, automaticamente se agrega el tema "General" que es la raiz del
     * la estrutura de árbol, relativamente su numero de hijos es 0, y el nivel que está es 0 por defecto,
     * y aumenta el numero de temas que hay en la clasificacion
     */
    public void init_clasificacion()
    {
        general = new Tema("General");
        temas.add(general);
        //general.setNumHijo(0);
        //general.setNivel(0);

        ++numTemas;
    }

    /**
     * Constructor, dado un nombre, se crea una clasificacion con el dicho nombre.
     */
    public Clasificacion(String nombre)
    {
        this.nombre = nombre;
        m1 = new HashMap<String, Integer>();
        m1.put("General", 0);
        m2 = new HashMap<String, Tema>();
        m3 = new HashMap<String, ArrayList<Tema>>();
        ArrayList<Tema> a = new ArrayList<Tema>();
        m3.put("General", a);
        this.temas = new ArrayList<Tema>();
        init_clasificacion();
    }

    /**
     *
     */
    public static Clasificacion getInstance(String nombre)
    {
        if(singeton == null) singeton = new Clasificacion(nombre);
        return singeton;
    }

    /**
     *
     *
     *
     */
    public double similitud(String t1, String t2) throws IOException
    {
        if(! esTemaValido(t1))
            throw new IOException("Primer tema no existe!");
        if(! esTemaValido(t2))
            throw new IOException("Segundo tema no existe!");

        if(t1.equals(t2)) return 0.0;
        else
        {
            String padre = padreComun(t1, t2);
            int level_padre = m1.get(padre);    // el nivel de padre comun entre dos temas
            int level1 = m1.get(t1);
            int level2 = m1.get(t2);
            return ((level1 - level_padre) + (level2 - level_padre) - 1);
        }
    }

    /**
     * Dado un tema, y un tema padre, el tema será el hijo del tema padre, su nivel es un nivel más inferior
     * del nivel de padre, y este tema hijo no tiene ningun hijo, relativamente aumenta el numero total de temas
     * @param t Tema hijo
     * @param padre Tema padre
     */
    public void anadirTema(Tema t, Tema padre) throws IOException
    {
        //System.out.println( "padre es " + padre.getNombre());
        if(! esTemaValido(padre.getNombre()))
            throw new IOException("Tema padre no existe!");

        String nombre = t.getNombre();   // nombre de tema hijo
        if(! esTemaValido(nombre))
        {
            String nombre_p = padre.getNombre();   // nombre de tema padre
            int level = m1.get(nombre_p);        // obtiene el level de tema padre

            m1.put(nombre, level+1);
            m2.put(nombre, padre);

            ArrayList<Tema> a;
            a = new ArrayList<Tema>();
            a = m3.get(nombre_p);    // obtiene el arraylist de subtemas de tema padre
            a.add(t);
            m3.put(nombre_p, a);
            ArrayList<Tema> nuevo_vector = new ArrayList<Tema>();
            m3.put(nombre, nuevo_vector);
        
            temas.add(t);     // vector de conjunto de temas de la Clasificación
            ++numTemas;
        }
        else
            throw new IOException("Tema ya existe!");
    }


    /**
     * Dado un nombre de tema, se elimina el dicho tema, relativamente los hijos que está nivel más bajo del tema
     * se eliminan también.
     * @param nombreTema Nombre del tema
     * @throws IOException Prohibe eliminar el tema "General"
     */
    public void eliminarTema(String nombreTema) throws IOException
    {
        if(nombreTema.equals("General"))
        {
            throw new IOException("Tema General no inmutable");
        }
        else
        {
            if(esTemaValido(nombreTema))
            {
                Queue<Tema> queue_temas;
                //ArrayList<Tema> a = new ArrayList<String>();
                queue_temas = new LinkedList<Tema>();

                Tema ini = getTema(nombreTema);
                //Tema padre = ini.getPadre();     // saber el tema padre del tema
                queue_temas.add(ini);

                while(! queue_temas.isEmpty())
                {
                    Tema t = queue_temas.element();
                    String nombre = t.getNombre();
                    //System.out.println("el primer elemento es " + t.getNombre());
                    queue_temas.remove();

                    ArrayList<Tema> a = new ArrayList<Tema>();
                    a = m3.get(nombre);

                    if(! a.isEmpty())
                    {
                        for(Tema h : a)
                        {
                            queue_temas.add(h);
                        }
                    }
                    // suicidar el nodo
                    temas.remove(t);
                    m1.remove(t);
                    m2.remove(t);
                    m3.remove(t);
                    --numTemas;        // actualizar el numero de temas
                }
            }
            else
                throw new IOException("Tema no existe!");
        }
    }

    /**
     * Dado un nombre de tema, color, y el nombre del tema padre, modifica el tema
     * @param nombre Nombre de tema
     * @param nombre_nuevo El nombre nuevo que va a tener el tema
     * @param color Nombre de color
     */

    public void modificarTema(String nombre, String nombre_nuevo, String color) throws IOException
    {
        if(esTemaValido(nombre))
        {
            for (Tema t : temas)
            {
                if (t.getNombre().equals(nombre))
                {
                    t.setNombre(nombre_nuevo);
                    t.setColor(color);
                    break;
                }
            }
        }
        else
            throw new IOException("Tema no existe!");
    }

    /**
     * Devuelve el numero total de temas que hay
     * @return numTemas
     */
    public int getNumTemas()
    {
        return this.numTemas;
    }

    /**
     * Devuelve el nombre de la clasificacion
     * @return nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Dado un nombre, y modifica el nombre la clasificacion
     * @param nombre Nombre de la clasificacion
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * Dado un nombre del tema, devuelve la clase Tema
     * @param nombre Nombre de tema
     * @return Tema Si el nombre es valido, null en caso contrario.
     */
    public Tema getTema(String nombre) throws IOException
    {
        for(Tema t : temas)
        {
            if(t.getNombre().equals(nombre)) return t;
        }
        throw new IOException("Tema no existe!");
    }

    /**
     * Dado un index, devuelve la clase Tema
     * @param index Valor de index
     * @return Tema La clase Tema
     */
    public Tema getTemaIndex(int index)
    {
        return temas.get(index);
    }

    /**
     *
     *
     *
     */
    public boolean esTemaValido(String nombre)
    {
        for (Tema t : temas)
        {
            if (t.getNombre().equals(nombre))
                return true;
        }
        return false;
    }

    /**
     *
     */
    public String getPadre(String nombre) throws IOException
    {
        if(esTemaValido(nombre))
            return m2.get(nombre).getNombre();
        else
            throw new IOException("Tema no existe!");
    }

    /**
     *
     *
     *
     */
    public String padreComun(String t1, String t2)
    {
        if(t1.equals("General") || t2.equals("General")) return "General";

        int level1 = m1.get(t1);   // el nivel de tema 1
        int level2 = m1.get(t2);   // el nivel de tema 2
        int dif = Math.abs(level1-level2);

        Tema tema1, tema2;
        String nombre1 = t1;
        String nombre2 = t2;

        while(dif != 0)
        {
            if(level1 < level2)
            {
                tema2 = m2.get(nombre2);
                nombre2 = tema2.getNombre();
            }
            else
            {
                tema1 = m2.get(nombre1);
                nombre1 = tema1.getNombre();
            }
            --dif;
        }

        if(nombre1.equals(t2)) return t2;
        else if(nombre2.equals(t1)) return t1;
        else
        {
            while(! nombre1.equals(nombre2))
            {
                tema1 = m2.get(nombre1);
                nombre1 = tema1.getNombre();
                tema2 = m2.get(nombre2);
                nombre2 = tema2.getNombre();
            }
            return nombre1;
        }
    }

    public String saveClasifi()
    {
        String s = new String();
        s = s.concat("General");
        ArrayList<Tema> list = temas;
        list.remove(general);
        for(Tema t : list)
        {
            s = s.concat("" + t.getNombre());
            s = s.concat(",");
            s = s.concat(t.getPadre().getNombre());
            s = s.concat(",");
        }
        return s;
    }

    public void loadClasifi(String s) throws IOException
    {
        String[] themes = s.split(",\\s*");
        int num = themes.length/2;
        for(int i = 0; i < num; ++i)
        {
            Tema tema = new Tema();
            tema.setNombre(themes[i*2 + 0]);
            Tema padre = new Tema(themes[i*2] + 1);
            this.anadirTema(tema, padre);
        }
    }

}
