package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConstantImpl extends DatatypeAbstract implements Constant {

    public ConstantImpl(String name, Integer value) throws Exception {
        super(name, "const", value);
    }
}
