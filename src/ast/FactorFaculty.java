package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface FactorFaculty extends Factor {
    void setFactor(Factor factor) throws NullException;
    Factor getFactor();
}
