package edu.cmu.cmulib.communication;

import edu.cmu.cmulib.communication.Service.MasterAlgorithm;
import edu.cmu.cmulib.communication.cmu.core.Mat;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by kanghuang on 1/30/15.
 */
public class Client {
    public static void main(String argv[]){
        double[] test = {6,8,9,6,2,9,7,7,8,5,8,7,4,8,6,8,5,4,7,3,5,9,8,6,9,6,7,8,6,6,6,8};
        int rows = 8;
        int cols = 4;
        Mat score = new Mat(rows, cols ,test);
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", Macro.MASTER_RMIRegistry_PORT);
            MasterAlgorithm SVD = (MasterAlgorithm)registry.lookup(MasterAlgorithm.class.getCanonicalName());
            SVD.config(score);
            SVD.start();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
