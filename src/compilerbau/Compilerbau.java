package compilerbau;

/**
 * 
 * @author Stefan G�nther
 *
 */
public class Compilerbau {
    
    public static void main(String[] args) {
        try {
            if (args != null) {
                Input input = new Input();
                String path = "";
                switch (args.length) {
                    case 0: {
                        // falls kein Pfad als Parameter angebeben wurde, wird dieser Quelltext ausgef�hrt.
                        path = "quelltext/code.pl0";
                        break;
                    }
                    case 1: {
                        path = args[0];
                        break;
                    }
                    default: {
                        System.out.println("nur ein Argument eingeben");
                        break;
                    }
                }
                
                // dieser Quelltext wird in Wirklichkeit ausgef�hrt.
                path = "quelltext/vorlesung/ggt.pl0";
                
                // Text der Datei wird geladen.
                String code = input.getText(path);                
                
                System.out.println(path);
                System.out.println();
                
                // 1. Parameter: Quelltext
                // 2. Parameter: soll w�rend dem Parsen debugt werden
                // 3. Parameter: soll w�rend dem Ausf�hren des Programms debugt werden
                PL0Interpreter.interpret(code, false, false);                
                
                System.out.println();
                System.out.println("+----------+");
                System.out.println("| finished |");
                System.out.println("+----------+");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}