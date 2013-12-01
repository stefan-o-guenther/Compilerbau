package ast;

import exception.NullException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ProgramImpl extends EmptinessAbstract implements Program {

    private Procedure ast = TypeFactory.createRoot();
    private String name = "";
    
    public ProgramImpl() throws Exception {
        try {
            this.ast = TypeFactory.createRoot();
            this.name = "";
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void analyse() throws Exception {
        try {
            ast.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {            
            if (debug == null) {
                throw new NullException(this.getClass().toString());
            }
            System.out.println("PL/0 Program: "+name);
            System.out.println();
            ast.evaluateOnlyAndDebug(debug);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Procedure getAST() {
        return this.ast;
    }

    @Override
    public void setAST(Procedure ast) throws Exception {
        try {
            if (ast == null) {
                throw new NullException(this.getClass().toString());
            }
            this.ast = ast;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) throws Exception {
        try {
            if (name == null) {
                throw new NullException(this.getClass().toString());
            }
            this.name = name;
        } catch (Exception e) {
            throw e;
        }
    }
}
