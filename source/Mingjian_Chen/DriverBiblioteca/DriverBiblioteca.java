import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DriverBiblioteca
{
	// el separator para todo los sistemas operativos
	private static final String NEW_LINE = System.getProperty("line.separator");

	public static void main(String args[]) throws IOException
	{
		introduccion();

		InputStreamReader iostream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader (iostream);

        System.out.println("Creamos una nueva biblioteca, pon un nombre y nombre de clasificacion para crear" + NEW_LINE);
		String nombre = buffer.readLine();
		System.out.println("Pon un nombre de la clasificacion " + NEW_LINE);
		String nombre_c = buffer.readLine();
		Clasificacion clasifi = new Clasificacion(nombre_c);
        Biblioteca b = new Biblioteca(nombre, clasifi);
        System.out.println("Biblioteca creada con el nombre: " + b.getNombre() + NEW_LINE);
		boolean exit = false;
		while(! exit)
		{
			menu();
			
			
        	Libro libro = new Libro();
        	Tema tema = new Tema();
        	int id;

			int opcion = Integer.parseInt(buffer.readLine());
			switch(opcion)
			{
				case 1: 
					System.out.println("Nombre de biblioteca: " + b.getNombre() + NEW_LINE);
					break;

				case 2:
					System.out.println("Introducid un nombre de la biblioteca >> ");
					b.setNombre(buffer.readLine());
					System.out.println("Se ha modificado el nombre de la biblioteca" + NEW_LINE);
					break;

				case 3:
					System.out.println("Nombre de la clasificacion: " + clasifi.getNombre() + NEW_LINE);
					break;

				case 4:
					System.out.println("Pon un nombre de la clasificacion >> " + NEW_LINE);
					clasifi.setNombre(buffer.readLine());
					break;

				case 5:
					System.out.println("Numero total de libros: " + b.librosSize() + NEW_LINE);
					break;

				case 6:
					System.out.println("Crear un libro");

					System.out.println("Identificador >>");
					libro.setId(Integer.parseInt(buffer.readLine()));

					System.out.println("Titulo >>");
					libro.setTitulo(buffer.readLine());

					System.out.println("Autor >>");
					libro.setAutor(buffer.readLine());

					b.anadirLibro(libro);
					System.out.println("Libro anadido" + NEW_LINE);
					break;

				case 7:
					System.out.println("Anadir un tema a un libro"  + NEW_LINE);

					System.out.println("Introducid el titulo del libro >> ");
					String titulo = (buffer.readLine());
					System.out.println("Introducid el nombre del tema >> ");
					String titulo_ = (buffer.readLine());
					Tema padre = new Tema("General");
					b.anadirTemaLibro(titulo, titulo_, 1, padre);

					System.out.println("Tema anadido" + NEW_LINE);
					break;

				case 8:
					System.out.println("Introducid el identificador para eliminar el libro >> " + NEW_LINE);

					id = (Integer.parseInt(buffer.readLine()));
					b.eliminarLibro(id);
					System.out.println("Libro eliminado");
					break;

				case 9:
					System.out.println("Introducid el identificador del libro >> " + NEW_LINE);
					id = (Integer.parseInt(buffer.readLine()));
					libro = b.getLibro(id);

					System.out.println("Informacion del libro: " + NEW_LINE);
					System.out.println("identificador: " + libro.getId());
					System.out.println("titulo: " + libro.getTitulo());
					System.out.println("autor: " + libro.getAutor());

					if(libro.libroEmpty()) System.out.println("Libro sin tema" + NEW_LINE);
					else libro.showTema();
					break;

				case 10:
					System.out.println("Introducid el identificador del libro para modificar >> " + NEW_LINE);
					id = (Integer.parseInt(buffer.readLine()));

					System.out.println("titulo >> ");
					titulo = (buffer.readLine());

					System.out.println("autor >> ");
                    String autor = (buffer.readLine());

                    b.modificarLibro(id, titulo, autor);
                    System.out.println("Libro modificado >> " + NEW_LINE);
                    break;

				case 11:
					if(b.biblioEmpty()) System.out.println("Biblioteca vacia." + NEW_LINE);
					else System.out.println("Biblioteca NO vacia." + NEW_LINE);
					break;

				case 12:
					System.out.println("La matriz de flujo: " + NEW_LINE);
					double mat[][] = b.fluxMatrix();
					int instanceSize = b.librosSize();
					for (int i = 0; i < instanceSize; i++) 
					{
            			for (int j = 0; j < instanceSize; j++) 
            			{
                			System.out.print(String.format("%1$,.2f", mat[i][j]) + " ");
            			}
            			System.out.println();
            		}

				case 0:
					exit = true;
                    break;
                    
				default: 
					System.out.println("Opcion Invalida!");
                    break;
			}
		}
	}

	private static void introduccion()
	{
		System.out.println("-----------------------");
        System.out.println("| Driver de Biblioteca |");
        System.out.println("------------------------");
	}

	private static void menu()
	{
		System.out.println("Opciones:");
        System.out.println("1) Consultar el nombre de biblioteca");
        System.out.println("2) Modificar el nombre de biblioteca");
        System.out.println("3) Consultar el nombre de la clasificacion actual");
        System.out.println("4) Asignar una nueva clasificacion");
        System.out.println("5) Consultar el numero total de libros");
        System.out.println("6) Añadir un libro");
        System.out.println("7) Añadir un tema");
        System.out.println("8) Eliminar un libro");
        System.out.println("9) Consultar un libro"); 
        System.out.println("10) Modificar un libro"); 
        System.out.println("11) Consultar si el catalogo es vacio");
        System.out.println("12) Generar la matriz flujo"); 
        System.out.println("0) exit");
        System.out.println(">> " + NEW_LINE);
	}
	

}
