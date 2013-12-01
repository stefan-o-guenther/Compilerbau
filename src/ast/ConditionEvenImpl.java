package ast;


/**
 * @author Stefan G�nther
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
