import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DriverControladorBiblioteca
{

	private static final String NEW_LINE = System.getProperty("line.separator");

	public static void main(String args[]) throws IOException
	{
		introduccion();
		
		InputStreamReader iostream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader (iostream);
		System.out.println("Creamos un controlador de biblioteca" + NEW_LINE);
        
		System.out.println("Nombre de biblioteca: " + NEW_LINE);
		String nombre = (buffer.readLine());
		ControladorBiblioteca controlBiblio = new ControladorBiblioteca(nombre);
		//controlBiblio.nuevaBiblio(nombre);
		System.out.println("Biblioteca creada con el nombre: " + controlBiblio.consultarNombreBiblio() + NEW_LINE);

		boolean exit = false;
		while(! exit)
		{
			menu();
			
        	Libro libro = new Libro();
        	int id;
        	String titulo, autor;
        	

			int opcion = Integer.parseInt(buffer.readLine());
			switch(opcion)
			{
				case 1: 
					System.out.println("Introducid el identificador del libro >> " + NEW_LINE);
					id = (Integer.parseInt(buffer.readLine()));

					String[] lista = controlBiblio.infoLibro(id);
					System.out.println("Informacion del libro: " + NEW_LINE);
					System.out.println("identificador: " + lista[0]);
					System.out.println("titulo: " + lista[1]);
					System.out.println("autor: " + lista[2]);
					System.out.println("num de temas: " + lista[3]);
					
					break;

				case 2:
					if(! controlBiblio.isEmpty())
					{
						ArrayList<String[]> list = controlBiblio.getCatalogo();
	                    for (int i = 0; i < list.size(); ++i) 
	                    {
	                        System.out.println("Libro: " + (i+1));
	                        String[] v = list.get(i);
	                        System.out.println("Id: " + v[0]);
	                        System.out.println("Titulo: " + v[1]);
	                        System.out.println("Autor: " + v[2]);
	                        System.out.println("Num. temas: " + v[3] + "\n");
                    	}
					}
					else 
						System.out.println("Catalogo vacio!" + NEW_LINE);

					break;

				case 3:
					System.out.println("Introducid el identificador del libro para modificar >> " + NEW_LINE);
					id = (Integer.parseInt(buffer.readLine()));

					System.out.println("titulo >> ");
					titulo = (buffer.readLine());

					System.out.println("autor >> ");
                    autor = (buffer.readLine());

                    controlBiblio.modificarLibro(id, titulo, autor);
                    System.out.println("Libro modificado >> " + NEW_LINE);
                    break;

				case 4:
					System.out.println("Crear un libro");

					System.out.println("Identificador >>");
					id = (Integer.parseInt(buffer.readLine()));

					System.out.println("Titulo >>");
					titulo = (buffer.readLine());

					System.out.println("Autor >>");
					autor = (buffer.readLine());

					controlBiblio.anadirLibro(id, titulo, autor);
					System.out.println("Libro anadido" + NEW_LINE);
					break;

				case 5:
					System.out.println("Introducid el identificador para eliminar el libro >> " + NEW_LINE);
					id = (Integer.parseInt(buffer.readLine()));
					controlBiblio.eliminarLibro(id);
					System.out.println("Libro eliminado" + NEW_LINE);
					break;

				case 6:
					if(controlBiblio.isEmpty()) System.out.println("Biblioteca vacia." + NEW_LINE);
					else
					{
						System.out.println("Biblioteca NO vacia." + NEW_LINE);
						System.out.println("Hay " + controlBiblio.size() + " libros en total" + NEW_LINE);
					}
					break;
					
				case 7: 
					System.out.println("Introducid un nombre de la biblioteca" + NEW_LINE);
					controlBiblio.modificarNombreBiblio(buffer.readLine());
					System.out.println("Se ha modificado el nombre de la biblioteca" + NEW_LINE);
					break;

				case 8:
					String s = controlBiblio.consultarNombreBiblio();
					System.out.println("nombre de la biblioteca: " + s + NEW_LINE);
					break;

				case 9:
					System.out.println("Introducid el titulo del libro >> ");
					titulo = (buffer.readLine());
					System.out.println("Introducid el nombre del tema >> ");
					String titulo_ = (buffer.readLine());
					controlBiblio.anadirTemaLibro(titulo, titulo_);

					System.out.println("Tema anadido" + NEW_LINE);
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

	private static void introduccion()
	{
		System.out.println("-----------------------------------");
        System.out.println("| Driver de Controlador Biblioteca |");
        System.out.println("-----------------------------------");
	}

	private static void menu()
	{
		System.out.println("Opciones:");
        System.out.println("1) Consultar la info. de libro");
        System.out.println("2) Consultar el catalogo de biblioteca");
        System.out.println("3) Modificar un libro"); 
        System.out.println("4) Añadir un libro");
        System.out.println("5) Eliminar un libro");       
        System.out.println("6) Consultar si el catalogo es vacio");
        System.out.println("7) Modificar el nombre de biblioteca");
        System.out.println("8) Consultar el nombre de biblioteca");
        System.out.println("9) Anadir tema");
        System.out.println("0) exit");
        System.out.println(">> " + NEW_LINE);
	}


}
