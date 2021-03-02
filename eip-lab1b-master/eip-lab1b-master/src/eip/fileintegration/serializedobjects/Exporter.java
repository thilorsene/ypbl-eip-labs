package eip.fileintegration.serializedobjects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
/**
 *
 * @author ernestoexposito
 */
public class Exporter {
private ObjectOutputStream writer;
    public Exporter(String filename) throws IOException {
        writer =  new ObjectOutputStream(new FileOutputStream(filename));
    }

    public void exportObject(Object data) {
    try {
        writer.writeObject(data);
        writer.flush();
    } catch (IOException ex) {
        Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void close()
    {
    try {
        writer.close();
    } catch (IOException ex) {
        Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

}

