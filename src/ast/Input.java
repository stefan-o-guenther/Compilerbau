package ast;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author Stefan Günther
 * @version 1.0
 */
public class Input {

    public static Integer readInteger() throws Exception {
        try {
            System.out.print("READ: ");
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
            String number = bufferedreader.readLine();
            if (number == null) {
                return null;
            }
            Integer value = Integer.parseInt(number);            
            return value;
        } catch (Exception e) {
            return null;
        }
    }
}