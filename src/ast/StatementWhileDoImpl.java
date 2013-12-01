package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementWhileDoImpl extends StatementConditionLoopAbstract implements StatementWhileDo {

    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            while (this.getDisjunctionResult()) {
                this.evaluateStatement(debug);
            }
        } catch (Exception e) {
            throw e;
        }        
    }    
}
