package ast;

import exception.NullException;

/**
 * @author Stefan Günther
 * @version 1.0
 */
public class FactorNumberImpl extends FactorAbstract implements FactorNumber {

    private Integer number = 0;
        
    @Override
    public void analyse() throws Exception {
        try {
            if (number == null) {
                throw new NullException(this.getClass().toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        try {
            return number;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setNumber(Integer number) throws NullException {
        try {
            if (number == null) {
                throw new NullException(this.getClass().toString());
            }
            this.number = number;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer getNumber() {
        return number;
    }
}
