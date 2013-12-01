package ast;



/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface StatementWrite extends Statement {
    void setExpression(Expression expression) throws Exception;
}
