package ast;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface Identifier {
    void setIdentifier(String identifier) throws Exception;
    void setParent(Procedure parent) throws Exception;
}
