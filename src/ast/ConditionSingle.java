package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface ConditionSingle extends Condition {
    void setExpression(Expression expression) throws NullException;
    Expression getExpression();
}
