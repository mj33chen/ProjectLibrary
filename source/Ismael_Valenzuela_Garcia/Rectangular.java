package biblioteca_1;

import java.lang.Math;

/**
 *
 * @author Isma
 */
public class Rectangular extends Topologia{
    private Integer ancho;
    private Integer alto;
    
    public Rectangular(Integer n) {
        if(n > 0) {
            this.ancho = (int)Math.sqrt(n);
            this.alto = n/this.ancho;
            if(this.alto*this.ancho < n)
                this.alto++;
            super.n = n;
            super.cjt = new Cjt_posicion(n);
        }
    }
    
    @Override
    public void darForma() {
        Integer elemento = 0;
        for(int i = 0; i < this.alto; i++)
            for(int j = 0; j < this.ancho; j++) {
                if(elemento <  n) {
                    Posicion act = super.cjt.getPosicion(elemento);
                    act.setPosX(j);
                    act.setPosY(i);
                    elemento++;
                }
                else
                    break;
            }    
    }
    
    public Integer getAltura() {
        return this.alto;
    }
    
    public Integer getBase() {
        return this.ancho;
    }
}
