package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ExponentiationEmptyImpl extends ExponentiationAbstract implements ExponentiationEmpty {

    public ExponentiationEmptyImpl() {
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
