package ast;

import exception.NullException;



/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConjunctionAndImpl extends ConjunctionAbstract implements ConjunctionAnd {

    private Conjunction previousConjunction = ConjunctionFactory.createConjunctionEmpty();
    private Condition condition = ConditionFactory.createConditionEmpty();
    
    @Override
    public void analyse() throws Exception {
        try {
            previousConjunction.analyse();
            condition.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        try {
            Boolean result1 = previousConjunction.evaluateAndGetBoolean();
            Boolean result2 = condition.evaluateAndGetBoolean();
            return (result1 && result2);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void setCondition(Condition condition) throws NullException {
        try {
            if (condition == null) {
                throw new NullException(this.getClass().toString());
            }
            this.condition = condition;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setPreviousConjunction(Conjunction conjunction)    throws NullException {
        try {
            if (conjunction == null) {
                throw new NullException(this.getClass().toString());
            }
            previousConjunction = conjunction;
        } catch (Exception e) {
            throw e;
        }
    }
}
