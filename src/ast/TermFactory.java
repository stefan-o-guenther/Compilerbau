package ast;



public class TermFactory {

    public static TermGeneral createTermMultiplication() throws Exception {
        try {
            return new TermMultiplicationImpl();
        } catch (Exception e) {
            System.out.println("TermFactory"+".");
            throw e;
        }
    }
    
    public static TermGeneral createTermDivision() throws Exception {
        try {
            return new TermDivisionImpl();
        } catch (Exception e) {
            System.out.println("TermFactory"+".createTermMultiplication(Term previousTerm)");
            throw e;
        }
    }
    
    public static TermGeneral createTermModulo() throws Exception {
        try {
            return new TermModuloImpl();
        } catch (Exception e) {
            System.out.println("TermFactory"+".createTermModulo(Term previousTerm)");
            throw e;
        }
    }
    
    public static Term createTermEmpty() {
        try {
            return new TermEmptyImpl();
        } catch (Exception e) {
            System.out.println("TermFactory"+".createEmptyFirst()");
            throw e;
        }
        
    }
}
