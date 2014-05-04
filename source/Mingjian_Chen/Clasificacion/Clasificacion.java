import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math.*;

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

	private void init_clasificacion()
	{
		Tema general = new Tema("General");
		temas.add(general);
		general.setNumHijo(0);
		general.setNivel(0);
		++numTemas;
	}

	public Clasificacion(String nombre)
	{
		this.nombre = nombre;
		this.fluxTema = new double[0][0];
		this.temas = new ArrayList<Tema>();
		init_clasificacion();
	}



	/**
	*
	*
	*
	*/
	public void anadirTema(Tema t, Tema padre) throws IOException
	{
		//System.out.println("anteriormente numero de hijos es " + padre.getNumHijo());
		if(! this.nombreValido(t.getNombre()))
		{
			if(this.nombreValido(padre.getNombre()))
			{
				this.temas.add(t);

				//int num = padre.getNumHijo();
				//System.out.println("num es " + num);

				padre.addHijo(t);
				padre.setNumHijo(padre.getNumHijo());
				//System.out.println("numero de hijos es " + t.getNumHijo());
				//t.setNumHijo(num);
				//System.out.println("posteriormente el numero de hijos es " + padre.getNumHijo());

				t.setNivel(padre.getNivel()+1);
				t.setNumHijo(0);
				t.setPadre(padre);
				++numTemas;
			}
			else 
				throw new IOException("Padre inexistente!");
		}
		else 
			throw new IOException("Tema existente!");
	}

	

	public void desvincularHijos(String nombreTema) throws IOException
	{
		if(nombreTema == "General")
			throw new IOException("Intento prohibido!");
		
		if(this.nombreValido(nombreTema))
		{
			Tema t = getTema(nombreTema);

			if(t.getNumHijo() != 0)
			{
				ArrayList<Tema> hijos = t.getHijo();  // hijos de t 
				for(Tema h : hijos)
				{
					desvincularHijos(h.getNombre());
				}
			}
			temas.remove(t);   // suicidar el nodo 
			--numTemas;        // actualizar el numero de temas 
		}
		else 
			throw new IOException("nombre de tema inexistente!");
	}

	public void modificarTema(String nombre, String color, String nombre_padre) throws IOException
    {
        for (Tema t : temas) 
        {
            if (t.getNombre().equals(nombre)) 
            {
            	if(! noExistido(nombre_padre))
            	{
            		Tema help = this.getTema(nombre_padre);
            		t.setColor(color);
            		t.setPadre(help);
            		t.setNombrePadre(nombre_padre);
            		break;
            	}
            	else 
            		throw new IOException("Tema Padre not found!");
            }
        }
    }

	public boolean nombreValido(String nombreTema)
	{
		//System.out.println("El nombre del tema que vamos a comprobar es " + nombreTema);
		for(Tema t : temas)
		{
			//System.out.println("El nombre del tema es " + t.getNombre());
			if(t.getNombre().equals(nombreTema)) return true;
		}
		//System.out.println("Pasa por aqui");
		return false;
	}

	public int getNumTemas()
	{
		return numTemas;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	/**
    *
    *
    *
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
    *
    *
    */
    public Tema getTemaIndex(int index)
    {
        return temas.get(index);
    }

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

