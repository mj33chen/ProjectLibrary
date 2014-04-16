import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.tree;

public class DriverBiblioteca
{
	// el separator para todo los sistemas operativos
	private static final String NEW_LINE = System.getProperty("line.separator");

	public static void main(String args[]) throws IOException
	{
		introduccion();

		InputStreamReader iostream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader (iostream);

		boolean exit = false;
		while(not exit)
		{
			menu();
			
			System.out.println("Creamos una nueva biblioteca" + NEW_LINE);
			String nombre = buffer.readLine();
        	Biblioteca b = new Biblioteca(nombre);
        	System.out.println("Biblioteca creada con el nombre: " + b.getName() + NEW_LINE);

			int opcion = Integer.parseInt(buffer.readLine());
			switch(opcion)
			{
				case 0: 
					System.out.println("Nombre de biblioteca:" + NEW_LINE);
					System.out.println(b.getName() + NEW_LINE);
					break;

				case 1:
					System.out.println("Se ha modificado el nombre de la biblioteca" + NEW_LINE);
					b.setName(buffer.readLine());
					break;

				case 2:
					System.out.println("Numero total de clasificaciones:" + NEW_LINE);
					System.out.println(b.getNumClasifi() + NEW_LINE);
					break;

				case 3:
					System.out.println("Añadir una clasificacion" + NEW_LINE);
					// Dude

				case 4:
					System.out.println("Eliminar una clasificacion" + NEW_LINE);
					String nombre = (buffer.readLine());
					b.eliminarClasifi(nombre);
					break;

				case 5:
					System.out.println("Informacion de la clasificacion" + NEW_LINE);
					String nombre = (buffer.readLine());
					Clasificacion c = new Clasificacion();
					c = n.getClasificacion(nombre);
					if(c != null) 
						System.out.println("Numero de temas: " + NEW_LINE) // Dude
						System.out.println("Lista de temas: "); // Dude
						break;

				case 6:
					System.out.println("Numero de libros de biblioteca: " + NEW_LINE);
					System.out.println(b.size() + NEW_LINE);
					break;

				case 7:
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
		System.out.println("-----------------------" + NEW_LINE);
        System.out.println("| Driver de Biblioteca |" + NEW_LINE);
        System.out.println("------------------------" + NEW_LINE);
	}

	private static void menu()
	{
		System.out.println("Opciones:" + NEW_LINE);
        System.out.println("0) Consultar el nombre de biblioteca" + NEW_LINE);
        System.out.println("1) Modificar el nombre de biblioteca" + NEW_LINE);
        System.out.println("2) Consultar el numero total de la clasificación" + NEW_LINE);
        System.out.println("3) Añadir una clasificación" + NEW_LINE);
        System.out.println("4) Eliminar una clasificación" + NEW_LINE);
        System.out.println("5) Consultar clasificación" + NEW_LINE);    
        System.out.println("6) Consultar el numero total de libros" + NEW_LINE);    
        System.out.println("7) exit" + NEW_LINE);
        System.out.println(">> ");
	}


}
