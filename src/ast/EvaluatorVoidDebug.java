package ast;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface EvaluatorVoidDebug extends Evaluator {
    void evaluateOnlyAndDebug(Boolean debug) throws Exception;
}
