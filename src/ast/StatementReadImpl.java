package ast;

import exception.NullException;

/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementReadImpl extends StatementAbstract implements StatementRead {

    private Variable variable;
    private String identifier;
    private Procedure parent;
    
    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            Integer value = null;
            do {
                value = Input.readInteger();
            } while (value == null);
            variable.setValue(value);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void analyse() throws Exception {
        try {
            variable = TypeFinder.findVariable(parent, identifier);
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
