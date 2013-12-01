package ast;

import exception.SemanticErrorException;

public class TypeFinder {
    
    
    public static Procedure findProcedure(Procedure parent, String identifier) throws Exception {
        try {
            Procedure procedure = null;
            while ((parent != null) && (procedure == null)) {
                procedure = parent.getProcedure(identifier);
                parent = parent.getParent();
            }
            if (procedure == null) {
                throw new SemanticErrorException();
            }
            return procedure;
        } catch (Exception e) {
            System.out.println("TypeFinder"+".findProcedure(Procedure parent, String identifier)");
            throw e;
        }
    }

    
    public static Datatype findDatatype(Procedure parent, String identifier) throws Exception {
        try {
            Datatype datatype = null;
            while ((parent != null) && (datatype == null)) {
                datatype = parent.getDatatype(identifier);
                parent = parent.getParent();
            }
            if (datatype == null) {
                throw new SemanticErrorException();
            }
            return datatype;
        } catch (Exception e) {
            System.out.println("TypeFinder"+".findDatatype(Procedure parent, String identifier)");
            throw e;
        }
    }

    
    public static Variable findVariable(Procedure parent, String identifier) throws Exception {
        try {
            Variable variable = null;
            while ((parent != null) && (variable == null)) {
                variable = parent.getVariable(identifier);
                parent = parent.getParent();
            }
            if (variable == null) {
                throw new SemanticErrorException();
            }
            return variable;
        } catch (Exception e) {
            System.out.println("TypeFinder"+".findVariable(Procedure parent, String identifier)");
            throw e;
        }
    }

    
    public static Constant findConstant(Procedure parent, String identifier) throws Exception {
        try {
            Constant constant = null;
            while ((parent != null) && (constant == null)) {
                constant = parent.getConstant(identifier);
                parent = parent.getParent();
            }
            if (constant == null) {
                throw new SemanticErrorException();
            }
            return constant;
        } catch (Exception e) {
            System.out.println("TypeFinder"+".findConstant(Procedure parent, String identifier)");
            throw e;
        }
    }
}
