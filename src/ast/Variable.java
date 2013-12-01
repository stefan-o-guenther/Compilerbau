package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface Variable extends Datatype {
    void setValue(Integer value) throws Exception;
    void pushValue() throws Exception;
    void popValue() throws Exception;
}
