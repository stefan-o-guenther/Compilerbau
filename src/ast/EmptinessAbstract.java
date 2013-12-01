package ast;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public abstract class EmptinessAbstract implements Emptiness {

    protected Boolean empty = false;
    
    @Override
    public final Boolean isEmpty() {
        return empty;
    }

}
