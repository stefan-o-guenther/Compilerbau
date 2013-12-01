package ast;

import exception.MathematicalErrorException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class TermDivisionImpl extends TermGeneralAbstract implements TermDivision {

    @Override
    public Integer evaluateAndGetInteger() throws Exception {
        try {
            Integer resultTerm = this.evaluatePreviousTerm();
            Integer resultFactor = this.evaluateExponentiation();
            if (resultFactor == 0) {
                throw new MathematicalErrorException(this.getClass().toString());
            }
            return resultTerm / resultFactor;
        } catch (Exception e) {
            throw e;
        }
    }

}
