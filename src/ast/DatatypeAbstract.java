package ast;

import exception.NullException;


/**
 *
 * @author Stefan Günther
 *
 */
public abstract class DatatypeAbstract extends TypeAbstract implements Datatype {

    private Integer value = 0;
    
    protected void setDatatypeValue(Integer value) throws Exception {
        try {
            if (value == null) {
                throw new NullException(this.getClass().toString());
            }
            this.value = value;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public DatatypeAbstract(String name, String debugtype, Integer value) throws Exception {
        super(name, debugtype);
        this.setDatatypeValue(value);
    }
    @Override
    public final Integer getValue() {
        return value;
    }

}
