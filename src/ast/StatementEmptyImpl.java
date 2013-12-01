package ast;

import exception.NullException;

/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementEmptyImpl extends StatementAbstract implements StatementEmpty {

    public StatementEmptyImpl() {
        this.empty = true;
    }
    
    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            // nothing
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void analyse() throws Exception {
        // nothing
    }
}
