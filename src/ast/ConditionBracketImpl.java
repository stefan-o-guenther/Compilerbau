package ast;

import exception.NullException;

/**
 * 
 * @author Stefan Günther
 *
 */
public class ConditionBracketImpl extends ConditionAbstract implements ConditionBracket {

    Disjunction disjunction;

    @Override
    public void analyse() throws Exception {
        try {
            disjunction.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        try {
            return disjunction.evaluateAndGetBoolean();
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
    public Disjunction getDisjunction() {
        return disjunction;
    }
}
