package biblioteca_1;


/**
 *
 * @author Isma
 */
public abstract class Topologia {
    
    protected Integer n;
    
    protected Cjt_posicion cjt;
    
    public abstract void darForma();

    public Integer getN() {
        return this.n;
    }

    public Cjt_posicion getCjt() {
        return this.cjt;
    }
    
}
