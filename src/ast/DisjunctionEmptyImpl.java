package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class DisjunctionEmptyImpl extends DisjunctionAbstract implements DisjunctionEmpty {
    
    public DisjunctionEmptyImpl() {
        this.empty = true;
    }
    
    @Override
    public void analyse() throws Exception {
        // nothing
    }

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        return false;
    }
}
