package biblioteca_1;

import java.util.ArrayList;
import java.lang.Math;

/**
 *
 * @author Isma
 */
public class Cjt_posicion {
    
    private ArrayList<Posicion> posiciones;
    
    //-------------------------------------
    //-------------------------------------
    
    public Cjt_posicion() {
        this.posiciones = new ArrayList<Posicion>();
    }
    
    public Cjt_posicion(Integer n) {
        this.posiciones = new ArrayList<Posicion>();
        for(int i = 0; i < n; i++)
            this.posiciones.add(new Posicion(0,0));
    }
    
    public Posicion getPosicion(Integer index) {
        return this.posiciones.get(index);
    }
    
    public Integer size() {
        return this.posiciones.size();
    }
            
    //NO decidido
    public void anadirPosicion(Integer index, Posicion locat) {
        this.posiciones.add(index, locat);
    }
    
    //No decidido
    public void eliminarPosicion(Integer index) {
        this.posiciones.remove((int)index);
    }
    
    public double[][] generarMatrizDistancias() {
        Integer tam = this.size();
        double[][] matf = new double[tam][tam];
        for(int i = 0; i < tam; ++i) matf[i][i] = 0;
        for(int i = 0; i < tam; ++i){
            for(int j = i + 1; j < tam; ++j){
                    Posicion pos1 = this.getPosicion(i);
                    Posicion pos2 = this.getPosicion(j);
                    double x2,y2,sq;
                    x2 = Math.pow(pos1.getPosX() - pos2.getPosX(),2);
                    y2 = Math.pow(pos1.getPosY() - pos2.getPosY(),2);
                    sq = Math.sqrt(x2 + y2);
                    matf[j][i] = sq;
                    matf[i][j] = matf[j][i];
            }
        }
        return matf;
    }
}   
