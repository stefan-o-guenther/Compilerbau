package ast;




/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface Type extends Emptiness {
    String getIdentifier();
    String getDebugType();
}
