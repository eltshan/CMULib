package edu.cmu.cmulib.communication;

import edu.cmu.cmulib.communication.Service.AlgorithmProtocol;
import edu.cmu.cmulib.communication.Service.SlaveAlgorithm;
import edu.cmu.cmulib.communication.Service.SlaveSVD;

import java.net.*;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SlaveNode {

    private Registry registry;

    public SlaveNode() {

    }
    public void startService() throws RemoteException, UnknownHostException{
        SlaveAlgorithm slaveSVD = new SlaveSVD();
        registry = LocateRegistry.createRegistry(16645);
        registry.rebind(SlaveAlgorithm.class.getCanonicalName(), slaveSVD);
    }
}
