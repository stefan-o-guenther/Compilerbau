package ast;

import exception.NullException;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface ConditionComparison extends Condition {
    void setExpressionLeft(Expression expression) throws NullException;
    Expression getExpressionLeft();
    void setExpressionRight(Expression expression) throws NullException;
    Expression getExpressionRight();
}
