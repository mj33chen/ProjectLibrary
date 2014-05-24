import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author Isma
 */
public class DriverCjt_Rectangular {
    private static void introduccion() {
        System.out.println("-----------------------------");
        System.out.println("| Driver de Cjt_Rectangular |");
        System.out.println("-----------------------------" + NEW_LINE);
    }

    private static void menu() {
        System.out.println("Opciones:");
        System.out.println("1) Consultar datos topologia");
        System.out.println("2) Consultar datos de una estanteria");
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
        Cjt_Rectangular rec = new Cjt_Rectangular(4,2,50);
        System.out.println("Creada topologia de 2 esterias con 4 posiciones(2 por estanteria) y una distancia entre estanterias de 50");
        while(! exit) {
            menu();
            int opcion = Integer.parseInt(buffer.readLine());
            switch(opcion) {
                case 1:
                    System.out.println("Informacion sobre la topologia");
                    System.out.println("Altura: " + rec.getAltura());
                    System.out.println("Anchura: " + rec.getBase());
                    System.out.println("Num posiciones: " + rec.getN());
                    System.out.println("Lib cada estanteria: " + rec.getLibroPorEstanteria());
                    System.out.println("Num estanterias: " + rec.getNEstanterias());
                    break;
                case 2:
                    System.out.println("Pon un indice de estanteria:");
                    int est = Integer.parseInt(buffer.readLine());
                    Posicion pos = rec.getEstanteria(est).getPosicion(0);
                    Posicion pos1 = rec.getEstanteria(est).getPosicion(1);
                    System.out.println("Informacion sobre la posicion 0");
                    if(pos == null) {
                        System.out.println("posición x: null");
                        System.out.println("posición y: null");
                    }
                    else {
                        System.out.println("posición x: " + pos.getPosX());
                        System.out.println("posición y: " + pos.getPosY());
                        System.out.println("posición z: " + pos.getPosZ());
                    }
                    System.out.println("Informacion sobre la posicion 1");
                    if(pos == null) {
                        System.out.println("posición x: null");
                        System.out.println("posición y: null");
                    }
                    else {
                        System.out.println("posición x: " + pos1.getPosX());
                        System.out.println("posición y: " + pos1.getPosY());
                        System.out.println("posición z: " + pos1.getPosZ());
                    }
                    break;
                case 3:
                    rec.darForma();
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
