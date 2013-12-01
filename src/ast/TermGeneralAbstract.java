package ast;

import exception.NullException;

public abstract class TermGeneralAbstract extends TermAbstract implements TermGeneral {
    
    private Exponentiation exponentiation = ExponentiationFactory.createExponentiationEmpty();
    private Term previousTerm = TermFactory.createTermEmpty();
    
    protected Integer evaluateExponentiation() throws Exception {
        try {
            return exponentiation.evaluateAndGetInteger();
        } catch (Exception e) {
            throw e;
        }
    }
    
    protected Integer evaluatePreviousTerm() throws Exception {
        try {
            return previousTerm.evaluateAndGetInteger();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public final void setExponentiation(Exponentiation exponentiation) throws NullException {
        try {
            if (exponentiation == null) {
                throw new NullException(this.getClass().toString());
            }
            this.exponentiation = exponentiation;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public final Exponentiation getExponentiation() {
        try {
            return exponentiation;
        } catch (Exception e) {
            throw e;
        }        
    }

    @Override
    public final void setPreviousTerm(Term term) throws NullException {
        try {
            if (term == null) {
                throw new NullException(this.getClass().toString());
            }
            previousTerm = term;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public final Term getPreviousTerm() {
        try {
            return previousTerm;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    @Override
    public final void analyse() throws Exception {
        try {
            previousTerm.analyse();
            exponentiation.analyse();
        } catch (Exception e) {
            throw e;
        }
    }
}
