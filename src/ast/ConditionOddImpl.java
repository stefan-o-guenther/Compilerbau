package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConditionOddImpl extends ConditionSingleAbstract implements ConditionOdd {

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        try {
            return this.evaluateExpression(true);
        } catch (Exception e) {
            throw e;
        }
    }
}
