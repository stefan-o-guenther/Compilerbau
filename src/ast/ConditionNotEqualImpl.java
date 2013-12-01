package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConditionNotEqualImpl extends ConditionComparisonAbstract implements ConditionNotEqual {

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        try {
            Integer resultLeft = this.evaluateExpressionLeft();
            Integer resultRight = this.evaluateExpressionRight();
            return ((resultLeft.equals(resultRight)) == false);
        } catch (Exception e) {
            throw e;
        }
    }
}
