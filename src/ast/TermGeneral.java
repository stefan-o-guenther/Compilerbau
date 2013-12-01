package ast;

import exception.NullException;

public interface TermGeneral extends Term {
    void setExponentiation(Exponentiation exponentiation) throws NullException;
    Exponentiation getExponentiation();
    void setPreviousTerm(Term term) throws NullException;
    Term getPreviousTerm();
}
