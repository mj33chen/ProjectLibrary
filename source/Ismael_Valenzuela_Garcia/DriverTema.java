package biblioteca_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author Isma
 */
public class DriverTema {

    private static void introduccion() {
        System.out.println("------------------");
        System.out.println("| Driver de Tema |");
        System.out.println("------------------" + NEW_LINE);
    }

    private static void menu() {
        System.out.println("Opciones:");
        System.out.println("1) Crear tema sin parametros");
        System.out.println("2) Crear tema con nombre");
        System.out.println("3) Crear tema con padre, hijos y nombre");
        System.out.println("4) Consultar la informacion de tema");
        System.out.println("5) Modificar nombre de tema");
        System.out.println("6) Colocar un tema hijo ");
        System.out.println("7) Quitar un tema hijo");
        System.out.println("0) exit");
        System.out.println(">> " + NEW_LINE);
    }
// el separator para todo los sistemas operativos
    private static final String NEW_LINE = System.getProperty("line.separator");

    public static void main(String args[]) throws IOException {
        introduccion();
        InputStreamReader iostream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader (iostream);
        boolean exit = false;
        Tema t = null;
        while(! exit) {
            menu();
            int opcion = Integer.parseInt(buffer.readLine());
            switch(opcion) {
                case 1:
                    System.out.println("Creamos una nuevo tema" + NEW_LINE);
                    t = new Tema();
                    break;
                case 2:
                    System.out.println("Creamos una nuevo tema" + NEW_LINE);
                    t = new Tema("Tema1");
                    break;
                case 3:
                    System.out.println("Creamos una nuevo tema con 2 hijos" + NEW_LINE);
                    Tema padre = new Tema("Padre");
                    ArrayList<Tema> hijos = new ArrayList<Tema>();
                    hijos.add(new Tema("Hijo1"));
                    hijos.add(new Tema("Hijo2"));
                    t = new Tema(padre,"Tema1",hijos);
                    break;
                case 4:
                    System.out.println("Informacion sobre el tema");
                    if(t == null)
                        System.out.println("Nombre: null");
                    else {
                        System.out.println("Nombre: " + t.getNombre() );
                        Tema father = t.getPadre();
                        if(father == null)
                            System.out.println("Padre: null");
                        else
                            System.out.println("Padre: " + father.getNombre());
                        System.out.println("Numero hijos: " + t.getNumHijo());
                        if(t.getNumHijo() == 0)
                            System.out.println("Hijos: null");
                        else{
                            ArrayList<Tema> fills = t.getHijo();
                            for(int i = 0; i < t.getNumHijo(); i++){
                                Tema fill;
                                fill = fills.get(i);
                                System.out.println( "Hijos: " + fill.getNombre());
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Pon un nombre:");
                    t.setNombre(buffer.readLine());
                    System.out.println("Parametro nombre se ha modificado" + NEW_LINE);
                    break;
                case 6:
                    Tema fill = new Tema("nuevo");
                    t.addHijo(fill);
                    break;
                case 7:
                    ArrayList<Tema> fills = t.getHijo();
                    Tema fillo = fills.get(0);
                    t.deleteHijo(fillo);
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
