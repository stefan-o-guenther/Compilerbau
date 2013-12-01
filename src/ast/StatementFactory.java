package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class StatementFactory {

    public static StatementAssignment createStatementAssignmentAddition() {
        try {
            return new StatementAssignmentAdditionImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementAssignmentAddition()");
            throw e;
        }
    }
    
    public static StatementAssignment createStatementAssignmentDivision() {
        try {
            return new StatementAssignmentDivisionImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementAssignmentDivision()");
            throw e;
        }
    }
    
    public static StatementAssignment createStatementAssignmentGeneral() {
        try {
            return new StatementAssignmentGeneralImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementAssignmentGeneral()");
            throw e;
        }
    }
    
    public static StatementAssignment createStatementAssignmentModulo() {
        try {
            return new StatementAssignmentModuloImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementAssignmentModulo()");
            throw e;
        }
    }
    
    public static StatementAssignment createStatementAssignmentMultiplication() {
        try {
            return new StatementAssignmentMultiplicationImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementAssignmentMultiplication()");
            throw e;
        }
    }
    
    public static StatementAssignment createStatementAssignmentSubtraction() {
        try {
            return new StatementAssignmentSubtractionImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementAssignmentSubtraction()");
            throw e;
        }
    }
    
    public static StatementBeginEnd createStatementBeginEnd() {
        try {
            return new StatementBeginEndImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementBeginEnd()");
            throw e;
        }
    }
    
    public static StatementCall createStatementCall() {
        try {
            return new StatementCallImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementCall()");
            throw e;
        }
    }
    
    public static StatementDebug createStatementDebug() throws Exception {
        try {
            return new StatementDebugImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementDebug()");
            throw e;
        }
    }
    
    public static StatementDecrement createStatementDectrement() {
        try {
            return new StatementDecrementImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementDectrement()");
            throw e;
        }
    }
    
    public static StatementEmpty createStatementEmpty() {
        try {
            return new StatementEmptyImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementEmpty()");
            throw e;
        }
    }
    
    public static StatementForToDo createStatementForToDo() {
        try {
            return new StatementForToDoImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementForToDo()");
            throw e;
        }
    }
    
    public static StatementIfThenElse createStatementIfThenElse() {
        try {
            return new StatementIfThenElseImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementIfThenElse()");
            throw e;
        }
    }
    
    public static StatementIncrement createStatementIncrement() {
        try {
            return new StatementIncrementImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementIncrement()");
            throw e;
        }
    }
    
    public static StatementRead createStatementRead() {
        try {
            return new StatementReadImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementRead()");
            throw e;
        }
    }
    
    public static StatementRepeatUntil createStatementRepeatUntil() {
        try {
            return new StatementRepeatUntilImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementRepeatUntil()");
            throw e;
        }
    }
    
    public static StatementWhileDo createStatementWhileDo() {
        try {
            return new StatementWhileDoImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementWhileDo()");
            throw e;
        }
    }
    
    public static StatementWrite createStatementWrite() {
        try {
            return new StatementWriteImpl();
        } catch (Exception e) {
            System.out.println("StatementFactory"+".createStatementWrite()");
            throw e;
        }
    }
}
