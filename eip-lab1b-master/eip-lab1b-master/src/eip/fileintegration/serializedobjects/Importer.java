package eip.fileintegration.serializedobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernestoexposito
 */
public class Importer {

    private ObjectInputStream reader;
    private String filename;
    
    public Importer(String filename) throws IOException {
       this.filename=filename;
       reader = new ObjectInputStream(new FileInputStream(filename));
    }

    public Object importObject() {
        Object result =null;
        try {
            result = reader.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Importer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Importer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
     public void close()
    {
        try {
            reader.close();
            File f = new File(filename);
            f.delete();
                    } catch (IOException ex) {
            Logger.getLogger(Importer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
