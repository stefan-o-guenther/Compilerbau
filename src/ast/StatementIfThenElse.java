package ast;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface StatementIfThenElse extends StatementDisjunction, Statement {
    void setStatementThen(Statement statement);
    void setStatementElse(Statement statement);
}
