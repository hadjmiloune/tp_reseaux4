
// Java program for server application
import java.rmi.*;
import java.rmi.registry.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class server {
    static ArrayList<utilisateur> users = new ArrayList<>();

    public static void main(String args[]) {

        ///

        Socket client = new Socket();
        ;

        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream inp = new ObjectInputStream(client.getInputStream());
        utilisateur ut = (utilisateur) inp.readObject();

        for (int i = 0; i < users.size(); i++) {
            if (ut.id.equals(users.get(i).id)) {
                if (ut.pass.equals(users.get(i).pass)) {
                    continue;
                } else {
                    inp.close();
                    out.close();
                    break;
                }
            } else {
                users.add(ut);
            }
            ///

            try {

                inter obj = new impls();

                // rmiregistry within the server JVM with
                // port number 1900
                LocateRegistry.createRegistry(1900);

                Naming.rebind("rmi://localhost:1900" +
                        "/hadj", obj);
            } catch (Exception ae) {
                System.out.println(ae);
            }
        }
    }
}