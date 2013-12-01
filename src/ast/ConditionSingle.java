package ast;

import exception.NullException;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface ConditionSingle extends Condition {
    void setExpression(Expression expression) throws NullException;
    Expression getExpression();
}
