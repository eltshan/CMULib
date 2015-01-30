package edu.cmu.cmulib.communication.Service;

import cmu.core.Mat;
import cmu.core.MatOp;
import edu.cmu.cmulib.communication.Service.svd.Master_SVD;
import edu.cmu.cmulib.communication.Service.svd.Master_Spliter;
import cmu.help.Tag;

import edu.cmu.cmulib.communication.SlaveInfo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by kanghuang on 1/30/15.
 */
public class MasterSVD extends UnicastRemoteObject implements MasterAlgorithm {
    int slaveNum = 4;
    double[] test = {6,8,9,6,2,9,7,7,8,5,8,7,4,8,6,8,5,4,7,3,5,9,8,6,9,6,7,8,6,6,6,8};
    int rows = 8;
    int cols = 4;
    Mat score = new Mat(rows, cols ,test);
    Tag tag;
    Mat Like, slaveL;
    Master_SVD svd;            //rmi masterSVD共用一个Master_SVD
    Master_Spliter split;
    ArrayList<SlaveInfo> slaveList;
    ArrayList<SlaveAlgorithm> algorithmList;
    public MasterSVD(ArrayList<SlaveInfo> slaveList) throws RemoteException {
        this.slaveList = slaveList;
    }

    public Mat submit(Mat score, int slaveNum) {
        this.score = score;
        this.slaveNum = slaveNum;
        this.svd = new Master_SVD(score, slaveNum);
        split = new Master_Spliter(score, slaveNum);
        Like = svd.initL();
        for (int i = 0; i < slaveNum; i++) {
            // SlaveAlgorithm SlaveSvd =
            //  sendMat(Like,i,commu);
        }
        return this.Like;
    }

    public boolean updateL(Mat L){
        svd.update_SVD(L);
        return true;
    }

    public void start(){
        // compute the first eigenvector iterately
        createAlgorithmList();
        do {
            int remain = slaveNum;
            svd.setL(Like);
            printArray(Like.data);
            // send L
            for (int i = 0; i < slaveNum; i++){
                SlaveAlgorithm slaveAlgorithm = algorithmList.get(i);
                slaveAlgorithm.setL(this.Like);
            }
            //send Tag
            ArrayList<Tag> index = split.split();
            for(int i = 0; i < index.size(); i++) {
                tag = index.get(i);
                SlaveAlgorithm slaveAlgorithm = algorithmList.get(i);
                slaveAlgorithm.start(tag);
            }

            Like = svd.getUpdateL();
            MatOp.vectorNormalize(Like, MatOp.NormType.NORM_L2);
        } while (!svd.isPerformed(Like));     //termination of iteration
        System.out.println("final  ");
        printArray(Like.data);
    }

    public static void printArray(double[] arr){
        for(double i: arr)
            System.out.print(i+" ");
        System.out.println();
    }

    public void createAlgorithmList(){
        for (SlaveInfo info : slaveList) {
            try {
                SlaveAlgorithm slaveAlgorithm = (SlaveAlgorithm) LocateRegistry.getRegistry(info.getAddress(), info.getPort());
                this.algorithmList.add(slaveAlgorithm);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

}
