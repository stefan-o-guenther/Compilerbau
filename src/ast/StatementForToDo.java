package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface StatementForToDo extends StatementIdentifier, StatementStatement {
    void setExpressionFrom(Expression expression) throws NullException;
    void setExpressionTo(Expression expression) throws NullException;
}
