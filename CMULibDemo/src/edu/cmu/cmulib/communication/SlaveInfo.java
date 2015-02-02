package edu.cmu.cmulib.communication;

import java.net.InetAddress;

/**
 * Created by kanghuang on 1/30/15.
 */
public class SlaveInfo {
    private String address;
    private int port;
    private int slaveID;
    /**
     * Constructor for slave node
     *
     * @param id      slave identifier
     * @param address slave IP adress
     * @param port    slave socket port
     */
    public SlaveInfo(int id, String address, int port) {
        this.slaveID = id;
        this.address = address;
        this.port = port;
    }

    /**
     * Constructor for slave node
     *
     * @param address slave identifier
     * @param port    slave socket port
     */
    public SlaveInfo(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPortString() {
        return "" + this.port;
    }

    public int getPort(){return this.port;}

}
