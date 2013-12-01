package ast;


public class TermMultiplicationImpl extends TermGeneralAbstract implements TermMultiplication {

    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        try {
            Integer resultTerm = this.evaluatePreviousTerm();
            Integer resultFactor = this.evaluateExponentiation();
            return resultTerm * resultFactor;
        } catch (Exception e) {
            throw e;
        }
    }
}
