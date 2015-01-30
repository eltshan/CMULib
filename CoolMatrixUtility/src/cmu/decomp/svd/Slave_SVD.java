package cmu.decomp.svd;

import cmu.core.Mat;
import cmu.core.MatOp;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Slave_SVD  {
	 private Mat L;//src;          // original L and source Matrix 

	 public Slave_SVD(Mat src) throws RemoteException {
		 super();
		 // 	this.src = src;
	 	this.L = null;
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
}
