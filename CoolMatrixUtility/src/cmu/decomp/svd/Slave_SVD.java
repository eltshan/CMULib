package cmu.decomp.svd;

import cmu.core.Mat;
import cmu.core.MatOp;
import cmu.decomp.svd.Service.MasterAlgorithm;
import cmu.help.Tag;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Slave_SVD implements Runnable {
	 private Mat L;//src;          // original L and source Matrix 
	 private Tag index;
	 private Mat score;
	private Registry registry;
	 public Slave_SVD(Tag index, Mat score, Registry registry) throws RemoteException {
		 super();
		 // 	this.src = src;
	 	this.L = null;
		 this.index = index;
		 this.score = score;
		 this.registry = registry;
	 }
	 public Slave_SVD() throws RemoteException {
		 super();


	 }
    /**
     * Slave_UpdateL
     *
     * update L by using the formula L=SS(transpose)L
     */
	 public Mat Slave_UpdateL(Mat src) {
		 this.L = MatOp.gemm(src, MatOp.gemm(src.t(), this.L));
		 return this.L;
	 }
	 
    /**
     * setL
     *
     * set L after receiving from master
     */
	 public void setL(Mat L){
		 this.L = L;
	 }
    /**
     * setS
     *
     * set matrix after reconstructing based on tag
     */
	 public void setS(Mat S){
		// this.src = S;
	 }

	@Override
	public void run() {
		Slave_getSplitedMatrix split = new Slave_getSplitedMatrix(score);
		split.setTag(index);
		Mat S = split.construct();
		L = this.Slave_UpdateL(S);
		try {
			MasterAlgorithm masterAlgorithm = (MasterAlgorithm)registry.lookup(MasterAlgorithm.class.getCanonicalName());
			masterAlgorithm
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}
}
