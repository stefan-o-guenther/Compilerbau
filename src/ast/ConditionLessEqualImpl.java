package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConditionLessEqualImpl extends ConditionComparisonAbstract implements ConditionLessEqual {

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        try {
            Integer resultLeft = this.evaluateExpressionLeft();
            Integer resultRight = this.evaluateExpressionRight();
            return (resultLeft <= resultRight);
        } catch (Exception e) {
            throw e;
        }
    }
}
