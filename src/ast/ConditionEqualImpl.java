package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConditionEqualImpl extends ConditionComparisonAbstract implements ConditionEqual {

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        try {
            Integer resultLeft = this.evaluateExpressionLeft();
            Integer resultRight = this.evaluateExpressionRight();
            return ((resultLeft.equals(resultRight)) == true);
        } catch (Exception e) {
            throw e;
        }
    }
}
