package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class TermEmptyImpl extends TermAbstract implements TermEmpty {

    public TermEmptyImpl() {
        this.empty = true;
    }
    
    @Override
    public void analyse() throws Exception {
        // nothing
    }

    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        return 1;
    }
}
