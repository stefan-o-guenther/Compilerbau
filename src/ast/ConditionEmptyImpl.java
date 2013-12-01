package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConditionEmptyImpl extends ConditionAbstract implements ConditionEmpty {

    public ConditionEmptyImpl() {
        this.empty = true;
    }
    
    @Override
    public void analyse() throws Exception {
        // nothing
    }

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        return true;
    }
}
