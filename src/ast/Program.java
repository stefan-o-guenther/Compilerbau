package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface Program extends Analyser, EvaluatorVoidDebug, Emptiness {
    Procedure getAST();
    void setAST(Procedure ast) throws Exception;
    String getName();
    void setName(String name) throws Exception;
}
