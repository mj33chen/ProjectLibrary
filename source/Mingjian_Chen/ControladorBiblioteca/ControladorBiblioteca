import java.util.ArrayList;
import javax.swing.tree;
import java.io.IOException;

/**
 *
 * @author Mingjian Chen 
 */

public class ControladorBiblioteca
{
	private Biblioteca biblio;

	/**
     * Creadora
     */
	public ControladorBiblioteca()
	{
		biblio = null;
	}

	/**
     * Crea una nueva biblioteca en el sistema
     * @param n Indica el nombre de la nueva biblioteca. 
     */
	public nuevaBiblioteca(String n)
	{
		biblio = new Biblioteca(n);
	}

	/**
	 * Añadir una clasificación en el sistema, basando en  
	 * @param n Indica el nombre de la clasificación añadida
	 * @throws IOException No se puede añadir la clasificación en el sistema 
	 */
	public void anadirClasifi(Clasificacion c) throws IOException
	{
		biblio.anadirClasifi(c);
	}

	public void eliminarClasifi(String n)
	{
		biblio.eliminarClasifi(n);
	}

	public Clasificacion getClasificacion(String nom)
	{
		return biblio.getClasificacion(nom);
	}

	public ArrayList<String[]> getAllClasifi()
	{
		ArrayList<String[]> ret = new ArrayList<String[]>();
        ArrayList<Clasificacion> clasi = biblio.getAllClasifi();
        for (Clasificacion c : clasi) 
        {
            String[] s = new String[2];
            s[0] = "nombre: " + c.getNombre();
            s[1] = "numero de temas: " + c.getNumTemas();
            ret.add(s);
        }
        return ret;
	}

	public ArrayList<String[]> getAllLibros()
	{
		ArrayList<String[]> ret = new ArrayList<String[]>();
        ArrayList<Libro> libros = biblio.getAllLibros();
        for (Libro l : libros) 
        {
            String[] s = new String[3];
            s[0] = "titulo: " + l.getTitulo();
            s[1] = "autor: " + l.getAutor();
            s[2] = "identificador: " + l.getId();
            ret.add(s);
        }
        return ret;
	}

	/**
     * Retorna la matriz del flujo 
     * @return La matriu de distancias entre los libros colocados 
     */
	public int[][] getMatriz()    
	{									
		return biblio.getFlux(); // posiblemente en la clase compartida falta esta función 
	}

	/**
     * Retorna la biblioteca del sistema
     * @return La biblioteca del sistema
     */
	public Biblioteca getBiblioteca()
	{
		return biblio;
	}

}
