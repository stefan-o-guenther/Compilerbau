package compilerbau;
import java.io.File;
import java.io.FileReader;


public class Input {

    public String getText(String filename) {
        
        String text = "";
        
        FileReader fr = null;

        try {
            File file = new File(filename) ;
            int len = (int)file.length() ;
            char[] buf = new char[len] ;
    
            fr = new FileReader(file);
            fr.read(buf) ;
            text = new String(buf);
        } catch(Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                if(fr!=null) fr.close();
            } catch(Exception ex) {
                
            }
        }
        return text;
    }
}
