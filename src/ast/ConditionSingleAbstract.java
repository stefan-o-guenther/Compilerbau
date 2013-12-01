package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public abstract class ConditionSingleAbstract extends ConditionAbstract implements ConditionSingle {

    protected Expression expression;

    protected Boolean evaluateExpression(Boolean isOdd) throws Exception {
        try {
            if (isOdd == null) {
                throw new NullException(this.getClass().toString());
            }
            Integer result = this.expression.evaluateAndGetInteger() % 2;
            Boolean _isOdd = (result == 1);            
            return (_isOdd == isOdd);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public final void analyse() throws Exception {
        try {
            expression.analyse();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public final void setExpression(Expression expression) throws NullException {
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
    public final Expression getExpression() {
        return expression;
    }
}
