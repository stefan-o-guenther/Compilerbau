package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface EvaluatorBoolean extends Evaluator {
    Boolean evaluateAndGetBoolean() throws Exception;
}
