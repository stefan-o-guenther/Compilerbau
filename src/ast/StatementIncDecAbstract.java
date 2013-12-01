package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public abstract class StatementIncDecAbstract extends StatementAbstract implements StatementIncDec {
    
    private String identifier = "";
    private Procedure parent = null;
    private Variable variable = null;
    
    protected void evaluate(Integer value) throws Exception {
        try {
            if (value == null) {
                throw new NullException(this.getClass().toString());
            }
            Integer number = variable.getValue();
            number += value;
            variable.setValue(number);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public final void analyse() throws Exception {
        try {
            variable = TypeFinder.findVariable(parent, identifier);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public final void setIdentifier(String identifier) throws Exception {
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
    public final void setParent(Procedure parent) throws Exception {
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
