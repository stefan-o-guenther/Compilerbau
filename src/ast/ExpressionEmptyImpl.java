package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ExpressionEmptyImpl extends ExpressionAbstract implements Expression {

    public ExpressionEmptyImpl() {
        this.empty = true;
    }
    
    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        return 0;
    }

    @Override
    public void analyse() throws Exception {
        // nothing
    }
}
