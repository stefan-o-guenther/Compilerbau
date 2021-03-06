package ast;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public class ConditionLessThanImpl extends ConditionComparisonAbstract implements ConditionLessThan {

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        try {
            Integer resultLeft = this.evaluateExpressionLeft();
            Integer resultRight = this.evaluateExpressionRight();
            return (resultLeft < resultRight);
        } catch (Exception e) {
            throw e;
        }
    }
}
