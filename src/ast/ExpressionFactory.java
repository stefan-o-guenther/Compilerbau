package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ExpressionFactory {

    public static ExpressionGeneral createExpressionAddition() throws Exception {
        try {
            return new ExpressionAdditionImpl();
        } catch (Exception e) {
            System.out.println("ExpressionFactory"+".createExpressionAddition(Expression previousExpression)");
            throw e;
        }
    }
    
    public static ExpressionGeneral createExpressionSubtraction() throws Exception {
        try {
            return new ExpressionSubtractionImpl();
        } catch (Exception e) {
            System.out.println("ExpressionFactory"+".createExpressionSubtraction(Expression previousExpression)");
            throw e;
        }
    }
    
    public static Expression createExpressionEmpty() {
        try {
            return new ExpressionEmptyImpl();
        } catch (Exception e) {
            System.out.println("ExpressionFactory"+".createExpressionEmpty()");
            throw e;
        }
    }
}
