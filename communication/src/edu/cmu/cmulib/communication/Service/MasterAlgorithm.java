package edu.cmu.cmulib.communication.Service;
import cmu.core.Mat;


/**
 * Created by kanghuang on 1/29/15.
 */
public interface MasterAlgorithm extends AlgorithmProtocol {

    public boolean updateL(Mat L);
    public void start();
}
