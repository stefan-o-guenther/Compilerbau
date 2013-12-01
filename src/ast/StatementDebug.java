package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface StatementDebug extends Statement {
    void setParent(Procedure parent) throws Exception;
}
