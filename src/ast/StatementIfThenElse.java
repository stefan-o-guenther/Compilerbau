package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface StatementIfThenElse extends StatementDisjunction, Statement {
    void setStatementThen(Statement statement);
    void setStatementElse(Statement statement);
}
