import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DriverControladorClasificacion
{

	private static final String NEW_LINE = System.getProperty("line.separator");

	public static void main(String args[]) throws IOException
	{
		introduccion();
		
		InputStreamReader iostream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader (iostream);
		System.out.println("Creamos un controlador de clasificacion" + NEW_LINE);
        
		System.out.println("Nombre de clasificacion: >> ");
		String nombre = (buffer.readLine());
		ControladorClasificacion controlClasifi = new ControladorClasificacion(nombre);
		System.out.println("Clasificacion creada con el nombre: " + controlClasifi.consultarNombreClasificacion() + NEW_LINE);

		boolean exit = false;
		while(! exit)
		{
			menu();
			
        	Tema tema = new Tema();
        	int lvl;
        	String color, nombre_padre;
        	
			int opcion = Integer.parseInt(buffer.readLine());

			switch(opcion)
			{
				case 1: 
					System.out.println("Introducid el nombre del tema >> ");
					nombre = (buffer.readLine());

					String[] lista = controlClasifi.infoTema(nombre);
					System.out.println("Informacion del libro: " + NEW_LINE);
					System.out.println("nombre: " + lista[0]);
					System.out.println("color: " + lista[1]);
					System.out.println("nombre de tema padre: " + lista[2]);
					System.out.println("nivel: " + lista[3]);
					
					break;

				case 2:
					ArrayList<String[]> list = controlClasifi.getCatalogo();
	                for (int i = 0; i < list.size(); ++i) 
	                {
                        System.out.println("Tema: " + (i+1));
                        String[] v = list.get(i);
                        System.out.println("nombre: " + v[0]);
                        System.out.println("color: " + v[1]);
                        System.out.println("nombre de tema padre: " + v[2]);
                        System.out.println("nivel: " + v[3] + "\n");
					}

					break;

				case 3:
					System.out.println("Introducid un nombre de tema para modificar >> ");
					nombre = (buffer.readLine());
					tema = controlClasifi.getTema(nombre);

					if(nombre.equals("General")) 
                    {
                        System.out.println("color >> ");
                        color = buffer.readLine();
                        tema.setColor(color);
                    }
                    else 
                    {
						System.out.println("nombre nuevo >> ");
						String nombre_nuevo  = (buffer.readLine());

						System.out.println("color >> ");
	                    color = (buffer.readLine());

	                    System.out.println("nombre de tema padre >> ");
						nombre_padre = (buffer.readLine());

	                    controlClasifi.modificarTema(nombre, nombre_nuevo, color, nombre_padre);
	                }

                    System.out.println("Tema modificado." + NEW_LINE);
                    break;

				case 4:
					System.out.println("Crear un tema");

					System.out.println("Nombre >>");
					nombre  = (buffer.readLine());

					System.out.println("Color >>");
					color = (buffer.readLine());

					System.out.println("nombre de tema padre >> ");
					Tema t = new Tema();
					t.setNombre(buffer.readLine());

                    controlClasifi.anadirTema(nombre, color, t);
					System.out.println("Tema anadido" + NEW_LINE);
					break;

				case 5:
					System.out.println("Introducid un nombre para eliminar el libro >> ");
					nombre  = (buffer.readLine());
					controlClasifi.eliminarTema(nombre);
					System.out.println("Libro eliminado" + NEW_LINE);
					break;

				case 6: 
					System.out.println("Introducid un nombre de la Clasificacion");
					controlClasifi.modificarNombreClasifi(buffer.readLine());
					System.out.println("Se ha modificado el nombre de la clasificacion" + NEW_LINE);
					break;

				case 7:
					String s = controlClasifi.consultarNombreClasificacion();
					System.out.println("nombre de la biblioteca: " + s + NEW_LINE);
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
		System.out.println("-------------------------------------");
        System.out.println("| Driver de Controlador Clasificacion |");
        System.out.println("--------------------------------------");
	}

	private static void menu()
	{
		System.out.println("Opciones:");
        System.out.println("1) Consultar la info. de tema");
        System.out.println("2) Consultar la clasificacion");
        System.out.println("3) Modificar un tema"); 
        System.out.println("4) Añadir un tema");
        System.out.println("5) Eliminar un tema");       
        System.out.println("6) Modificar el nombre de clasificacion");
        System.out.println("7) Consultar el nombre de clasificacion");
        System.out.println("0) exit");
        System.out.println(">> " + NEW_LINE);
	}


}
