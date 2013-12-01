package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public abstract class ExpressionGeneralAbstract extends ExpressionAbstract implements ExpressionGeneral {

    private Expression previousExpression = ExpressionFactory.createExpressionEmpty();
    private Term term = TermFactory.createTermEmpty();
    
    protected Integer evaluate(Integer value) throws Exception {
        try {
            if (value == null) {
                throw new NullException(this.getClass().toString());
            }
            Integer resultExpression = previousExpression.evaluateAndGetInteger();
            Integer resultTerm = term.evaluateAndGetInteger();
            Integer result = resultExpression + (value * resultTerm);
            return result;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public final void setTerm(Term term) throws NullException {
        try {
            if (term == null) {
                throw new NullException(this.getClass().toString());
            }
            this.term = term;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public final Term getTerm() {
        try {
            return term;
        } catch (Exception e) {
            throw e;
        }        
    }

    @Override
    public final void setPreviousExpression(Expression expression) throws NullException {
        try {
            if (expression == null) {
                throw new NullException(this.getClass().toString());
            }
            previousExpression = expression;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public final Expression getPreviousExpression() {
        return previousExpression;
    }
    
    @Override
    public final void analyse() throws Exception {
        try {
            previousExpression.analyse();
            term.analyse();
        } catch (Exception e) {
            throw e;
        }
    }
}
