package ast;



/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface StatementWrite extends Statement {
    void setExpression(Expression expression) throws Exception;
}
