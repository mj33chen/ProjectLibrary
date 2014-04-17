import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Mingjian Chen 
 */

public class DriverPosicion
{
	// el separator para todo los sistemas operativos
	private static final String NEW_LINE = System.getProperty("line.separator");

	public static void main(String args[]) throws IOException
	{
		introduccion();

		InputStreamReader iostream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader (iostream);

        System.out.println("Creamos una nueva posicion" + NEW_LINE);
        Posicion p = new Posicion();

		boolean exit = false;
		while(not exit)
		{
			menu();

			int opcion = Integer.parseInt(buffer.readLine());
			switch(opcion)
			{
				case 0:
					System.out.println("Informacion sobre la posición" + NEW_LINE);
					System.out.println("Introduzca la variable x y la variable y" + NEW_LINE);
					System.out.println(">> " + NEW_LINE);
					int x = (buffer.readLine());
                	System.out.println("x leido" + NEW_LINE);
                	System.out.println(">> " + NEW_LINE);
                	int y = (buffer.readLine());
                	System.out.println("y leido" + NEW_LINE);

					if(p.esEmpty(x, y))
					{
						System.out.println("La posición es vacia" + NEW_LINE);
					}
					else 
					{
						Libro libro = getLibro(x, y);
						libro.mostrarLibro();  // lo que faltaba la clase Libro
					}
					break;

				case 1: 
					System.out.println("posición x:" + NEW_LINE);
                    p.setPosX(Integer.parseInt(buffer.readLine()));

                    System.out.println("posició de y" + NEW_LINE);
                    p.setPosY(Integer.parseInt(buffer.readLine()));

                    break;

				case 2:
					System.out.println("selecciona una varible para modificar su valor" + NEW_LINE);
					System.out.println("con la opcion 1 si desea la variable x" + NEW_LINE);
					System.out.println("con la opcion 2 si desea la variable y" + NEW_LINE);
                    System.out.println("con la opcion 0 si desea salir" + NEW_LINE);
                    int op = Integer.parseInt(buffer.readLine());
                    switch (op) 
                    {
                        case 1:
                            p.setPosX(Integer.parseInt(buffer.readLine()));
                            break;
                        case 2:
                            p.setPosY(Integer.parseInt(buffer.readLine()));
                            break;
                        default:
                            break;
                    }
                    break;

                case 3:
                	System.out.println("Introduzca los datos del libro" + NEW_LINE);

                	System.out.println("Titulo:" + NEW_LINE);
                	String titulo = (buffer.readLine());

                	System.out.println("Autor:" + NEW_LINE);
                	String autor = (buffer.readLine());

                	System.out.println("Identificador:" + NEW_LINE);
                	int id = (buffer.readLine());

                	System.out.println("Temas asignados:" + NEW_LINE);
                	ArrayList<String> temas = new ArrayList<String>;
                	Scanner sc = new Scanner(System.in);
			        while(sc.hasNext())
			        {
			        	String s = sc.next();
			        	temas.add(s);
			        }
                	Libro l = new Libro(titulo, autor, id, temas);

                	System.out.println("Introduzca la variable x y la variable y" + NEW_LINE);
                	System.out.println("x leido" + NEW_LINE);
                	int x = (buffer.readLine());
                	System.out.println("y leido" + NEW_LINE);
                	int y = (buffer.readLine());
                	p.colocarLibro(x, y, l);
                	break;

				case 4:
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
        System.out.println("| Driver de Posicion |" + NEW_LINE);
        System.out.println("------------------------" + NEW_LINE);
	}

	private static void menu()
	{
		System.out.println("Opciones:" + NEW_LINE);
        System.out.println("0) Consultar la informacion de posicion" + NEW_LINE);
        System.out.println("1) Modificar los parametros de posicion" + NEW_LINE);
        System.out.println("2) Modificar un parametro de posicion" + NEW_LINE);
        System.out.println("3) Colocar un libro a una posicion" + NEW_LINE);
        System.out.println("4) exit" + NEW_LINE);
        System.out.println(">> ");
	}
}
