package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface ExponentiationPotence extends Exponentiation {
    void setNextExponentiation(Exponentiation nextExponentiation) throws NullException;
    Exponentiation getNextExponentiation();
    void setFactor(Factor factor) throws NullException;
    Factor getFactor();
}
