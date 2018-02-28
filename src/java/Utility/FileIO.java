
package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {
    public static <T> void write(String fn, T x) throws IOException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(fn);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(x);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(oos != null) oos.close();
        }
    }
    
    public static <T> T read(String fn) throws IOException {
        T x = null;
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(fn);
            ois = new ObjectInputStream(fis);
            x = (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ois != null) ois.close();
        }
        return x;
    }
}
