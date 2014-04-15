/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    public Posicion getPosicion(Integer index) {
        return posiciones.get(index);
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
        this.posiciones.remove(index);
    }
    
    public Integer[][] generarMatrizFlujo() {
        Integer tam = this.size();
        Integer[][] matf = new Integer[tam][tam];
        for(int i = 0; i < tam; ++i) matf[i][i] = 0;
        for(int i = 0; i < tam; ++i){
            for(int j = i + 1; j < tam; ++j){
                    Posicion pos1 = this.getPosicion(i);
                    Posicion pos2 = this.getPosicion(j);
                    matf[i][j] = matf[j][i] = sqrt(pow(pos1.getX() - pos2.getX(),2) + pow(pos1.getY() - pos2.getY()),2);
            }
        }
        return matf;
    }
}   
