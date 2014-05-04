import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Mingjian Chen 
 */

public class DriverClasificacion 
{
	// el separator para todo los sistemas operativos
	private static final String NEW_LINE = System.getProperty("line.separator");

	public static void main(String args[]) throws IOException
	{
		introduccion();

		InputStreamReader iostream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader (iostream);

        System.out.println("Creamos una nueva clasificacion");
        System.out.println("Pon un nombre de la clasificacion" + NEW_LINE);
        String nombre = (buffer.readLine());
        Clasificacion clasifi = new Clasificacion(nombre);
        Tema tema = new Tema();
        Tema tema_padre = new Tema();

		boolean exit = false;
		while(! exit)
		{
			menu();

			int opcion = Integer.parseInt(buffer.readLine());
			switch(opcion)
			{
				case 1:
                    System.out.println("Nombre de la clasificacion: " + clasifi.getNombre() + NEW_LINE);
                    break;

				case 2: 
				    System.out.println("Pon un nombre de la clasificacion >> ");
                    clasifi.setNombre(buffer.readLine());
                    System.out.println("El nombre ha sido modificado." + NEW_LINE);
                    break;

				case 3:
					System.out.println("Hay " + clasifi.getNumTemas() + " en total." + NEW_LINE);
                    break;

                case 4:
                	System.out.println("Introduzca el nombre del tema >> ");
                    nombre = buffer.readLine();
                    tema = clasifi.getTema(nombre);

                    System.out.println("Nivel: " + tema.getNivel());
                    System.out.println("Numº de hijos: " + tema.getNumHijo());
                    if(tema.getNombre().equals("General"))
                        System.out.println("Tema General");
                    else 
                        System.out.println("Nombre de tema padre: " + tema.getPadre().getNombre());
                    System.out.println("Color: " + tema.getColor() + NEW_LINE);
                	break;

                case 5:
                    System.out.println("Introduzca un nombre del tema para añadir a la clasificacion >> ");
                    nombre = buffer.readLine();
                    tema = new Tema(nombre);

                    System.out.println("Introduzca un nombre del tema padre para asignar >> ");
                    String nombre_padre = buffer.readLine();

                    System.out.println("Introduzca color >> ");
                    tema.setColor(buffer.readLine());

                    tema_padre = clasifi.getTema(nombre_padre);
                    clasifi.anadirTema(tema, tema_padre);
                    System.out.println("Tema añadido!"  + NEW_LINE);
                    break;

                case 6:
                    System.out.println("Introduzca un nombre del tema para eliminar desde la clasificacion >> ");
                    nombre = buffer.readLine();
                    clasifi.desvincularHijos(nombre);
                    System.out.println("Tema(s) eliminado(s)!"  + NEW_LINE);
                    break;

                case 7:
                    System.out.println("Introducid el nombre del tema para modificar >> " + NEW_LINE);
                    nombre = buffer.readLine();

                    System.out.println("nombre >> ");
                    nombre = (buffer.readLine());

                    System.out.println("color >> ");
                    String color = buffer.readLine();

                    System.out.println("nombre tema padre >> ");
                    nombre_padre = buffer.readLine();

                    clasifi.modificarTema(nombre, color, nombre_padre);

                    System.out.println("Tema modificado!"  + NEW_LINE);
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
		System.out.println("--------------------------");
        System.out.println("| Driver de Clasificacion |");
        System.out.println("--------------------------" + NEW_LINE);
	}

	private static void menu()
	{
		System.out.println("Opciones:");
        System.out.println("1) Consultar el nombre de la clasificacion");
        System.out.println("2) Modificar el nombre de la clasificacion");
        System.out.println("3) Consultar el numero de temas en total");
        System.out.println("4) Consultar la info. de tema");
        System.out.println("5) Añadir tema");
        System.out.println("6) Eliminar tema");
        System.out.println("7) Modificar tema");
        System.out.println("0) exit");
        System.out.println(">> " + NEW_LINE);
	}
}
