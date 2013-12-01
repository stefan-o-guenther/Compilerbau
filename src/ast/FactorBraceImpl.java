package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class FactorBraceImpl extends FactorAbstract implements FactorBrace {

    private Expression expression;
    
    @Override
    public void analyse() throws Exception {
        try {
            expression.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        try {
            return expression.evaluateAndGetInteger();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setExpression(Expression expression) throws NullException {
        try {
            if (expression == null) {
                throw new NullException(this.getClass().toString());
            }
            this.expression = expression;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Expression getExpression() {
        return expression;
    }
}
