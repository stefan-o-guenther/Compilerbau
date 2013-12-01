package frontend;

import java.util.ArrayList;
import java.util.ListIterator;
import ast.AssignmentOperand;
import ast.Condition;
import ast.ConditionBracket;
import ast.ConditionComparison;
import ast.ConditionFactory;
import ast.ConditionNegation;
import ast.ConditionSingle;
import ast.Conjunction;
import ast.ConjunctionAnd;
import ast.ConjunctionFactory;
import ast.Debugger;
import ast.Disjunction;
import ast.DisjunctionFactory;
import ast.DisjunctionOr;
import ast.Exponentiation;
import ast.ExponentiationFactory;
import ast.ExponentiationPotence;
import ast.Expression;
import ast.ExpressionFactory;
import ast.ExpressionGeneral;
import ast.Factor;
import ast.FactorBrace;
import ast.FactorFactory;
import ast.FactorFaculty;
import ast.FactorIdentifier;
import ast.FactorNumber;
import ast.Procedure;
import ast.Program;
import ast.ProgramImpl;
import ast.Statement;
import ast.StatementAssignment;
import ast.StatementBeginEnd;
import ast.StatementCall;
import ast.StatementDebug;
import ast.StatementDecrement;
import ast.StatementEmpty;
import ast.StatementFactory;
import ast.StatementForToDo;
import ast.StatementIfThenElse;
import ast.StatementIncrement;
import ast.StatementRead;
import ast.StatementRepeatUntil;
import ast.StatementWhileDo;
import ast.StatementWrite;
import ast.Term;
import ast.TermFactory;
import ast.TermGeneral;
import ast.TernaryOperator;
import ast.TernaryOperatorImpl;
import ast.TypeFactory;
import exception.NullException;
import exception.SyntaxErrorException;


/**
 * PL/0 Parser.
 * Der Parser wandelt eine verkettete Liste von Token in einen AST um.
 *
 * @author Stefan Günther
 * @version 1.0
 */
public class Parser {
    
    /**
    * Liste von Token, die mit next() und previous() durchlauften werden kann.
    */
    private static ListIterator<Token> iteratorToken = null;
    
    private static void checkTokenValueString(Object object) throws Exception {
        if (object == null) {
            throw new SyntaxErrorException("parse checkTokenValueString(Object object)");
        }
        if ((object instanceof String) == false) {
            throw new SyntaxErrorException("parse checkTokenValueString(Object object)");
        }
    }
    
