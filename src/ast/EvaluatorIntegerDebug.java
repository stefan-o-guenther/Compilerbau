package ast;

public interface EvaluatorIntegerDebug extends Evaluator {
    Integer evaluateAndGetIntegerAndDebug(Boolean debug) throws Exception;
}
