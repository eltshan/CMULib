package edu.cmu.cmulib.communication.Service;

import edu.cmu.cmulib.communication.Service.svd.Master_SVD;
import edu.cmu.cmulib.communication.Service.svd.Master_Spliter;


import edu.cmu.cmulib.communication.SlaveInfo;
import edu.cmu.cmulib.communication.cmu.core.Mat;
import edu.cmu.cmulib.communication.cmu.core.MatOp;
import edu.cmu.cmulib.communication.cmu.help.Tag;
import edu.cmu.cmulib.communication.cmu.help.helper;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Created by kanghuang on 1/30/15.
 */
public class MasterSVD extends UnicastRemoteObject implements MasterAlgorithm {
    int slaveNum;
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
    HashSet<String> hash = new HashSet<String>();
    public MasterSVD(ArrayList<SlaveInfo> slaveList) throws RemoteException {
        super();
        this.slaveList = slaveList;
        this.slaveNum = slaveList.size();
    }

    public void config()throws RemoteException{

        createAlgorithmList();
        this.score = score;
        this.svd = new Master_SVD(score, slaveNum);
        split = new Master_Spliter(score, slaveNum);
        Like = svd.initL();
        for (int i = 0; i < slaveNum; i++) {
            SlaveAlgorithm slaveAlgorithm = algorithmList.get(i);
            slaveAlgorithm.setL(helper.getExpandL(this.Like));
        }
    }


    public boolean updateL(Double[] L, String id)throws RemoteException{
        hash.add(id);

        svd.update_SVD(helper.getMat(L));

        return true;
    }

    public void waitReady(){
        while(hash.size() < slaveList.size()){
            System.out.println("wait! ");
        };

        hash.clear();
    }

    public void start() throws RemoteException{
        // compute the first eigenvector iterately
        int round = 0 ;
        do {
            System.out.println(round++);
            svd.setL(Like);
           // printArray(Like.data);
            // send L
            for (int i = 0; i < slaveNum; i++){
                SlaveAlgorithm slaveAlgorithm = algorithmList.get(i);
                slaveAlgorithm.setL(helper.getExpandL(this.Like));
            }
            //send Tag
            ArrayList<Tag> index = split.split();
            for(int i = 0; i < index.size(); i++) {
                tag = index.get(i);
                SlaveAlgorithm slaveAlgorithm = algorithmList.get(i);
                slaveAlgorithm.start(tag);
            }
            //printArray(Like.data);
            this.waitReady();
            Like = svd.getUpdateL();
            printArray(Like.data);
            MatOp.vectorNormalize(Like, MatOp.NormType.NORM_L2);
        } while (!svd.isPerformed(Like));     //termination of iteration
        System.out.println("final  " + round);
        printArray(Like.data);
    }

    public static void printArray(double[] arr){
        for(double i: arr)
            System.out.print(i+" ");
        System.out.println();
    }

    public void createAlgorithmList(){
        algorithmList = new ArrayList<SlaveAlgorithm>();
        for (SlaveInfo info : slaveList) {
            try {
               // System.out.println(info.getAddress() + " " + info.getPort());
                Registry registry = LocateRegistry.getRegistry("127.0.0.1", info.getPort());
                SlaveAlgorithm slaveAlgorithm = (SlaveAlgorithm) registry.lookup(SlaveAlgorithm.class.getCanonicalName());
                this.algorithmList.add(slaveAlgorithm);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    }

}
