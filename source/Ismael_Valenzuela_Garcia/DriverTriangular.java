package biblioteca_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author Isma
 */
public class DriverTriangular {
    private static void introduccion() {
        System.out.println("------------------------");
        System.out.println("| Driver de Triangular |");
        System.out.println("------------------------" + NEW_LINE);
    }

    private static void menu() {
        System.out.println("Opciones:");
        System.out.println("1) Consultar datos topologia");
        System.out.println("2) Consultar datos de una posicion");
        System.out.println("3) Dar forma!");
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
        Triangular tri = new Triangular(4);
        System.out.println("Creada topologia triangular de 4 posiciones");
        while(! exit) {
            menu();
            int opcion = Integer.parseInt(buffer.readLine());
            switch(opcion) {
                case 1:
                    System.out.println("Informacion sobre la topologia");
                    System.out.println("Altura: " + tri.getAltura());
                    System.out.println("Num posiciones: " + tri.getN());
                    break;
                case 2:
                    System.out.println("Pon un indice de posicion:");
                    Posicion pos = tri.getCjt().getPosicion(Integer.parseInt(buffer.readLine()));
                    System.out.println("Informacion sobre la posicion");
                    if(pos == null) {
                        System.out.println("posición x: null");
                        System.out.println("posición y: null");
                    }
                    else {
                        System.out.println("posición x: " + pos.getPosX());
                        System.out.println("posición y: " + pos.getPosY());
                    }
                case 3:
                    tri.darForma();
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
