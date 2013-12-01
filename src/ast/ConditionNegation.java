package ast;

import exception.NullException;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface ConditionNegation extends Condition {
    void setCondition(Condition condition) throws NullException;
    Condition getCondition();
}
