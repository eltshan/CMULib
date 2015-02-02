package edu.cmu.cmulib.communication.Service;


import java.rmi.RemoteException;


/**
 * Created by kanghuang on 1/29/15.
 */
public interface MasterAlgorithm extends AlgorithmProtocol {

    public boolean updateL(Double[] L, String id) throws RemoteException;
    public void start() throws RemoteException;
    public void config() throws RemoteException;
}
