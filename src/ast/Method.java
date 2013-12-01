package ast;

import java.util.ArrayList;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public interface Method extends Type, Analyser {
    
    void addConstant(String name, Integer value) throws Exception;
    void addProcedure(Procedure procedure) throws Exception;
    void addVariable(String name) throws Exception;
    Constant getConstant(String name) throws Exception;
    Variable getVariable(String name) throws Exception;
    Datatype getDatatype(String name) throws Exception;
    Procedure getProcedure(String name) throws Exception;
    void setStatement(Statement statement) throws Exception;
    ArrayList<ArrayList<Type>> debug() throws Exception;
    Procedure getParent();
    
}
