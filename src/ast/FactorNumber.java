package ast;

import exception.NullException;



/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface FactorNumber extends Factor {
    void setNumber(Integer number) throws NullException;
    Integer getNumber();
}
