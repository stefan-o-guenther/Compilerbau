package ast;

import java.util.ArrayList;

import exception.NullException;
import exception.SyntaxErrorException;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class ProcedureImpl extends TypeAbstract implements Procedure {

    private Statement statement = new StatementEmptyImpl();
    private Procedure parent = null;

    private ArrayList<Constant> listConstant = new ArrayList<Constant>();
    private ArrayList<Variable> listVariable = new ArrayList<Variable>();
    private ArrayList<Procedure> listProcedure = new ArrayList<Procedure>();
    
    private void analyseListConstant() throws Exception {
        try {
            for (Constant const1 : listConstant) {
                for (Constant const2 : listConstant) {
                    String name1 = const1.getIdentifier();
                    String name2 = const2.getIdentifier();
                    if ((const1 != const2) && (name1.equals(name2))) {
                        throw new SyntaxErrorException(this.getClass().toString());
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void analyseListVariable() throws Exception {
        try {
            for (Variable var1 : listVariable) {
                for (Variable var2 : listVariable) {
                    String name1 = var1.getIdentifier();
                    String name2 = var2.getIdentifier();
                    if ((var1 != var2) && (name1.equals(name2))) {
                        throw new SyntaxErrorException(this.getClass().toString());
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void analyseListProcedure() throws Exception {
        try {
            for (Procedure proc1 : listProcedure) {
                for (Procedure proc2 : listProcedure) {
                    String name1 = proc1.getIdentifier();
                    String name2 = proc2.getIdentifier();
                    if ((proc1 != proc2) && name1.equals(name2)) {
                        throw new SyntaxErrorException(this.getClass().toString());
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void compareLists() throws Exception {
        try {
            for (Constant constant : listConstant) {
                for (Variable variable : listVariable) {
                    String nameC = constant.getIdentifier();
                    String nameV = variable.getIdentifier();
                    if (nameC.equals(nameV)) {
                        throw new SyntaxErrorException(this.getClass().toString());
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ProcedureImpl() throws Exception {
        super("", "proc");
        parent = null;
    }
    
    public ProcedureImpl(String name, Procedure parent) throws Exception {
        super(name, "proc");
        this.parent = parent;
    }
    
    @Override
    public void setStatement(Statement statement) throws Exception {
        try {
            if (statement == null) {
                throw new NullException(this.getClass().toString());
            }
            this.statement = statement;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Datatype getDatatype(String name) throws Exception {
        try {
            Datatype datatype = null;
            Constant constant = this.getConstant(name);
            Variable var = this.getVariable(name);
            if (constant != null) {
                datatype = constant;
            } else {
                datatype = var;
            }
            return datatype;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public Constant getConstant(String name) throws Exception {
        try {
            if (name == null) {
                throw new NullException(this.getClass().toString());
            }
            Constant constant = null;
            for (Constant c : listConstant) {
                String nameC = c.getIdentifier();
                if (nameC.equals(name)) {
                    constant = c;
                    break;
                }
            }
            return constant;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public Variable getVariable(String name) throws Exception {
        try {
            if (name == null) {
                throw new NullException(this.getClass().toString());
            }
            Variable variable = null;
            for (Variable v : listVariable) {
                String nameV = v.getIdentifier();
                if (nameV.equals(name)) {
                    variable = v;
                    break;
                }
            }
            return variable;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Procedure getProcedure(String name) throws Exception {
        try {
            if (name == null) {
                throw new NullException(this.getClass().toString());
            }
            Procedure procedure = null;
            for (Procedure p : listProcedure) {
                String nameP = p.getIdentifier();
                if (nameP.equals(name)) {
                    procedure = p;
                    break;
                }
            }
            return procedure;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void addConstant(String name, Integer value) throws Exception {
        try {
            if ((name == null) || (value == null) || (name.equals(""))) {
                throw new NullException(this.getClass().toString());
            }
            Constant constant = TypeFactory.createConstant(name, value);
            listConstant.add(constant);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void addVariable(String name) throws Exception {
        try {
            if ((name == null) || name.equals("")) {
                throw new NullException(this.getClass().toString());
            }
            Variable variable = TypeFactory.createVariable(name);
            listVariable.add(variable);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void addProcedure(Procedure procedure) throws Exception {
        try {
            if (procedure == null) {
                throw new NullException(this.getClass().toString());
            }
            listProcedure.add(procedure);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void evaluateOnlyAndDebug(Boolean debug) throws Exception {
        try {
            for (Variable variable : listVariable) {
                variable.pushValue();
            }
            statement.evaluateOnlyAndDebug(debug);
            for (Variable variable : listVariable) {
                variable.popValue();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Procedure getParent() {
        try {
            return parent;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void analyse() throws Exception {
        try {
            this.analyseListConstant();
            this.analyseListVariable();
            this.analyseListProcedure();
            compareLists();
            for (Procedure procedure : listProcedure) {
                procedure.analyse();
            }
            statement.analyse();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public ArrayList<ArrayList<Type>> debug() throws Exception {
        try {
            ArrayList<ArrayList<Type>> symboltable = null;
            if (parent != null) {
                symboltable = parent.debug();
            } else {
                symboltable = new ArrayList<ArrayList<Type>>();
            }
            ArrayList<Type> level = new ArrayList<Type>();
            for (Constant c : listConstant) {
                level.add(c);
            }
            for (Variable v : listVariable) {
                level.add(v);
            }
            for (Procedure p: listProcedure) {
                level.add(p);
            }
            symboltable.add(level);
            return symboltable;
        } catch (Exception e) {
            throw e;
        }
    }
}
