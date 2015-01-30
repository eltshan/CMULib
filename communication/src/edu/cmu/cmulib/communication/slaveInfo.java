package edu.cmu.cmulib.communication;

import java.net.InetAddress;

/**
 * Created by kanghuang on 1/30/15.
 */
public class SlaveInfo {
    private InetAddress address;
    private int port;
    private int slaveID;
    /**
     * Constructor for slave node
     *
     * @param id      slave identifier
     * @param address slave IP adress
     * @param port    slave socket port
     */
    public SlaveInfo(int id, InetAddress address, int port) {
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
    public SlaveInfo(InetAddress address, int port) {
        this.address = address;
        this.port = port;
    }

    public String getAddress() {
        return this.address.getHostAddress();
    }

    public String getPortString() {
        return "" + this.port;
    }

}
