import java.util.ArrayList;
import java.io.IOException;

/**
 *
 * @author Mingjian Chen 
 */

public class ControladorClasificacion
{

	private Clasificacion clasi;

	public ControladorClasificacion(String nombre)
	{
		clasi = new Clasificacion(nombre);  
	}

	/**
	*
	*
	*/
	public String[] infoTema(String nombre)
	{
		String[] list = new String[4];
		Tema t = clasi.getTema(nombre);
		list[0] = t.getNombre();
        list[1] = t.getColor();
        list[2] = t.getPadre().getNombre();
        list[3] = Integer.toString(t.getNivel());
        return list;
	}

	/**
	*
	*
	*/
	public ArrayList<String[]> getCatalogo() 
	{
		ArrayList<String[]> list = new ArrayList<String[]>();
		for (int i = 0; i < clasi.getNumTemas(); ++i) 
		{
			String[] v = new String[4];
			Tema t = clasi.getTemaIndex(i);
			v[0] = t.getNombre();
			v[1] = t.getColor();
	        if(t.getNombre() == "General")
	        	v[2] = "null";
	        else 
	        	v[2] = t.getPadre().getNombre();

	        v[3] = Integer.toString(t.getNivel());
	        list.add(v);
	    }
	    return list;   
	}

	/**
	*
	*
	*/
	public String consultarNombreClasificacion()
	{
		return clasi.getNombre();
	}

	/**
	*
	*
	*/
	public void modificarNombreClasifi(String nombre) 
	{
		clasi.setNombre(nombre);
	}


	/**
	*
	*
	*/
	public void modificarTema(String nombre, String color, String nombre_padre) throws IOException
	{
		clasi.modificarTema(nombre, color, nombre_padre);
	}

	/**
	* PRIMERO CREAR EL LIBRO, Y LUEGO ASIGNAR LOS TEMAS AL LIBRO !!!!!!·$%"·$·%·"
	*
	*/
	public void anadirTema(String nombre, String color, Tema padre) throws IOException
	{
		Tema tema = new Tema(nombre);
		tema.setColor(color);
        clasi.anadirTema(tema, padre);
	}


	/**
	*
	*
	*/
	public void eliminarTema(String nombre) throws IOException
	{
		clasi.desvincularHijos(nombre);
	}

	/**
	*
	*
	*/
	public int size()
	{
		return clasi.getNumTemas();
	}

}
