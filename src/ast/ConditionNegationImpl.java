package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConditionNegationImpl extends ConditionAbstract implements ConditionNegation {

    private Condition condition;
    
    @Override
    public void analyse() throws Exception {
        try {
            condition.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        try {
            Boolean result = condition.evaluateAndGetBoolean();
            if (result) {
                return false;
            } else {
                return true;
            }
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
    public Condition getCondition() {
        return condition;
    }
}
