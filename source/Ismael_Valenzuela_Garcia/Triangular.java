package biblioteca_1;

import java.util.ArrayList;


/**
 *
 * @author Isma
 */
public class Triangular extends Topologia{
    
    private Integer altura;
    
    //---------------------
    public Triangular(Integer n){
        if(n > 0) {
            this.altura = 0;
            Integer aux = n;
            while(aux > 0){
                this.altura++;
                aux = aux - (2*this.altura - 1);                
            }
            super.n = n;
            super.cjt = new Cjt_posicion(n);
        }
    }
    
    private Integer posPorAltura(Integer h) {
        return 2*h - 1;
    }
    
    @Override
    public void darForma() {
        Posicion act = super.cjt.getPosicion(0);
        act.setPosX(0);
        act.setPosY(0);
        Integer hact = 2;
        Integer posenh = 1;
        for(int i = 1; i < super.n; i++) {
            if(this.posPorAltura(hact)+1 == posenh) {
                hact++;
                posenh = 1;
            }
            act = super.cjt.getPosicion(i);
            act.setPosY(hact - 1);
            act.setPosX(posenh - (posPorAltura(hact)/2 + 1));
            posenh++;
        }
    }

    public Integer getAltura() {
        return this.altura;
    }
    
}
