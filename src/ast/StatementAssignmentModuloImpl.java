package ast;

import exception.MathematicalErrorException;
import exception.NullException;

/**
 * @author Stefan G�nther
 * @version 1.0
 */
public class StatementAssignmentModuloImpl extends StatementAssignmentAbstract implements StatementAssignmentModulo {
    
    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            Integer var = this.getVariableValue();
            Integer result = this.evaluateAssignmentOperand();            
            if (result == 0) {
                throw new MathematicalErrorException(this.getClass().toString());
            }
            this.setVariableValue(var % result);
        } catch (Exception e) {
            throw e;
        }
    }
}
