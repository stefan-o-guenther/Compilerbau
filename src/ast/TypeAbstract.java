package ast;

import exception.NullException;

public abstract class TypeAbstract extends EmptinessAbstract implements Type {

    private String identifier = "";
    private String debugtype = "type";
    
    public TypeAbstract(String identifier, String debugtype) throws Exception {
        try {
            if ((identifier == null) || (debugtype == null)) {
                throw new NullException(this.getClass().toString());
            }
            this.identifier = identifier;
            this.debugtype = debugtype;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public final String getIdentifier() {
        try {
            return identifier;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public final String getDebugType() {
        try {
            return debugtype;
        } catch (Exception e) {
            throw e;
        }
    }
}
