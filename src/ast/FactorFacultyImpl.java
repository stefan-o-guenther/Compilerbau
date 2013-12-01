package ast;

import exception.MathematicalErrorException;
import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class FactorFacultyImpl extends FactorAbstract implements FactorFaculty {

    private Factor factor;
    
    private Integer calculateFaculty(Integer value) throws Exception {
        try {
            if (value == null) {
                throw new NullException();
            }
            if (value > 0) {
                return (value * this.calculateFaculty(value-1));
            } else if (value == 0){
                return 1;
            } else {
                throw new MathematicalErrorException(this.getClass().toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void analyse() throws Exception {
        try {
            factor.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        try {
            Integer result = factor.evaluateAndGetInteger();
            if (result < 0) {
                throw new MathematicalErrorException(this.getClass().toString());
            }
            return this.calculateFaculty(result);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setFactor(Factor factor) throws NullException {
        try {
            if (factor == null) {
                throw new NullException(this.getClass().toString());
            }
            this.factor = factor;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Factor getFactor() {
        return factor;
    }
}