    private static void checkTokenValueInteger(Object object) throws Exception {
        if (object == null) {
            throw new SyntaxErrorException("parse checkTokenValueInteger(Object object)");
        }
        if ((object instanceof Integer) == false) {
            throw new SyntaxErrorException("parse checkTokenValueInteger(Object object)");
        }
    }
    
    
    /** 
     * EBNF: program = [ PROGRAM identifier ";" ] block "." .
     * 
     * @return
     * @throws Exception
     */
    private static Program parseProgram(Boolean debug) throws Exception {
        try {            
            Program program = new ProgramImpl();
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() == TokenEnum.TokenProgram) {
                token = iteratorToken.next();
                if (token.getIdentifier() != TokenEnum.TokenIdentifier) {
                    throw new SyntaxErrorException("PL0Parser.parseProcedure(IProcedure procedure "+token.getIdentifier());
                }
                checkTokenValueString(token.getValue());
                String name = (String) token.getValue();
                program.setName(name);
                
                token = iteratorToken.next();
                if (token.getIdentifier() != TokenEnum.TokenSemicolon) {
                    throw new SyntaxErrorException("PL0Parser.parseProcedure(IProcedure procedure "+token.getIdentifier());
                }
            } else {
                iteratorToken.previous();
            }            
            
            Procedure ast = TypeFactory.createRoot();            
            parseBlock(ast, debug);
            program.setAST(ast);
            
            return program;
        } catch (Exception e) {
            System.out.println("Exception parseProgram");
            throw e;
        }
    }
    
    
    
    /**
     * EBNF: block = [ const ] [ var ] { procedure } [ statement ] .
     * 
     * @param procedure
     * @throws Exception
     */
    private static void parseBlock(Procedure procedure, Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException();
            }
            parseConstant(procedure);
            parseVariable(procedure);
            parseProcedure(procedure, debug);
                    
            Statement statement = parseStatement(procedure, debug);
            procedure.setStatement(statement);
        } catch (Exception e) {
            System.out.println("Exception parseBlock()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: const = "CONST" identifier "=" number { "," identifier "=" number } ";" .
     * 
     * @param procedure
     * @throws Exception
     */
    private static void parseConstant(Procedure procedure) throws Exception {
        try {
            Token token = iteratorToken.next();
            if (token.getIdentifier() == TokenEnum.TokenConstant) {
                do {
                    token = iteratorToken.next();
                    if (token.getIdentifier() != TokenEnum.TokenIdentifier) {
                        throw new SyntaxErrorException("PL0Parser.parseConst(IProcedure procedure "+token.getIdentifier());
                    }
                    checkTokenValueString(token.getValue());
                    String name = (String) token.getValue();
                    
                    token = iteratorToken.next();
                    if (token.getIdentifier() != TokenEnum.TokenEqual) {
                        throw new SyntaxErrorException("PL0Parser.parseConst(IProcedure procedure "+token.getIdentifier());
                    }
                    
                    token = iteratorToken.next();
                    if (token.getIdentifier() != TokenEnum.TokenNumber) {
                        throw new SyntaxErrorException("PL0Parser.parseConst(IProcedure procedure "+token.getIdentifier());
                    }
                    checkTokenValueInteger(token.getValue());
                    Integer number = (Integer) token.getValue();
                    
                    procedure.addConstant(name, number);
                    
                    token = iteratorToken.next();
                } while (token.getIdentifier() == TokenEnum.TokenComma);
                if (token.getIdentifier() != TokenEnum.TokenSemicolon) {
                    throw new SyntaxErrorException("PL0Parser.parseConst(IProcedure procedure "+token.getIdentifier());
                }
            } else {
                token = iteratorToken.previous();
            }
        } catch (Exception e) {
            System.out.println("Exception parseConst()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: var = "VAR" identifier { "," identifier } ";" .
     * 
     * @param procedure
     * @throws Exception
     */
    private static void parseVariable(Procedure procedure) throws Exception {
        try {
            Token token = iteratorToken.next();
            if (token.getIdentifier() == TokenEnum.TokenVariable) {
                do {
                    token = iteratorToken.next();
                    if (token.getIdentifier() != TokenEnum.TokenIdentifier) {
                        throw new SyntaxErrorException("PL0Parser.parseVar(IProcedure procedure) "+token.getIdentifier());
                    }                    
                    checkTokenValueString(token.getValue());                    
                    String name = (String) token.getValue();
                                        
                    procedure.addVariable(name);
                    token = iteratorToken.next();
                } while (token.getIdentifier() == TokenEnum.TokenComma);
                if (token.getIdentifier() != TokenEnum.TokenSemicolon) {
                    throw new SyntaxErrorException("PL0Parser.parseVar(IProcedure procedure) "+token.getIdentifier());
                }
            } else {
                token = iteratorToken.previous();
            }
        } catch (Exception e) {
            System.out.println("Exception parseVar");
            throw e;
        }
    }
    
    
    /**
     * EBNF: procedure = "PROCEDURE" identifier ";" block ";" .
     * 
     * @param procedure
     * @throws Exception
     */
    private static void parseProcedure(Procedure procedure, Boolean debug) throws Exception {
        try {
            if (procedure == null) {
                throw new NullException();
            }
            if (debug == null) {
                throw new NullException();
            }
            Token token = iteratorToken.next();
            while (token.getIdentifier() == TokenEnum.TokenProcedure) {
                token = iteratorToken.next();
                if (token.getIdentifier() != TokenEnum.TokenIdentifier) {
                    throw new SyntaxErrorException("PL0Parser.parseProcedure(IProcedure procedure "+token.getIdentifier());
                }
                checkTokenValueString(token.getValue());
                String name = (String) token.getValue();
                
                Procedure procedureNew = TypeFactory.createProcedure(name, procedure);
                procedure.addProcedure(procedureNew);
                
                if (debug) {
                    Debugger.debug(procedure, "add Procedure");
                }
                
                                
                token = iteratorToken.next();
                if (token.getIdentifier() != TokenEnum.TokenSemicolon) {
                    throw new SyntaxErrorException("PL0Parser.parseProcedure(IProcedure procedure "+token.getIdentifier());
                }
                
                parseBlock(procedureNew, debug);
                
                token = iteratorToken.next();
                if (token.getIdentifier() != TokenEnum.TokenSemicolon) {
                    throw new SyntaxErrorException("PL0Parser.parseProcedure(IProcedure procedure "+token.getIdentifier());
                }
                token = iteratorToken.next();
            }
            token = iteratorToken.previous();
        } catch (Exception e) {
            System.out.println("Exception parseProcedure()");
            throw e;
        }
    }
    
    
    
    
    
    /**
     * EBNF: statement =   assignment 
     *                   | call 
     *                   | read 
     *                   | write 
     *                   | beginend 
     *                   | ifthenelse 
     *                   | whiledo 
     *                   | repeatuntil 
     *                   | debug 
     *                   | fortodo 
     *                   | increment
     *                   | decrement .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static Statement parseStatement(Procedure procedure, Boolean debug) throws Exception {
        try {
            Statement statement = StatementFactory.createStatementEmpty();
            Token token = iteratorToken.next();
            
            switch (token.getIdentifier()) {
                case TokenIdentifier: {
                    token = iteratorToken.previous();
                    statement = parseStatementAssignment(procedure);
                    break;
                }
                case TokenCall: {
                    statement = parseStatementCall(procedure);
                    break;
                }
                case TokenExclamationMark: {
                    statement = parseStatementWrite(procedure);
                    break;
                }
                case TokenQuestionMark: {
                    statement = parseStatementRead(procedure);
                    break;
                }
                case TokenBegin: {
                    statement = parseStatementBeginEnd(procedure, debug);
                    break;
                }
                case TokenIf: {
                    statement = parseStatementIfThen(procedure, debug);
                    break;
                }
                case TokenWhile: {
                    statement = parseStatementWhileDo(procedure, debug);
                    break;
                }
                case TokenRepeat: {
                    statement = parseStatementRepeatUntil(procedure, debug);
                    break;
                }
                case TokenDebug: {
                    statement = parseStatementDebug(procedure, debug);
                    break;
                }
                case TokenFor: {
                    statement = parseStatementForToDo(procedure, debug);
                    break;
                }
                case TokenIncrement: {
                    statement = parseStatmentIncrement(procedure);
                    break;
                }
                case TokenDecrement: {
                    statement = parseStatmentDecrement(procedure);
                    break;
                }
                default: {
                    statement = parseStatementEmpty(procedure);
                    token = iteratorToken.previous();
                    break;
                }                
            }
            return statement;
        } catch (Exception e) {
            System.out.println("Exception parseStatement()");
            throw e;
        }
    }

    
    /**
     * EBNF: assignment = identifier ( ":=" | "+=" | "-=" | "*=" | "/=" | "%=" ) ( expression | ternary ) .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementAssignment parseStatementAssignment(Procedure procedure) throws Exception {
        try {
            StatementAssignment assignment = StatementFactory.createStatementAssignmentGeneral();
            Token token = iteratorToken.next();
            
            if (token.getIdentifier() != TokenEnum.TokenIdentifier) {
                throw new SyntaxErrorException("parseStatementAssignment(Procedure procedure "+token.getIdentifier()+")");
            }
            checkTokenValueString(token.getValue());
            String name = (String) token.getValue();
                        
            token = iteratorToken.next();
            
            switch (token.getIdentifier()) {
                case TokenAssignment: {
                    assignment = StatementFactory.createStatementAssignmentGeneral();
                    break;
                }
                case TokenAssignmentAddition: {
                    assignment = StatementFactory.createStatementAssignmentAddition();
                    break;
                }
                case TokenAssignmentSubtraction: {
                    assignment = StatementFactory.createStatementAssignmentSubtraction();
                    break;
                }
                case TokenAssignmentMultiplication: {
                    assignment = StatementFactory.createStatementAssignmentMultiplication();
                    break;
                }
                case TokenAssignmentDivision: {
                    assignment = StatementFactory.createStatementAssignmentDivision();
                    break;
                }
                case TokenAssignmentModulo: {
                    assignment = StatementFactory.createStatementAssignmentModulo();
                    break;
                }
                default: {
                    throw new SyntaxErrorException("PL0Parser.parseStatementAssignment(IProcedure procedure) "+token.getIdentifier());
                }
            }           
            
            AssignmentOperand assignoper = null;
            
            token = iteratorToken.next();
            
            switch (token.getIdentifier()) {
                case TokenTernary: {
                    assignoper = parseStatementTernaryOperator(procedure);
                    break;
                }
                default: {
                    token = iteratorToken.previous();
                    assignoper = parseExpression(procedure);
                    break;
                }
            }        
            
            assignment.setParent(procedure);
            assignment.setIdentifier(name);
            assignment.setAssignmentOperand(assignoper);
            
            return assignment;
        } catch (Exception e) {
            System.out.println("Exception parseStatementAssignment()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: ternary = "TERNARY" disjunction "?" expression ":" expression .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static TernaryOperator parseStatementTernaryOperator(Procedure procedure) throws Exception {
        try {
            TernaryOperator ternary = new TernaryOperatorImpl();
            Disjunction disjunction = parseDisjunction(procedure);
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenQuestionMark) {
                throw new SyntaxErrorException();
            }
            Expression expressionThen = parseExpression(procedure);
            
            token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenColon) {
                throw new SyntaxErrorException();
            }
            Expression expressionElse = parseExpression(procedure);
            ternary.setDisjunction(disjunction);
            ternary.setExpressionThen(expressionThen);
            ternary.setExpressionElse(expressionElse);
            
            return ternary;
        } catch (Exception e) {
            System.out.println("Exception parseStatementTernaryOperator()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: call = "CALL" identifier .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementCall parseStatementCall(Procedure procedure) throws Exception {
        try {
            StatementCall call = StatementFactory.createStatementCall();
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenIdentifier) {
                throw new SyntaxErrorException("PL0Parser.parseStatementCall(IProcedure procedure "+token.getIdentifier());
            }
            checkTokenValueString(token.getValue());
            String name = (String) token.getValue();
            
            call.setIdentifier(name);
            call.setParent(procedure);
                
            return call;
        } catch (Exception e) {
            System.out.println("Exception parseStatementCall()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: read = "?" identifier .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementRead parseStatementRead(Procedure procedure) throws Exception {
        try {
            StatementRead read = StatementFactory.createStatementRead();
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenIdentifier) {
                throw new SyntaxErrorException("PL0Parser.parseStatementRead(IProcedure procedure "+token.getIdentifier());
            }
            checkTokenValueString(token.getValue());
            String name = (String) token.getValue();
            
            read.setIdentifier(name);
            read.setParent(procedure);
            
            return read;
        } catch (Exception e) {
            System.out.println("Exception parseStatementRead");
            throw e;
        }
    }
    
    
    /**
     * EBNF: write = "!" expression .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementWrite parseStatementWrite(Procedure procedure) throws Exception {
        try {
            StatementWrite statementWrite = StatementFactory.createStatementWrite();
            Expression expression = parseExpression(procedure);
            
            statementWrite.setExpression(expression);
            return statementWrite;
        } catch (Exception e) {
            System.out.println("Exception parseStatementWrite");
            throw e;
        }
    }
    
    
    /**
     * EBNF: beginend = "BEGIN" statement { ";" statement } "END"
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementBeginEnd parseStatementBeginEnd(Procedure procedure, Boolean debug) throws Exception {
        try {
            StatementBeginEnd beginend = StatementFactory.createStatementBeginEnd();
            Token token;
            do {
                Statement statement = parseStatement(procedure, debug);
                
                beginend.addStatement(statement);
                token = iteratorToken.next();
            } while (token.getIdentifier() == TokenEnum.TokenSemicolon);
            if (token.getIdentifier() != TokenEnum.TokenEnd) {
                throw new SyntaxErrorException("PL0Parser.parseStatementBeginEnd(IProcedure procedure "+token.getIdentifier()+")");
            }
            return beginend;
        } catch (Exception e) {
            System.out.println("Exception parseStatementBeginEnd()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: ifthenelse = "IF" disjunction "THEN" statement [ "ELSE" statement ]
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementIfThenElse parseStatementIfThen(Procedure procedure, Boolean debug) throws Exception {
        try {
            StatementIfThenElse ifthen = StatementFactory.createStatementIfThenElse();
            Disjunction disjunction = parseDisjunction(procedure);
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenThen) {
                throw new SyntaxErrorException("PL0Parser.parseStatementIfThen(IProcedure procedure "+token.getIdentifier());
            }
            
            Statement statementthen = parseStatement(procedure, debug);
            
            Statement statementelse = null;
            
            token = iteratorToken.next();
            
            switch (token.getIdentifier()) {
                case TokenElse: {
                    statementelse = parseStatement(procedure, debug);
                    break;
                }
                default: {
                    token = iteratorToken.previous();
                    statementelse = StatementFactory.createStatementEmpty();
                    break;
                }
            }        
            
            ifthen.setDisjunction(disjunction);
            ifthen.setStatementThen(statementthen);
            ifthen.setStatementElse(statementelse);
            
            return ifthen;
        } catch (Exception e) {
            System.out.println("Exception parseStatementIfThen()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: whiledo = "WHILE" disjunction "DO" statement .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementWhileDo parseStatementWhileDo(Procedure procedure, Boolean debug) throws Exception {
        try {
            StatementWhileDo whiledo = StatementFactory.createStatementWhileDo();
            Disjunction disjunction = parseDisjunction(procedure);
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenDo) {
                throw new SyntaxErrorException("PL0Parser.parseStatementWhileDo(IProcedure procedure "+token.getIdentifier());
            }
            
            Statement statement = parseStatement(procedure, debug);
            
            whiledo.setDisjunction(disjunction);
            whiledo.setStatement(statement);
            
            return whiledo;
        } catch (Exception e) {
            System.out.println("Exception parseStatementWhileDo()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: repeatuntil = "REPEAT" statement "UNTIL "disjunction" .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementRepeatUntil parseStatementRepeatUntil(Procedure procedure, Boolean debug) throws Exception {
        try {
            StatementRepeatUntil repeatuntil = StatementFactory.createStatementRepeatUntil();
            Statement statement = parseStatement(procedure, debug);
            
            repeatuntil.setStatement(statement);
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenUntil) {
                throw new SyntaxErrorException("PL0Parser.parseStatementRepeatUntil(IProcedure procedure "+token.getIdentifier()+")");
            }
            
            Disjunction disjunction = parseDisjunction(procedure);
            
            repeatuntil.setDisjunction(disjunction);
            return repeatuntil;
        } catch (Exception e) {
            System.out.println("Exception parseStatementRepeatUntil()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: debug = "DEBUG" .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementDebug parseStatementDebug(Procedure procedure, Boolean debug) throws Exception {
        try {
            if (debug == null) {
                throw new NullException();
            }
            StatementDebug stdebug = StatementFactory.createStatementDebug();
            stdebug.setParent(procedure);
            if (debug) {
                Debugger.debug(procedure, "add StatementDebug");
            }            
            return stdebug;
        } catch (Exception e) {
            System.out.println("Exception parseStatementDebug()");
            throw e;
        }
    }
    
    
    /**
     * leeres Statement 
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementEmpty parseStatementEmpty(Procedure procedure) throws Exception {
        try {
            StatementEmpty empty = StatementFactory.createStatementEmpty();
            return empty;
        } catch (Exception e) {
            System.out.println("Exception parseStatementEmpty()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: fortodo = "FOR" identifier ":=" number "TO" number "DO" statement
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementForToDo parseStatementForToDo(Procedure procedure, Boolean debug) throws Exception {
        try {
            StatementForToDo fortodo = StatementFactory.createStatementForToDo();
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenIdentifier) {
                throw new SyntaxErrorException("PL0Parser.parseStatementForToDo(IProcedure procedure)");
            }            
            checkTokenValueString(token.getValue());
            String name = (String) token.getValue();
                        
            token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenAssignment) {
                throw new SyntaxErrorException("PL0Parser.parseStatementForToDo(IProcedure procedure)");
            }
            
            Expression expressionFrom = parseExpression(procedure);
            
            token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenTo) {
                throw new SyntaxErrorException("PL0Parser.parseStatementForToDo(IProcedure procedure)");
            }
            
            Expression expressionTo = parseExpression(procedure);
            
            token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenDo) {
                throw new NullException("PL0Parser.parseStatementForToDo(IProcedure procedure)");
            }
            
            Statement statement = parseStatement(procedure, debug);
            
            fortodo.setExpressionFrom(expressionFrom);
            fortodo.setExpressionTo(expressionTo);
            fortodo.setStatement(statement);
            fortodo.setIdentifier(name);
            fortodo.setParent(procedure);
                                
            return fortodo;
        } catch (Exception e) {
            System.out.println("Exception parseStatementForToDo()");
            throw e;
        }
    }

    
    /**
     * EBNF: increment = "INC" identifier .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementIncrement parseStatmentIncrement(Procedure procedure) throws Exception {
        try {
            StatementIncrement inc = StatementFactory.createStatementIncrement();
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenIdentifier) {
                throw new SyntaxErrorException("PL0Parser.parseStatementInc(IProcedure procedure)");
            }
            checkTokenValueString(token.getValue());
            String name = (String) token.getValue();
            
            inc.setIdentifier(name);
            inc.setParent(procedure);
            
            return inc;
            
        } catch (Exception e) {
            System.out.println("Exception parseStatementInc()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: decrement = "DEC" identifier .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static StatementDecrement parseStatmentDecrement(Procedure procedure) throws Exception {
        try {
            StatementDecrement dec = StatementFactory.createStatementDectrement();
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenIdentifier) {
                throw new SyntaxErrorException("PL0Parser.parseStatementDec(IProcedure procedure)");
            }
            checkTokenValueString(token.getValue());
            String name = (String) token.getValue();
            
            dec.setIdentifier(name);
            dec.setParent(procedure);
            
            return dec;
            
        } catch (Exception e) {
            System.out.println("Exception parseStatementDec()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: disjunction = conjunction { "|" conjunction } .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static Disjunction parseDisjunction(Procedure procedure) throws Exception {
        try {
            Disjunction disjunction = DisjunctionFactory.createDisjunctionEmpty();
            
            Token token;
            do {
                Conjunction conjunction = parseConjunction(procedure);
                
                DisjunctionOr disjunctionNew = DisjunctionFactory.createDisjunctionOr();
                disjunctionNew.setConjunction(conjunction);
                disjunctionNew.setPreviousDisjunction(disjunction);
                disjunction = disjunctionNew;
                
                token = iteratorToken.next();                
            } while (token.getIdentifier() == TokenEnum.TokenOr);
            token = iteratorToken.previous();
            
            return disjunction;
        } catch (Exception e) {
            System.out.println("parseDisjunction(IProcedure procedure)");
            throw e;
        }
    }
    
    
    /**
     * EBNF: conjunction = condition { "&" condition } .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static Conjunction parseConjunction(Procedure procedure) throws Exception {
        try {
            Conjunction conjunction = ConjunctionFactory.createConjunctionEmpty();
            
            Token token;
            do {
                Condition condition = parseCondition(procedure);
                
                ConjunctionAnd conjunctionNew = ConjunctionFactory.createConjunctionAnd();
                conjunctionNew.setCondition(condition);
                conjunctionNew.setPreviousConjunction(conjunction);
                conjunction = conjunctionNew;
                
                token = iteratorToken.next();
            } while (token.getIdentifier() == TokenEnum.TokenAnd);
            token = iteratorToken.previous();
            
            return conjunction;
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("parseConjunction(IProcedure procedure)");
            throw e;
        }
    }
    
    
    /**
     * EBNF: condition = bracket | evenodd | negation | comparison .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static Condition parseCondition(Procedure procedure) throws Exception {
        try {
            Condition condition = null;
            Token token = iteratorToken.next();
            
            switch (token.getIdentifier()) {
                case TokenBracketOpen: {
                    condition = parseBracket(procedure);
                    break;
                }
                case TokenOdd: case TokenEven: {
                    token = iteratorToken.previous();
                    condition = parseEvenOdd(procedure);
                    break;
                }
                case TokenNot: case TokenExclamationMark: {
                    condition = parseNegation(procedure);
                    break;
                }
                default: {
                    token = iteratorToken.previous();
                    condition = parseComparison(procedure);
                    break;
                }
            }
            
            return condition;
        } catch (Exception e) {
            System.out.println("Exception parseCondition(IProcedure procedure)");
            throw e;
        }
    }
    
    
    /**
     * EBNF: bracket = "(" disjunction ")" .
     * 
     * @param procedure
     * @return ConditionBracket
     * @throws Exception
     */
    private static ConditionBracket parseBracket(Procedure procedure) throws Exception {
        try {
            ConditionBracket bracket = ConditionFactory.createConditionBracket();
            Disjunction disjunction = parseDisjunction(procedure);
            
            bracket.setDisjunction(disjunction);
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenBracketClose) {
                throw new SyntaxErrorException();
            }
            
            return bracket;
        } catch (Exception e) {
            System.out.println("parseBracket(IProcedure procedure)");
            throw e;
        }
    }
    
    
    /**
     * EBNF: evenodd = ( "ODD" | "EVEN" ) expression .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static ConditionSingle parseEvenOdd(Procedure procedure) throws Exception {
        try {
            ConditionSingle single = null;
            
            Token token = iteratorToken.next();
            
            switch (token.getIdentifier()) {
                case TokenOdd: {
                    single = ConditionFactory.createConditionOdd();
                    break;
                }
                case TokenEven: {
                    single = ConditionFactory.createConditionEven();
                    break;
                }
                default: {
                    throw new SyntaxErrorException();
                }               
            }            
            Expression expression = parseExpression(procedure);            
            single.setExpression(expression);
            
            return single;
        } catch (Exception e) {
            System.out.println(" parseEvenOdd(IProcedure procedure)");
            throw e;
        }
    }
    
    
    /**
     * EBNF: negation = ( "!" | "NOT" ) condition .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static ConditionNegation parseNegation(Procedure procedure) throws Exception {
        try {
            ConditionNegation negation = ConditionFactory.createConditionNegation();            
            Condition condition = parseCondition(procedure);            
            negation.setCondition(condition);            
            return negation;
        } catch (Exception e) {
            System.out.println("Exception parseNegation()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: comparison = expression ( "=" | "#" | "<" | "<=" | ">" | ">=" | "!=" | "<>" ) expression .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static ConditionComparison parseComparison(Procedure procedure) throws Exception {
        try {
            ConditionComparison comparison = null;
            Expression expressionLeft = parseExpression(procedure);            
            Token token = iteratorToken.next();
            
            switch (token.getIdentifier()) {
                case TokenEqual: {
                    comparison = ConditionFactory.createConditionEqual();
                    break;
                }
                case TokenNotEqual: {
                    comparison = ConditionFactory.createConditionNotEqual();
                    break;
                }
                case TokenLessThan: {
                    comparison = ConditionFactory.createConditionLessThan();
                    break;
                }
                case TokenLessEqual: {
                    comparison = ConditionFactory.createConditionLessEqual();
                    break;
                }
                case TokenGreaterThan: {
                    comparison = ConditionFactory.createConditionGreaterThan();
                    break;
                }
                case TokenGreaterEqual: {
                    comparison = ConditionFactory.createConditionGreaterThan();
                    break;
                }
                default: {
                    throw new SyntaxErrorException("PL0Parser.parseComparison(IProcedure procedure "+token.getIdentifier());
                }
            }
            
            Expression expressionRight = parseExpression(procedure);
            
            comparison.setExpressionLeft(expressionLeft);
            comparison.setExpressionRight(expressionRight);
            
            return comparison;
        } catch (Exception e) {
            System.out.println("Exception parseComparison()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: expression = [ "+" | "-" ] term { ( "+" | "-" ) term } .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static Expression parseExpression(Procedure procedure) throws Exception {
        try {
            Expression expression = ExpressionFactory.createExpressionEmpty();
            
            Token token = iteratorToken.next();
            
            if ((token.getIdentifier() != TokenEnum.TokenAddition) && 
                (token.getIdentifier() != TokenEnum.TokenSubtraction)) {
                
                token = iteratorToken.previous();
                token = TokenFactory.createTokenAddition();
            }
            
            while ((token.getIdentifier() == TokenEnum.TokenAddition) || 
                   (token.getIdentifier() == TokenEnum.TokenSubtraction)) {
                
                ExpressionGeneral expressionNew;
                
                switch (token.getIdentifier()) {
                    case TokenAddition: {
                        expressionNew = ExpressionFactory.createExpressionAddition();
                        break;
                    }
                    case TokenSubtraction: {
                        expressionNew = ExpressionFactory.createExpressionSubtraction();
                        break;
                    }
                    default: {
                        throw new SyntaxErrorException();
                    }
                }
                
                Term term = parseTerm(procedure);
                
                expressionNew.setTerm(term);
                expressionNew.setPreviousExpression(expression);
                expression = expressionNew;
                
                token = iteratorToken.next();
            }
            token = iteratorToken.previous();
            
            return expression;
        } catch (Exception e) {
            System.out.println("Exception parseExpression()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: term = exponentiation { ( "*" | "/" | "%" ) exponentiation } .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static Term parseTerm(Procedure procedure) throws Exception {
        try {
            Term term = TermFactory.createTermEmpty();
                        
            Token token = TokenFactory.createTokenMultiplication();
            while ((token.getIdentifier() == TokenEnum.TokenMultiplication) || 
                   (token.getIdentifier() == TokenEnum.TokenDivision) || 
                   (token.getIdentifier() == TokenEnum.TokenModulo)) {
                
                TermGeneral termNew;
                
                switch (token.getIdentifier()) {
                    case TokenMultiplication: {
                        termNew = TermFactory.createTermMultiplication();
                        break;
                    }
                    case TokenDivision: {
                        termNew = TermFactory.createTermDivision();
                        break;
                    }
                    case TokenModulo: {
                        termNew = TermFactory.createTermModulo();
                        break;
                    }
                    default: {
                        throw new SyntaxErrorException();
                    }
                }
                
                Exponentiation exponentiation = parseExponentiation(procedure);
                
                termNew.setExponentiation(exponentiation);
                termNew.setPreviousTerm(term);
                term = termNew;
                
                token = iteratorToken.next();
            }
            token = iteratorToken.previous();
            
            return term;
        } catch (Exception e) {
            System.out.println("Exception parseTerm()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: exponentiation = factor { ( "^" | "**" ) factor } .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static Exponentiation parseExponentiation(Procedure procedure) throws Exception {
        try {
            Exponentiation exponentiationFirst = ExponentiationFactory.createExponentiationEmpty();
            ExponentiationPotence exponentiationLast = null;
            Token token;
            do {                
                Factor factor = parseFactor(procedure);
                
                ExponentiationPotence exponentiation = ExponentiationFactory.createExponentiationGeneral();
                exponentiation.setFactor(factor);
                
                if (exponentiationFirst.isEmpty()) {
                    exponentiationFirst = exponentiation;
                    exponentiationLast = exponentiation;
                } else {
                    exponentiationLast.setNextExponentiation(exponentiation);
                    exponentiationLast = exponentiation;
                }
                token = iteratorToken.next();
            } while (token.getIdentifier() == TokenEnum.TokenExponentiation);
            token = iteratorToken.previous();
            
            return exponentiationFirst;
        } catch (Exception e) {
            System.out.println("Exception parseExponentiation()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: factor = factorident | factornumber | factorbrace .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static Factor parseFactor(Procedure procedure) throws Exception {
        try {
            Factor factor = FactorFactory.createFactorEmpty();
            
            Token token = iteratorToken.next();
            
            switch (token.getIdentifier()) {
                case TokenIdentifier: {
                    token = iteratorToken.previous();
                    factor = parseFactorIdentifier(procedure);
                    break;
                }
                case TokenNumber: {
                    token = iteratorToken.previous();
                    factor = parseFactorNumber(procedure);
                    break;
                }
                case TokenBraceOpen: {
                    factor = parseFactorBrace(procedure);
                    break;
                }
                default: {
                    throw new SyntaxErrorException("PL0Parser.parseFactor(IProcedure procedure)");
                }
            }
            
            token = iteratorToken.next();
            
            if (token.getIdentifier() == TokenEnum.TokenExclamationMark) {
                FactorFaculty faculty = FactorFactory.createFactorFaculty();
                faculty.setFactor(factor);
                factor = faculty;
            } else {
                token = iteratorToken.previous();
            }
            return factor;
        } catch (Exception e) {
            System.out.println("Exception parseFactor()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: factorident = identifier .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static Factor parseFactorIdentifier(Procedure procedure) throws Exception {
        try {
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenIdentifier) {
                throw new SyntaxErrorException("PL0Parser.parseFactorIdent(IProcedure procedure)");
            }
            checkTokenValueString(token.getValue());
            String name = (String) token.getValue();
            
            FactorIdentifier factor = FactorFactory.createFactorIdentifier();
            factor.setIdentifier(name);
            factor.setParent(procedure);
            
            return factor;
        } catch (Exception e) {
            System.out.println("Exception parseFactorIdent()");
            throw e;
        }
    }
    
    
    /**
     * EBNF: factornumber = number .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static Factor parseFactorNumber(Procedure procedure) throws Exception {
        try {
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenNumber) {
                throw new SyntaxErrorException("PL0Parser.parseFactorNumber(IProcedure procedure)");
            }
            checkTokenValueInteger(token.getValue());
            Integer number = (Integer) token.getValue();
            
            FactorNumber factor = FactorFactory.createFactorNumber();
            factor.setNumber(number);
            
            return factor;
        } catch (Exception e) {
            System.out.println("Exception parseFactorNumber");
            throw e;
        }
    }

    
    /**
     * EBNF: factorbrace = "(" expression ")" .
     * 
     * @param procedure
     * @return
     * @throws Exception
     */
    private static Factor parseFactorBrace(Procedure procedure) throws Exception {
        try {
            Expression expression = parseExpression(procedure);
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenBraceClose) {
                throw new SyntaxErrorException("PL0Parser.parseFactor(IProcedure procedure "+token.getIdentifier());
            }
            
            FactorBrace factor = FactorFactory.createFactorBrace();
            factor.setExpression(expression);
            
            return factor;
        } catch (Exception e) {
            System.out.println("Exception parseFactorBrace");
            throw e;
        }
    }


    /**
     * parst den Quellcode eines PL/0 Programmes und gibt das fertige Programm zurück.
     *       
     * @param listToken
     * @return
     * @throws Exception
     */
    public static Program parse(ArrayList<Token> listToken, Boolean debug) throws Exception {
        try {
            ArrayList<Token> _listToken = null;
            
            if (listToken == null) {
                throw new NullException("PL0Parser.setTokenList(ITokenList value)");
            }
            _listToken = listToken;
            iteratorToken = _listToken.listIterator();
            
            while(iteratorToken.hasPrevious()) {
                iteratorToken.previous();
            }
            
            Program program = parseProgram(debug);
            
            Token token = iteratorToken.next();
            if (token.getIdentifier() != TokenEnum.TokenDot) {
                throw new SyntaxErrorException("PL0Parser.parse()");
            }
                        
            token = iteratorToken.next();
            
            if (iteratorToken.hasNext()) {
                throw new SyntaxErrorException("PL0Parser.parse()");
            }
                        
            return program;
            
        } catch (Exception e) {
            throw e;
        }
    }
}
