package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementRepeatUntilImpl extends StatementConditionLoopAbstract implements StatementRepeatUntil {

    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            do {
                this.evaluateStatement(debug);
            } while ((this.getDisjunctionResult()) == false);
        } catch (Exception e) {
            throw e;
        }
    }
}
