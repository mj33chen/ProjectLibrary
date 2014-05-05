import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Mingjian Chen 
 */

public class DriverLibro
{

    private static void introduccion()
    {
        System.out.println("-----------------------");
        System.out.println("| Driver de Libro     |");
        System.out.println("-----------------------" + NEW_LINE);
    }

    private static void menu()
    {
        System.out.println("Opciones:");
        System.out.println("1) Crear un nuevo libro");
        System.out.println("2) Consultar la informacion de libro");
        System.out.println("3) Modificar el autor");
        System.out.println("4) Modificar el titulo");
        System.out.println("5) Modificar el identificador");
        System.out.println("6) Añadir el tema");
        System.out.println("7) Eliminar el tema");
        System.out.println("8) Libro vacio ? ");
        System.out.println("0) exit");
        System.out.println(">> " + NEW_LINE);
    }

	// el separator para todo los sistemas operativos
	private static final String NEW_LINE = System.getProperty("line.separator");

	public static void main(String args[]) throws IOException
	{
		introduccion();

		InputStreamReader iostream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader (iostream);

        String autor, titulo;
        int id;

        Libro libro = new Libro();

		boolean exit = false;
		while(! exit)
		{
			menu();

			int opcion = Integer.parseInt(buffer.readLine());
			switch(opcion)
			{
				case 1:
					System.out.println("Creamos un  libro " + NEW_LINE);

                    System.out.println("Identificador >>");
                    id = (Integer.parseInt(buffer.readLine()));

                    System.out.println("Titulo >>");
                    titulo = (buffer.readLine());

                    System.out.println("Autor >>");
                    autor = (buffer.readLine());

                    Libro libro_ = new Libro(titulo, autor, id);
                    libro = libro_;
                    
                    System.out.println("Libro creado" + NEW_LINE);

					break;

				case 2: 

                    System.out.println("Informacion del libro: " + NEW_LINE);
                    System.out.println("identificador: " + libro.getId());
                    System.out.println("titulo: " + libro.getTitulo());
                    System.out.println("autor: " + libro.getAutor());

                    if(libro.libroEmpty()) System.out.println("Libro sin tema" + NEW_LINE);

                    break;

				case 3:

                    System.out.println("Introducid el nuevo nombre de autor >> " + NEW_LINE);
                    autor = (buffer.readLine());
                    libro.setAutor(autor);
                    System.out.println("Nombre autor modificado" + NEW_LINE);
                    break;

                case 4:

                    System.out.println("Introducid el nuevo titulo >> " + NEW_LINE);
                    titulo = (buffer.readLine());
                    libro.setTitulo(titulo);
                    System.out.println("Titulo modificado" + NEW_LINE);
                    break;

                case 5:

                    System.out.println("Introducid el nuevo identificador >> " + NEW_LINE);
                    id = (Integer.parseInt(buffer.readLine()));
                    libro.setId(id);
                    System.out.println("Identificador modificado" + NEW_LINE);
                    break;

                case 6:
                    System.out.println("Anadir un tema a un libro"  + NEW_LINE);

                    System.out.println("Introducid el nombre del tema >> ");
                    String nombre = (buffer.readLine());
                    Tema tema = new Tema(nombre);

                    libro.anadirTema(tema);
                    System.out.println("Tema anadido" + NEW_LINE);
                    break;

                case 7:
                    System.out.println("Eliminar un tema a un libro"  + NEW_LINE);

                    System.out.println("Introducid el nombre del tema >> ");
                    nombre = (buffer.readLine());

                    libro.eliminarTema(nombre);
                    System.out.println("Tema eliminado" + NEW_LINE);
                    break;

                case 8:
                    if(libro.libroEmpty()) 
                        System.out.println("Libro vacio" + NEW_LINE);
                    else 
                        System.out.println("Hay " + libro.getNumTemas() + " tema(s)" + NEW_LINE);
                    break;

				case 0:
					exit = true;
                    break;
                    
				default: 
					System.out.println("Opcion Invalida!");
                    break;
			}
		}
	}


}
