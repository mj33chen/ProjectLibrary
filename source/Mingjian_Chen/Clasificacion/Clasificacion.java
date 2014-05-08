import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math.*;
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

	private double[][] fluxTema;

	private static int numTemas = 0;

	private ArrayList<Tema> temas;

	private Tema general;

	/**
	* Cuando crea una clasificacion, automaticamente se agrega el tema "General" que es la raiz del
	* la estrutura de árbol, relativamente su numero de hijos es 0, y el nivel que está es 0 por defecto, 
	* y aumenta el numero de temas que hay en la clasificacion 
	*/
	private void init_clasificacion()
	{
		general = new Tema("General");
		temas.add(general);
		general.setNumHijo(0);
		general.setNivel(0);
		++numTemas;
	}

	/**
	* Constructor, dado un nombre, se crea una clasificacion con el dicho nombre. 
	*/
	public Clasificacion(String nombre)
	{
		this.nombre = nombre;
		this.fluxTema = new double[0][0];
		this.temas = new ArrayList<Tema>();
		init_clasificacion();
	}



	/**
	* Dado un tema, y un tema padre, el tema será el hijo del tema padre, su nivel es un nivel más inferior
	* del nivel de padre, y este tema hijo no tiene ningun hijo, relativamente aumenta el numero total de temas 
	* @param t Tema hijo
	* @param padre Tema padre
	*/
	public void anadirTema(Tema t, Tema padre)
	{		
		int num = padre.getNumHijo();
		//System.out.println("num es " + num);

		padre.addHijo(t);
		padre.sumaNodoHijo();
		padre.setNumHijo(padre.getNumHijo());

		//System.out.println("numero de hijos es " + t.getNumHijo());
		//t.setNumHijo(num);
		//System.out.println("posteriormente el numero de hijos es " + padre.getNumHijo());

		t.setNivel(padre.getNivel()+1);
		t.setNumHijo(0);
		t.setPadre(padre);
		temas.add(t);     // vector de conjunto de temas de la Clasificación 
		++numTemas;
	}


	/**
	* Dado un nombre de tema, se elimina el dicho tema, relativamente los hijos que está nivel más bajo del tema
	* se eliminan también.
	* @param nombreTema Nombre del tema
	* @throws IOException Prohibe eliminar el tema "General"
	*/
	public void desvincularHijos(String nombreTema) throws IOException
	{
		if(nombreTema.equals("General"))
		{
			throw new IOException("Intento prohibido!");
		}
		else 
		{
			Queue<Tema> queue_temas;
			queue_temas = new LinkedList<Tema>();
			Tema ini = getTema(nombreTema);
			Tema padre = ini.getPadre();     // saber el tema padre del tema 
			queue_temas.add(ini);

			while(! queue_temas.isEmpty())
			{
				Tema t = queue_temas.element();
				//System.out.println("el primer elemento es " + t.getNombre());
				queue_temas.remove();

				if(t.getNumHijo() != 0)
				{
					ArrayList<Tema> hijos = t.getHijo();  // hijos de t
					
					for(Tema h : hijos)
					{
						queue_temas.add(h);
					}
				}
				temas.remove(t);   // suicidar el nodo
				--numTemas;        // actualizar el numero de temas 
			}

			// actualizar las informaciones del tema padre 
			padre.restaNodoHijo();
			padre.deleteHijo(nombreTema);
		}
	}

	/**
	* Dado un nombre de tema, color, y el nombre del tema padre, modifica el tema
	* @param nombre Nombre de tema
	* @param nombre_nuevo El nombre nuevo que va a tener el tema 
	* @param color Nombre de color
	* @param nombre_padre Nombre de tema padre
	*/

	public void modificarTema(String nombre, String nombre_nuevo, String color, String nombre_padre)
    {
        for (Tema t : temas) 
        {
            if (t.getNombre().equals(nombre)) 
            {
        		Tema help = getTema(nombre_padre);
        		t.setNombre(nombre_nuevo);
        		t.setColor(color);
        		t.setPadre(help);
        		t.setNombrePadre(nombre_padre);
        		break;
            }
        }
    }

	/**
	* Devuelve el numero total de temas que hay
	* @return numTemas
	*/
	public int getNumTemas()
	{
		return numTemas;
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
    public Tema getTema(String nombre) 
    {
    	for(Tema t : temas)
        {
            if(t.getNombre().equals(nombre)) return t;
        }
        return null;
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
    * Dado un nombre tema, consulta si el tema existe o no 
    * @param nombre Nombre de tema
    * @return True Si no existe, false en caso contrario.
    */
    public Boolean noExistido(String nombre)
    {
        for(Tema tema : temas)
        {  
            if(tema.getNombre() == nombre)
            {
                return false;
            }
        }
        return true;
    }
}
