package ast;

import exception.NullException;



/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementDebugImpl extends StatementAbstract implements StatementDebug {

    private Procedure parent = null;
    
    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            if (parent == null) {
                throw new NullException(this.getClass().toString());
            }
            if (debug) {
                Debugger.debug(parent, "evaluate StatementDebug");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void analyse() throws Exception {
        // nothing
    }

    @Override
    public void setParent(Procedure parent) throws Exception {
        try {
            if (parent == null) {
                throw new NullException();
            }
            this.parent = parent;
        } catch (Exception e) {
            throw e;
        }
    }
}
