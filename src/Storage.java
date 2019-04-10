import java.io.*;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.List;

public class Storage implements Serializable {

    public Storage() {
    }
    public void saveConfig(Planet[] druchy){
        try {
            FileOutputStream fos = new FileOutputStream("Konfiguracja.txt");
            ObjectOutputStream objOps = new ObjectOutputStream(fos);

            for (Planet p : druchy) {
                System.out.println(p);
                objOps.writeObject(p);

            }
            objOps.flush();
            objOps.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
