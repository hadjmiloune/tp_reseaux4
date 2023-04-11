
// Java program to implement the Search interface
import java.rmi.*;
import java.rmi.server.*;

public class impls extends UnicastRemoteObject
        implements inter {

    impls() throws RemoteException {
        super();
    }

    // Implementation of the query interface
    public int[][] add(int a[][], int b[][])
            throws RemoteException {
        int r[][] = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                r[i][j] = a[i][j] + b[i][j];

            }

        }
        return r;
    }
}
