package ast;


public class TypeFactory {

    public static Constant createConstant(String name, Integer value) throws Exception {
        try {
            return new ConstantImpl(name,value);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Variable createVariable(String name) throws Exception {
        try {
            return new VariableImpl(name);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Procedure createRoot() throws Exception {
        try {
            return new ProcedureImpl();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Procedure createProcedure(String name, Procedure parent) throws Exception {
        try {
            return new ProcedureImpl(name,parent);
        } catch (Exception e) {
            throw e;
        }
    }
}
