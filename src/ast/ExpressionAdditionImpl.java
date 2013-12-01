package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ExpressionAdditionImpl extends ExpressionGeneralAbstract implements ExpressionAddition {
        
    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        try {
            return this.evaluate(+1);
        } catch (Exception e) {
            throw e;
        }
    }
}
