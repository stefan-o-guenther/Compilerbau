package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementCallImpl extends StatementAbstract implements StatementCall {
    
    Procedure parent;
    Procedure procedure;
    String identifier;
    
    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            procedure.evaluateOnlyAndDebug(debug);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void analyse() throws Exception {
        try {
            procedure = TypeFinder.findProcedure(parent, identifier);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setIdentifier(String identifier) throws Exception {
        try {
            if (identifier == null) {
                throw new NullException(this.getClass().toString());
            }
            this.identifier = identifier;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setParent(Procedure parent) throws Exception {
        try {
            if (parent == null) {
                throw new NullException(this.getClass().toString());
            }
            this.parent = parent;
        } catch (Exception e) {
            throw e;
        }
    }
}
