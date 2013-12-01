package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class FactorEmptyImpl extends FactorAbstract implements FactorEmpty {

    @Override
    public void analyse() throws Exception {
        // nothing
    }

    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        return 0;
    }
}
