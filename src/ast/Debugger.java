package ast;

import java.util.ArrayList;

import exception.NullException;



/**
 * @author Stefan Günther
 * @version 1.0
 */
public class Debugger {
    
    public static void debug(Procedure procedure, String text) throws Exception {
        try {
            if (procedure == null) {
                throw new NullException();
            }
            if (text == null) {
                throw new NullException();
            }
            
            ArrayList<ArrayList<Type>> symboltabelle = procedure.debug();
            
            System.out.println();
            System.out.println("DEBUG: " + text);
            System.out.println();
            
            for (Integer i = 0; i < symboltabelle.size(); i++) {
                System.out.println("--------------------------------------------------");
                System.out.println("Ebene " + i + ":");
                System.out.println("--------------------------------------------------");
                ArrayList<Type> ebene = symboltabelle.get(i);
                Integer size = ebene.size();
                for (Integer j = (size-1); j >= 0; j--) {
                    Type type = ebene.get(j);
                    System.out.print("Level " + j + ":\t| ");
                    System.out.print(type.getDebugType() + "\t");
                    System.out.print(type.getIdentifier() + "\t");
                    System.out.println();
                }
                System.out.println("--------------------------------------------------");
                System.out.println();
            }
            System.out.println();
            
        } catch (Exception e) {
            throw e;
        }
    }    
}
