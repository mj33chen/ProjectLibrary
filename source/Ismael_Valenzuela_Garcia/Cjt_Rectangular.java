import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Isma
 */
public class Cjt_Rectangular extends Topologia{
    private Integer ancho;
    private Integer alto;
    private Integer nEstanterias;
    private Integer libroPorEstanteria;
    private double[] distXEstanterias;
    private double[] distZEstanterias;
    private ArrayList<Cjt_posicion> estanteria;
    
    public Cjt_Rectangular(Integer n, Integer estanterias, Integer dEntreEstanteria) throws IOException { 
        if(estanterias < 9){
            this.nEstanterias = estanterias;
            if(n%estanterias == 0)
            this.libroPorEstanteria = n/estanterias;
            else
            this.libroPorEstanteria = n/estanterias + 1;
            this.ancho = (int)Math.sqrt(this.libroPorEstanteria);
            this.alto = this.libroPorEstanteria/this.ancho;
            if(this.alto*this.ancho < this.libroPorEstanteria)
                this.alto++;
            super.n = n;
            super.cjt = new Cjt_posicion(n);
            this.distXEstanterias = new double[9];
            this.distZEstanterias = new double[9];
            this.distXEstanterias[0] = 0;
            this.distZEstanterias[0] = 0;
            this.distXEstanterias[1] = dEntreEstanteria + this.ancho;
            this.distZEstanterias[1] = 0;
            this.distXEstanterias[2] = 0;
            this.distZEstanterias[2] = dEntreEstanteria;
            this.distXEstanterias[3] = dEntreEstanteria+this.ancho;
            this.distZEstanterias[3] = dEntreEstanteria;
            this.distXEstanterias[4] = 2*(dEntreEstanteria + this.ancho);
            this.distZEstanterias[4] = 0;
            this.distXEstanterias[5] = 0;
            this.distZEstanterias[5] = 2*dEntreEstanteria;
            this.distXEstanterias[6] = 2*(dEntreEstanteria + this.ancho);
            this.distXEstanterias[6] = dEntreEstanteria;
            this.distXEstanterias[7] = dEntreEstanteria+this.ancho;
            this.distZEstanterias[7] = 2*dEntreEstanteria;
            this.distXEstanterias[8] = 2*(dEntreEstanteria + this.ancho);
            this.distZEstanterias[8] = 2*dEntreEstanteria;
            this.estanteria = new ArrayList<Cjt_posicion>();
            for(int i = 0; i < estanterias; i++) {
                this.estanteria.add(new Cjt_posicion());
            }
        }
        else throw new IOException("Mas9Estanterias");
    }
    
    public Integer getAltura() {
        return this.alto;
    }
    
    public Integer getBase() {
        return this.ancho;
    }
    
    public Integer getNEstanterias() {
        return this.nEstanterias;
    }
    
    public Integer getLibroPorEstanteria() {
        return this.libroPorEstanteria;
    }

    public Cjt_posicion getEstanteria(Integer index) {
        return estanteria.get(index);
    }
    
    
    
    @Override
    public void darForma() {
        Integer elemento = 0;
        Integer elemenest;
        for(int i = 0; i < this.nEstanterias; i++){
            elemenest = 0;
            for(int j = 0; j < this.alto; j++){
                for(int k = 0; k < this.ancho; k++){
                    if(elemento <  this.n) {
                        if(elemenest < this.libroPorEstanteria) {
                            Posicion act = super.cjt.getPosicion(elemento);
                            act.setPosX(this.distXEstanterias[i] + k);
                            act.setPosY(j);
                            act.setPosZ(this.distZEstanterias[i]);
                            this.estanteria.get(i).anadirPosicion(act);
                            elemento++;
                            elemenest++;
                        }
                        else{
                            j = this.alto;
                            k = this.ancho;
                        }
                    }
                    else
                        break;
                }  
            }
        }
    }
    
}
