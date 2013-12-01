package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementWriteImpl extends StatementAbstract implements StatementWrite {

    private Expression expression = ExpressionFactory.createExpressionEmpty();
    
    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            Integer result = expression.evaluateAndGetInteger();
            System.out.println("WRITE: "+result);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void analyse() throws Exception {
        try {
            expression.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setExpression(Expression expression) throws Exception {
        try {
            if (expression == null) {
                throw new NullException(this.getClass().toString());
            }
            this.expression = expression;
        } catch (Exception e) {
            throw e;
        }
    }
}
