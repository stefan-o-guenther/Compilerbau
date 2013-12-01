package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class DisjunctionFactory {

    public static Disjunction createDisjunctionEmpty() {
        try {
            return new DisjunctionEmptyImpl();
        } catch (Exception e) {
            System.out.println("DisjunctionFactory"+".createDisjunctionFirst()");
            throw e;
        }
    }
    
    public static DisjunctionOr createDisjunctionOr() throws Exception {
        try {
            return new DisjunctionOrImpl();
        } catch (Exception e) {
            System.out.println("DisjunctionFactory"+".createDisjunctionOr(Disjunction previousDisjunction)");
            throw e;
        }
    }
}
