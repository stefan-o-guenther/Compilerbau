package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface StatementBeginEnd extends Statement {
    void addStatement(Statement statement);
}
