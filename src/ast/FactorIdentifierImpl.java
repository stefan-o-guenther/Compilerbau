package ast;

import exception.NullException;

/**
 * @author Stefan Günther
 * @version 1.0
 */
public class FactorIdentifierImpl extends FactorAbstract implements FactorIdentifier {

    private String identifier = "";
    private Procedure parent;
    private Datatype datatype;
    
    @Override
    public void analyse() throws Exception {
        try {
            datatype = TypeFinder.findDatatype(parent, identifier);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        try {
            return datatype.getValue();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setIdentifier(String identifier) throws NullException {
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
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setParent(Procedure parent) throws NullException {
        try {
            if (parent == null) {
                throw new NullException(this.getClass().toString());
            }
            this.parent = parent;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Procedure getParent() {
        return parent;
    }
}
