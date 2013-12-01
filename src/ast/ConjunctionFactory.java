package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConjunctionFactory {

    public static Conjunction createConjunctionEmpty() {
        try
        {
            return new ConjunctionEmptyImpl();
        }
        catch (Exception e)
        {
            System.out.println("ConjunctionFactory"+".createConjunctionFirst()");
            throw e;
        }
    }

    public static ConjunctionAnd createConjunctionAnd() throws Exception {
        try
        {
            return new ConjunctionAndImpl();
        }
        catch (Exception e)
        {
            System.out.println("ConjunctionFactory"+".createConjunctionAnd(Conjunction previousConjunction)");
            throw e;
        }
    }
}
