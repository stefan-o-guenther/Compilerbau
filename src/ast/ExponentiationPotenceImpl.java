package ast;

import exception.MathematicalErrorException;
import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ExponentiationPotenceImpl extends ExponentiationAbstract implements ExponentiationPotence {

    private Exponentiation nextExponentiation = ExponentiationFactory.createExponentiationEmpty();
    private Factor factor = FactorFactory.createFactorEmpty();
    
    @Override
    public void analyse() throws Exception {
        try {
            factor.analyse();
            nextExponentiation.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        try {
            Integer resultExponentiation = nextExponentiation.evaluateAndGetInteger();
            if (resultExponentiation < 0) {
                throw new MathematicalErrorException(this.getClass().toString());
            }
            Integer resultFactor = factor.evaluateAndGetInteger();
            Integer result = 1;
            while (resultExponentiation > 0) {
                result *= resultFactor;
                resultExponentiation -= 1;
            }
            return result;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void setNextExponentiation(Exponentiation exponentiation) throws NullException {
        try {
            if (nextExponentiation == null) {
                throw new NullException(this.getClass().toString());
            }
            nextExponentiation = exponentiation;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Exponentiation getNextExponentiation() {
        return nextExponentiation;
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
