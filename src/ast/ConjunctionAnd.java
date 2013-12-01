package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface ConjunctionAnd extends Conjunction {
    void setCondition(Condition condition) throws NullException;
    void setPreviousConjunction(Conjunction conjunction) throws NullException;
}
