package edu.cmu.cmulib.communication.Service;

import cmu.core.Mat;
import cmu.help.Tag;

/**
 * Created by kanghuang on 1/29/15.
 */
public interface SlaveAlgorithm extends AlgorithmProtocol {


    public boolean setL(Mat L);

    public void start(Tag tag);

}
