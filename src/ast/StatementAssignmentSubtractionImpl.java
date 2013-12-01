package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementAssignmentSubtractionImpl extends StatementAssignmentAbstract implements StatementAssignmentSubtraction {

    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            Integer var = this.getVariableValue();
            Integer result = this.evaluateAssignmentOperand();
            this.setVariableValue(var - result);
        } catch (Exception e) {
            throw e;
        }
    }
}
