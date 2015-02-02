package edu.cmu.cmulib.communication;

import edu.cmu.cmulib.communication.Service.AlgorithmProtocol;

import edu.cmu.cmulib.communication.Service.MasterAlgorithm;
import edu.cmu.cmulib.communication.Service.MasterSVD;
import java.net.*;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import java.io.*;

import static java.rmi.registry.LocateRegistry.*;

public class MasterNode {

    ArrayList<SlaveInfo> slaveList;

    private Registry registry;  // new version

    public MasterNode(){
        slaveList = new ArrayList<SlaveInfo>();
    }

    /**
     *
     * @throws RemoteException
     * @throws UnknownHostException
     */
    public void startService() throws RemoteException, UnknownHostException {       //new version

        ArrayList<SlaveInfo> slaveInfoList = new ArrayList<SlaveInfo>();
        slaveInfoList.add(new SlaveInfo("localhost", 16645));
        MasterAlgorithm masterSVD = new MasterSVD(slaveInfoList);
        registry = createRegistry(Macro.MASTER_RMIRegistry_PORT);
        registry.rebind( MasterAlgorithm.class.getCanonicalName(), masterSVD);

    }

}
