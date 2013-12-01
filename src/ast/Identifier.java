package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface Identifier {
    void setIdentifier(String identifier) throws Exception;
    void setParent(Procedure parent) throws Exception;
}
