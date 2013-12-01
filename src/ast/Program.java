package ast;


/**
 * @author Stefan G�nther
 * @version 1.0
 */
public interface Program extends Analyser, EvaluatorVoidDebug, Emptiness {
    Procedure getAST();
    void setAST(Procedure ast) throws Exception;
    String getName();
    void setName(String name) throws Exception;
}
