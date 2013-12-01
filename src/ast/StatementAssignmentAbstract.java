package ast;

import exception.NullException;

/**
 * @author Stefan Günther
 * @version 1.0
 *
 * Abstrakte Klasse für alle Zuweisungen.
 */
public abstract class StatementAssignmentAbstract extends StatementAbstract implements StatementAssignment {

    private String identifier;
    private Procedure parent;
    private Variable variable;
    private AssignmentOperand assignmentOperand;
        
    protected Integer getVariableValue() throws Exception {
        try {
            return variable.getValue();
        } catch (Exception e) {
            throw e;
        }        
    }
    
    protected void setVariableValue(Integer value) throws Exception {
        try {
            if (value == null) {
                throw new NullException(this.getClass().toString());
            }
            variable.setValue(value);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    protected Integer evaluateAssignmentOperand() throws Exception {
        try {
            return assignmentOperand.evaluateAndGetInteger();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public final void analyse() throws Exception {
        try {
            variable = TypeFinder.findVariable(parent, identifier);
            assignmentOperand.analyse();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public final void setIdentifier(String identifier) throws Exception {
        try {
            if (identifier == null) {
                throw new NullException(this.getClass().toString());
            }
            this.identifier = identifier;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public final void setParent(Procedure parent) throws Exception {
        try {
            if (parent == null) {
                throw new NullException(this.getClass().toString());
            }
            this.parent = parent;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public final void setAssignmentOperand(AssignmentOperand assignmentOperand) throws Exception {
        try {
            if (assignmentOperand == null) {
                throw new NullException();
            }
            this.assignmentOperand = assignmentOperand;
        } catch (Exception e) {
            throw e;
        }
    }
}
