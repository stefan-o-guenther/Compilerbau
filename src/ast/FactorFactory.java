package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class FactorFactory {

    public static Factor createFactorEmpty() {
        try {
            return new FactorEmptyImpl();
        } catch (Exception e) {
            System.out.println("FactorFactory"+".createFactorEmpty()");
            throw e;
        }
    }
    
    public static FactorBrace createFactorBrace() throws Exception {
        try {
            return new FactorBraceImpl();
        } catch (Exception e) {
            System.out.println("FactorFactory"+".createFactorBrace()");
            throw e;
        }
    }
    
    public static FactorIdentifier createFactorIdentifier() throws Exception {
        try {
            return new FactorIdentifierImpl();
        } catch (Exception e) {
            System.out.println("FactorFactory"+".createFactorIdentifier()");
            throw e;
        }
    }
    
    public static FactorNumber createFactorNumber() throws Exception {
        try {
            return new FactorNumberImpl();
        } catch (Exception e) {
            System.out.println("FactorFactory"+".createFactorNumber()");
            throw e;
        }
    }
    
    public static FactorFaculty createFactorFaculty() throws Exception {
        try {
            return new FactorFacultyImpl();
        } catch (Exception e) {
            System.out.println("FactorFactory"+".createFactorFaculty()");
            throw e;
        }
    }
}
