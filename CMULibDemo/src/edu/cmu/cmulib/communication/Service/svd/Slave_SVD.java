package edu.cmu.cmulib.communication.Service.svd;


import edu.cmu.cmulib.communication.Macro;
import edu.cmu.cmulib.communication.Service.MasterAlgorithm;
import edu.cmu.cmulib.communication.SlaveInfo;
import edu.cmu.cmulib.communication.cmu.core.Mat;
import edu.cmu.cmulib.communication.cmu.core.MatOp;
import edu.cmu.cmulib.communication.cmu.help.Tag;
import edu.cmu.cmulib.communication.cmu.help.helper;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Slave_SVD implements Runnable {
	 private Mat L;//src;          // original L and source Matrix
	 private Tag index;
	 private Mat score;

	 public Slave_SVD(Mat score) throws RemoteException {
		 super();
		 // 	this.src = src;
	 	 this.L = null;
		 this.index = index;
		 this.score = score;

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

	public void setTag(Tag tag){ this.index = tag;}

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
			Registry registry = LocateRegistry.getRegistry("localhost", Macro.MASTER_RMIRegistry_PORT);
			MasterAlgorithm masterAlgorithm = (MasterAlgorithm)registry.lookup(MasterAlgorithm.class.getCanonicalName());
			masterAlgorithm.updateL(helper.getExpandL(L), "1");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	public static void printArray(double[] arr){
		for(double i: arr)
			System.out.print(i+" ");
		System.out.println();
	}
}
