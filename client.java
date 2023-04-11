
// Java program for client application
import java.rmi.*;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class client {
    public static void main(String args[]) {
        int arr1[][] = { { 95, 105 }, { 1, 2 } };
        int arr2[][] = { { -1, -1 }, { -1, -1 } };
        int answer[][] = new int[arr1.length][arr1.length];
        ///
        utilisateur uti1 = new utilisateur("2", "123");
        int port = 9999;
        String host = "localhost";

        Socket client = new Socket(host, port);

        ObjectInputStream inp = new ObjectInputStream(client.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

        out.writeObject(uti1);
        client.close();
        ///

        try {

            inter access = (inter) Naming.lookup("rmi://localhost:1900" +
                    "/hadj");
            answer = access.add(arr1, arr2);
            System.out.println("the result is : ");
            for (int row = 0; row < answer.length; row++) {
                for (int col = 0; col < answer[row].length; col++) {
                    System.out.println(answer[row][col]);
                }
                System.out.println("\n");
            }

        } catch (Exception ae) {
            System.out.println(ae);
        }
    }
}
