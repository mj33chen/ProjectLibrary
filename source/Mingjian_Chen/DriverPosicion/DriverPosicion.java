import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
        Libro libro = new Libro();

		boolean exit = false;
		while(! exit)
		{
			menu();

			int opcion = Integer.parseInt(buffer.readLine());
			switch(opcion)
			{
				case 1:
					System.out.println("Informacion sobre la posición");
					System.out.println("posición x: " + p.getPosX());
                    System.out.println("posición y: " + p.getPosY());

                    if(p.esEmpty()) 
                    {
                    	System.out.println("Posición vacía" + NEW_LINE);
                    }
                    else 
                    {
                    	Libro l = p.getLibro();
                    	System.out.println("Información de libro: " + NEW_LINE);
				        System.out.println("titulo: " + l.getTitulo());
				        System.out.println("autor: " + l.getAutor());
				        System.out.println("identificador: " + l.getId());
				        System.out.println("temas: ");
				        int num = l.getNumTemas();
				        System.out.println("numero de temas: " + num);
				        ArrayList<Tema> temas = new ArrayList<Tema>();
				        temas = l.getVector();
				        for(int i = 0; i < num; ++i)
				        {
				        	Tema t = temas.get(i);
				        	System.out.println(t.getNombre() + " ");
				        }
                    }

					break;

				case 2: 
					System.out.println("Pon un valor a la posición x:");
                    p.setPosX(Integer.parseInt(buffer.readLine()));
                    System.out.println("Parametro x se ha modificado:" + NEW_LINE);

                    System.out.println("Pon un valor a la posició de y");
                    p.setPosY(Integer.parseInt(buffer.readLine()));
                    System.out.println("Parametro y se ha modificado:" + NEW_LINE);

                    break;

				case 3:
					System.out.println("selecciona una varible para modificar su valor" + NEW_LINE);
					System.out.println("con la opcion 1 si desea la variable x" + NEW_LINE);
					System.out.println("con la opcion 2 si desea la variable y" + NEW_LINE);
                    System.out.println("con la opcion 0 si desea salir" + NEW_LINE);
                    int op = Integer.parseInt(buffer.readLine());
                    switch (op) 
                    {
                        case 1:
                        	System.out.println("Pon un valor a la posición x:");
                            p.setPosX(Integer.parseInt(buffer.readLine()));
                            System.out.println("Parametro x se ha modificado:" + NEW_LINE);
                            break;
                        case 2:
                        	System.out.println("Pon un valor a la posició de y");
                            p.setPosY(Integer.parseInt(buffer.readLine()));
                            System.out.println("Parametro y se ha modificado:" + NEW_LINE);
                            break;
                        default:
                            break;
                    }
                    break;

                case 4:

                    if(p.esEmpty()) 
                    {
                
                    	System.out.println("Introduzca los datos del libro");

                    	System.out.println("Identificador >>");
                        libro.setId(Integer.parseInt(buffer.readLine()));

                        System.out.println("Titulo >>");
                        libro.setTitulo(buffer.readLine());

                        System.out.println("Autor >>");
                        libro.setAutor(buffer.readLine());

                    	System.out.println("Numero de temas: ");
                    	int num = Integer.parseInt(buffer.readLine());

                    	Tema t;
                    	System.out.println("Introduzca nombre de tema: ");

                    	String line = null;
                    	int i = 0;
                        while((line=buffer.readLine()) != null && (i < num))
                        {
                        	t = new Tema();
                        	t.setNombre(line);
    			        	libro.anadirTema(t);
    			        	++i;
    			        	if(i == num) System.out.println("Pon un culaquier caracter para salir: ");
    			        }
       

                    	p.colocarLibro(libro);
                        System.out.println("Libro colocado" + NEW_LINE);
                    }
                    else 
                    {
                        System.out.println("Posición ocupada" + NEW_LINE);
                    }

                	break;

                case 5:
                    if(! p.esEmpty()) 
                    {
                        p.quitarLibro();
                        System.out.println("Libro quitado" + NEW_LINE);
                    }
                    else 
                    {
                        System.out.println("Posicion vacia, no hay libro para quitar" + NEW_LINE);
                    }
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
		System.out.println("-----------------------");
        	System.out.println("| Driver de Posicion |");
        	System.out.println("-----------------------" + NEW_LINE);
	}

	private static void menu()
	{
		System.out.println("Opciones:");
        System.out.println("1) Consultar la informacion de posicion");
        System.out.println("2) Modificar los parametros de posicion");
        System.out.println("3) Modificar un parametro de posicion");
        System.out.println("4) Colocar un libro a una posicion");
        System.out.println("5) Quitar un libro de una posicion");
        System.out.println("0) exit");
        System.out.println(">> " + NEW_LINE);
	}
}
