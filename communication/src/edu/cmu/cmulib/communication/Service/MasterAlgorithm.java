package edu.cmu.cmulib.communication.Service;
import cmu.core.Mat;

import java.rmi.RemoteException;


/**
 * Created by kanghuang on 1/29/15.
 */
public interface MasterAlgorithm extends AlgorithmProtocol {

    public boolean updateL(Mat L) throws RemoteException;
    public void start() throws RemoteException;
    public void config(Mat score) throws RemoteException;
}
