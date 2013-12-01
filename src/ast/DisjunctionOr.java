package ast;

import exception.NullException;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface DisjunctionOr extends Disjunction {
    void setConjunction(Conjunction conjunction) throws NullException;
    void setPreviousDisjunction(Disjunction disjunction) throws NullException;
}
