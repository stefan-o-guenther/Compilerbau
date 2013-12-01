package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public abstract class EmptinessAbstract implements Emptiness {

    protected Boolean empty = false;
    
    @Override
    public final Boolean isEmpty() {
        return empty;
    }

}
