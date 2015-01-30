package cmu.decomp.svd.Service;

import cmu.core.Mat;
import cmu.decomp.svd.Slave_getSplitedMatrix;

import java.rmi.RemoteException;

/**
 * Created by kanghuang on 1/30/15.
 */
public class SlaveSVD extends SlaveAlgorithm{


    Mat S, L;
    Slave_getSplitedMatrix split;
    public SlaveSVD() throws RemoteException {
        double[] test = {6,8,9,6,2,9,7,7,8,5,8,7,4,8,6,8,5,4,7,3,5,9,8,6,9,6,7,8,6,6,6,8};
        int rows = 8;
        int cols = 4;
        Mat score = new Mat(rows, cols ,test);
        split = new Slave_getSplitedMatrix(score);
    }

    public boolean setL(){

        return true;
    }

    public


}
