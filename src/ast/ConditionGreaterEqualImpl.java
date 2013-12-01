package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConditionGreaterEqualImpl extends ConditionComparisonAbstract implements ConditionGreaterEqual {

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        try {
            Integer resultLeft = this.evaluateExpressionLeft();
            Integer resultRight = this.evaluateExpressionRight();
            return (resultLeft >= resultRight);
        } catch (Exception e) {
            throw e;
        }
    }
}
