package edu.cmu.cmulib.communication.cmu.help;

import edu.cmu.cmulib.communication.cmu.core.Mat;

/**
 * Created by kanghuang on 1/31/15.
 */
public class helper {
    public static Mat getMat(Double[] temp){

        double row = temp[0];
        double col = temp[1];
        double [] arr = new double[temp.length-2];
        for(int k=0;k<arr.length;k++){
            arr[k] = temp[k+2];
        }
        Mat mat = new Mat((int)row,(int)col,arr);
        return mat;
    }

    public static Mat getExpandL(Mat temp){

    }

}
