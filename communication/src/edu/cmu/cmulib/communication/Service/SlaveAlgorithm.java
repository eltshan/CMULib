package edu.cmu.cmulib.communication.Service;



import edu.cmu.cmulib.communication.cmu.core.Mat;
import edu.cmu.cmulib.communication.cmu.help.Tag;

import java.rmi.RemoteException;

/**
 * Created by kanghuang on 1/29/15.
 */
public interface SlaveAlgorithm extends AlgorithmProtocol {


    public boolean setL(Mat L) throws RemoteException;

    public void start(Tag tag) throws RemoteException;

}
