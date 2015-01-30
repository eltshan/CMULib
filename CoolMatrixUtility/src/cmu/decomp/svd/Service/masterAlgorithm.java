package cmu.decomp.svd.Service;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * Created by kanghuang on 1/29/15.
 */
public abstract class MasterAlgorithm extends UnicastRemoteObject implements AlgorithmProtocol {

    protected MasterAlgorithm() throws RemoteException {

    }
}
