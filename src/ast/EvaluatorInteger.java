package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface EvaluatorInteger extends Evaluator {
    Integer evaluateAndGetInteger() throws Exception;
}
