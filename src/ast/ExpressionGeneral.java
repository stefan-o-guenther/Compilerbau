package ast;

import exception.NullException;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface ExpressionGeneral extends Expression {
    void setTerm(Term term) throws NullException;
    Term getTerm();
    void setPreviousExpression(Expression expression) throws NullException;
    Expression getPreviousExpression();
}
