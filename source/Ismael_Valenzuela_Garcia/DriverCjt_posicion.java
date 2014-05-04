package biblioteca_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author Isma
 */
public class DriverCjt_posicion {
    private static void introduccion() {
        System.out.println("-------------------------");
        System.out.println("| Driver de Cjt_posicon |");
        System.out.println("-------------------------" + NEW_LINE);
    }

    private static void menu() {
        System.out.println("Opciones:");
        System.out.println("1) Crear cjt sin parametros");
        System.out.println("2) Crear cjt con numero de posiciones");
        System.out.println("3) Consultar numero posiciones");
        System.out.println("4) Consultar datos de una posicion");
        System.out.println("5) Anadir posiciones");
        System.out.println("6) Quitar una posicion ");
        System.out.println("7) Generar matriz de distancias");
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
        Cjt_posicion cjt = null;
        while(! exit) {
            menu();
            int opcion = Integer.parseInt(buffer.readLine());
            switch(opcion) {
                case 1:
                    System.out.println("Creamos una nuevo cjt" + NEW_LINE);
                    cjt = new Cjt_posicion();
                    break;
                case 2:
                    System.out.println("Creamos una nuevo cjt" + NEW_LINE);
                    Integer n = 3;
                    cjt = new Cjt_posicion(n);
                    break;
                case 3:
                    System.out.println("Informacion sobre el cjt");
                    System.out.println("Num posiciones: " + cjt.size());
                    break;
                case 4:
                    System.out.println("Pon un indice de posicion:");
                    Posicion pos = cjt.getPosicion(Integer.parseInt(buffer.readLine()));
                    System.out.println("Informacion sobre la posicion");
                    if(pos == null) {
                        System.out.println("posición x: null");
                        System.out.println("posición y: null");
                    }
                    else {
                        System.out.println("posición x: " + pos.getPosX());
                        System.out.println("posición y: " + pos.getPosY());
                    }
                    break;
                case 5:
                    Posicion posi = new Posicion(0,0);
                    cjt.anadirPosicion(0, posi);
                    posi = new Posicion(0,1);
                    cjt.anadirPosicion(1, posi);
                    posi = new Posicion(1,0);
                    cjt.anadirPosicion(2, posi);
                    posi = new Posicion(1,1);
                    cjt.anadirPosicion(3, posi); 
                    System.out.println("Anadidas posiciones (0,0) (0,1) (1,0) y (1,1)");
                    break;
                case 6:
                    cjt.eliminarPosicion(1);
                    break;
                case 7:
                    double[][] mat = cjt.generarMatrizDistancias();
                    for(int i = 0; i < 4; i++)
                        for(int j = 0; j < 4; j++)
                            System.out.println(mat[i][j]);
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
