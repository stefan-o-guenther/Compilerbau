package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public abstract class ConditionComparisonAbstract extends ConditionAbstract implements ConditionComparison {

    private Expression expressionRight;
    private Expression expressionLeft;
    
    protected Integer evaluateExpressionLeft() throws Exception {
        try {
            return expressionLeft.evaluateAndGetInteger();
        } catch (Exception e) {
            throw e;
        }
    }
    
    protected Integer evaluateExpressionRight() throws Exception {
        try {
            return expressionRight.evaluateAndGetInteger();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public final void analyse() throws Exception {
        try {
            expressionRight.analyse();
            expressionLeft.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public final void setExpressionLeft(Expression expression) throws NullException {
        try {
            if (expression == null) {
                throw new NullException(this.getClass().toString());
            }
            expressionLeft = expression;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public final void setExpressionRight(Expression expression) throws NullException {
        try {
            if (expression == null) {
                throw new NullException(this.getClass().toString());
            }
            expressionRight = expression;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public final Expression getExpressionLeft() {
        return expressionLeft;
    }

    @Override
    public final Expression getExpressionRight() {
        return expressionRight;
    }
    
    
}
