package ast;




/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface StatementDisjunction extends Statement {
    void setDisjunction(Disjunction disjunction) throws Exception;
}
