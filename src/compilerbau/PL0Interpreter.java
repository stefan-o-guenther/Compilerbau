package compilerbau;


import java.util.ArrayList;
import java.util.ListIterator;

import ast.Program;
import exception.NullException;
import frontend.Lexer;
import frontend.Parser;
import frontend.Token;

/**
 * 
 * @author Stefan Günther
 *
 */
public class PL0Interpreter {

    /**
     * listet alle Tokens auf.
     * 
     * @param code
     */
    public static void printCodeAsTokenList(String code) {
        try {
            if (code == null) {
                throw new NullException();
            }
            ArrayList<Token> listToken = Lexer.lex(code);
            ListIterator<Token> iteratorToken = listToken.listIterator();
            while (iteratorToken.hasNext()) {
                Token token = iteratorToken.next();
                System.out.println(token.getIdentifier());
            }
        } catch (Exception e) {
            System.out.println("print failed");
        }
    }
    
    
    /**
     * führt den Interpreter aus.
     * 
     * @param code = Quelltext
     * @param debugParse = soll wärend dem Parsen debugt werden
     * @param debugEvaluate = soll wärend dem Ausführen des Programms debugt werden
     * @return
     */
    public static Boolean interpret(String code, Boolean debugParse, Boolean debugEvaluate) {
        
        try {
            if (code == null) {
                throw new NullException("code is null");
            }
            
            if (debugParse == null || debugEvaluate == null) {
                throw new NullException("debug is null");
            }
            
            ArrayList<Token> listToken = Lexer.lex(code);
            
            if (listToken == null) {
                throw new NullException("listToken is null");
            }
            Program program = Parser.parse(listToken, debugParse);
            
            if (program == null) {
                throw new NullException("program is null");
            }
            
            program.analyse();
            program.evaluateOnlyAndDebug(debugEvaluate);
            
            System.out.println();
            System.out.println();
            
            return true;
            
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
