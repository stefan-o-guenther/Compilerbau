package ast;

import exception.NullException;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface FactorFaculty extends Factor {
    void setFactor(Factor factor) throws NullException;
    Factor getFactor();
}
