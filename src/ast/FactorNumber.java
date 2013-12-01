package ast;

import exception.NullException;



/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface FactorNumber extends Factor {
    void setNumber(Integer number) throws NullException;
    Integer getNumber();
}
