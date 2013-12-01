package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementAssignmentGeneralImpl extends StatementAssignmentAbstract implements StatementAssignmentGeneral {
    
    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            Integer result = this.evaluateAssignmentOperand();
            this.setVariableValue(result);
        } catch (Exception e) {
            throw e;
        }
    }
}
