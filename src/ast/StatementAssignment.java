package ast;


/**
 * @author Stefan Günther
 * @version 1.0
 *
 * Schnittstelle für Zuweisungen.
 */
public interface StatementAssignment extends StatementIdentifier {
    void setAssignmentOperand(AssignmentOperand assignmentOperand) throws Exception;
}
