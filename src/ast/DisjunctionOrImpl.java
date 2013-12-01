package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class DisjunctionOrImpl extends DisjunctionAbstract implements DisjunctionOr {

    private Disjunction previousDisjunction = DisjunctionFactory.createDisjunctionEmpty();
    private Conjunction conjunction = ConjunctionFactory.createConjunctionEmpty();
        
    @Override
    public void analyse() throws Exception {
        try {
            previousDisjunction.analyse();
            conjunction.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean evaluateAndGetBoolean() throws Exception {
        try {
            Boolean result1 = previousDisjunction.evaluateAndGetBoolean();
            Boolean result2 = conjunction.evaluateAndGetBoolean();
            return (result1 || result2);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void setConjunction(Conjunction conjunction) throws NullException {
        try {
            if (conjunction == null) {
                throw new NullException(this.getClass().toString());
            }
            this.conjunction = conjunction;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setPreviousDisjunction(Disjunction disjunction)    throws NullException {
        try {
            if (disjunction == null) {
                throw new NullException(this.getClass().toString());
            }
            previousDisjunction = disjunction;
        } catch (Exception e) {
            throw e;
        }
    }
}
