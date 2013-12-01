package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ConditionFactory {
    
    public static Condition createConditionEmpty() {
        try {
            return new ConditionEmptyImpl();
        } catch (Exception e) {
            System.out.println("ConditionFactory"+".createConditionEmpty()");
            throw e;
        }
    }
    
    public static ConditionBracket createConditionBracket() {
        try {
            return new ConditionBracketImpl();
        } catch (Exception e) {
            System.out.println("ConditionFactory"+".createConditionBracket()");
            throw e;
        }
    }
    
    public static ConditionEqual createConditionEqual() {
        try {
            return new ConditionEqualImpl();
        } catch (Exception e) {
            System.out.println("ConditionFactory"+".createConditionEqual()");
            throw e;
        }
    }
    
    public static ConditionSingle createConditionEven() {
        try {
            return new ConditionEvenImpl();
        } catch (Exception e) {
            System.out.println("ConditionFactory"+".createConditionEven()");
            throw e;
        }
    }
    
    public static ConditionComparison createConditionGreaterEqual() {
        try {
            return new ConditionGreaterEqualImpl();
        } catch (Exception e) {
            System.out.println("ConditionFactory"+".createConditionGreaterEqual()");
            throw e;
        }
    }
    
    public static ConditionComparison createConditionGreaterThan() {
        try {
            return new ConditionGreaterThanImpl();
        } catch (Exception e) {
            System.out.println("ConditionFactory"+".createConditionGreaterThan()");
            throw e;
        }
    }
    
    public static ConditionComparison createConditionLessEqual() {
        try {
            return new ConditionLessEqualImpl();
        } catch (Exception e) {
            System.out.println("ConditionFactory"+".createConditionLessEqual()");
            throw e;
        }
    }
    
    public static ConditionComparison createConditionLessThan() {
        try {
            return new ConditionLessThanImpl();
        } catch (Exception e) {
            System.out.println("ConditionFactory"+".createConditionLessThan()");
            throw e;
        }
    }
    
    public static ConditionNegation createConditionNegation() {
        try {
            return new ConditionNegationImpl();
        } catch (Exception e) {
            System.out.println("ConditionFactory"+".createConditionNegation()");
            throw e;
        }
    }
    
    public static ConditionComparison createConditionNotEqual() {
        try {
            return new ConditionNotEqualImpl();
        } catch (Exception e) {
            System.out.println("ConditionFactory"+".createConditionNotEqual()");
            throw e;
        }
    }
    
    public static ConditionSingle createConditionOdd() {
        try {
            return new ConditionOddImpl();
        } catch (Exception e) {
            System.out.println("ConditionFactory"+".createConditionOdd()");
            throw e;
        }
    }}
