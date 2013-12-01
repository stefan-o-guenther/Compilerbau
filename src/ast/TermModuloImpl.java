package ast;

import exception.MathematicalErrorException;


public class TermModuloImpl extends TermGeneralAbstract implements TermModulo {

    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        try {
            Integer resultTerm = this.evaluatePreviousTerm();
            Integer resultFactor = this.evaluateExponentiation();
            if (resultFactor == 0) {
                throw new MathematicalErrorException(this.getClass().toString());
            }
            return resultTerm % resultFactor;
        } catch (Exception e) {
            throw e;
        }
    }
}
