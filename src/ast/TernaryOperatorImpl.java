package ast;

import exception.NullException;

public class TernaryOperatorImpl extends AssignmentOperandAbstract implements TernaryOperator {

    private Disjunction disjunction = DisjunctionFactory.createDisjunctionEmpty();
    private Expression expressionThen = ExpressionFactory.createExpressionEmpty();
    private Expression expressionElse = ExpressionFactory.createExpressionEmpty();
    
    @Override
    public void analyse() throws Exception {
        try {
            disjunction.analyse();
            expressionThen.analyse();
            expressionElse.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        try {
            if (this.disjunction.evaluateAndGetBoolean()) {
                return this.expressionThen.evaluateAndGetInteger();
            } else {
                return this.expressionElse.evaluateAndGetInteger();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setDisjunction(Disjunction disjunction) throws Exception {
        try {
            if (disjunction == null) {
                throw new NullException(this.getClass().toString());
            }
            this.disjunction = disjunction;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setExpressionThen(Expression expression) throws Exception {
        try {
            if (expression == null) {
                throw new NullException(this.getClass().toString());
            }
            expressionThen = expression;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setExpressionElse(Expression expression) throws Exception {
        try {
            if (expression == null) {
                throw new NullException(this.getClass().toString());
            }
            expressionElse = expression;
        } catch (Exception e) {
            throw e;
        }
    }
}
