package ast;

import exception.NullException;



/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface FactorIdentifier extends Factor {
    void setIdentifier(String identifier) throws NullException;
    String getIdentifier();
    void setParent(Procedure parent) throws NullException;
    Procedure getParent();
}
