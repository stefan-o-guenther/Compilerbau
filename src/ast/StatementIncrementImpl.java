package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementIncrementImpl extends StatementIncDecAbstract implements StatementIncrement {

    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            this.evaluate(+1);
        } catch (Exception e) {
            throw e;
        }
    }
}
