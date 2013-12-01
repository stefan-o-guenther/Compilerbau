package ast;


/**
 * @author Stefan G�nther
 * @version 1.0
 *
 * Schnittstelle f�r Zuweisungen.
 */
public interface StatementAssignment extends StatementIdentifier {
    void setAssignmentOperand(AssignmentOperand assignmentOperand) throws Exception;
}
