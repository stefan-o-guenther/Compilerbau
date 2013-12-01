package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ExponentiationFactory {

    public static ExponentiationPotence createExponentiationGeneral() throws Exception {
        try {
            return new ExponentiationPotenceImpl();
        } catch (Exception e) {
            System.out.println("ExponentiationFactory"+".createExponentiationGeneral()");
            throw e;
        }
    }
    
    public static ExponentiationEmpty createExponentiationEmpty() {
        try {
            return new ExponentiationEmptyImpl();
        } catch (Exception e) {
            System.out.println("ExponentiationFactory"+".createExponentiationLast()");
            throw e;
        }
    }
    
}
