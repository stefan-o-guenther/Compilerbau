package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConditionEvenImpl extends ConditionSingleAbstract implements ConditionEven {

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        try {
            return this.evaluateExpression(false);
        } catch (Exception e) {
            throw e;
        }
    }
}
