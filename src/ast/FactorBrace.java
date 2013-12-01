package ast;

import exception.NullException;




/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface FactorBrace extends Factor {
    void setExpression(Expression expression) throws NullException;
    Expression getExpression();
}
