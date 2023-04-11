
import java.rmi.*;

public interface inter extends Remote {
    // Declaring the method prototype
    public int[][] add(int a[][], int b[][]) throws RemoteException;
}
