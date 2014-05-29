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

        System.out.println("Creamos una nueva clasificacion" + NEW_LINE);
        System.out.println("Pon un nombre de la clasificacion >> ");
        String nombre = (buffer.readLine());
        String color;
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

                    System.out.println("Nombre " + nombre);
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

                    tema_padre = new Tema(nombre_padre);
                    clasifi.anadirTema(tema, tema_padre);
                    System.out.println("Tema añadido!"  + NEW_LINE);
                    break;

                case 6:
                    System.out.println("Introduzca un nombre del tema para eliminar desde la clasificacion >> ");
                    nombre = buffer.readLine();
                    clasifi.eliminarTema(nombre);
                    System.out.println("Tema(s) eliminado(s)!"  + NEW_LINE);
                    break;

                case 7:
                    System.out.println("Introducid el nombre del tema para modificar >> ");
                    nombre = buffer.readLine();
                    tema = clasifi.getTema(nombre);

                    if(nombre.equals("General"))
                    {
                        System.out.println("color >> ");
                        color = buffer.readLine();
                        tema.setColor(color);
                    }
                    else 
                    {
                        System.out.println("nombre nuevo >> ");
                        String nombre_nuevo = (buffer.readLine());

                        System.out.println("color >> ");
                        color = buffer.readLine();

                        clasifi.modificarTema(nombre, nombre_nuevo, color);
                    }

                    System.out.println("Tema modificado!"  + NEW_LINE);
                    break;

                case 8:
                    System.out.println("Introducid el nombre del tema >> ");
                    nombre = buffer.readLine();

                    System.out.println("Introducid el nombre del tema >> ");
                    String nombre2 = buffer.readLine();

                    double simi = clasifi.similitud(nombre, nombre2);
                    System.out.println("La similaridad entre tema " + nombre + " y tema " + nombre2 + " es " + simi);
                    break;

                case 9:
                    System.out.println("Introducid el nombre del tema >> ");
                    nombre = buffer.readLine();

                    System.out.println("Introducid el nombre del tema >> ");
                    nombre2 = buffer.readLine();

                    String p = clasifi.padreComun(nombre, nombre2);
                    System.out.println("El padre comun entre tema " + nombre + " y tema " + nombre2 + " es " + p);
                    break;

                case 10:
                    System.out.println("Introducid un nombre del tema >> ");
                    nombre  = (buffer.readLine());
                    if(clasifi.esTemaValido(nombre)) 
                        System.out.println("Tema es valido.");
                    else 
                        System.out.println("Tema no es valido.");
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
        System.out.println("8) Calcular la similaridad entre dos temas");
        System.out.println("9) Padre comun de dos temas");
        System.out.println("10) Consultar si el tema es valido");
        System.out.println("0) exit");
        System.out.println(">> " + NEW_LINE);
	}
}
