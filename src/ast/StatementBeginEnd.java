package ast;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface StatementBeginEnd extends Statement {
    void addStatement(Statement statement);
}
