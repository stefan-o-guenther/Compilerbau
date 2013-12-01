package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConjunctionEmptyImpl extends ConjunctionAbstract implements ConjunctionEmpty {

    public ConjunctionEmptyImpl() {
        this.empty = true;
    }
    
    @Override
    public void analyse() throws Exception {
        // nothing
    }

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        return true;
    }
}
