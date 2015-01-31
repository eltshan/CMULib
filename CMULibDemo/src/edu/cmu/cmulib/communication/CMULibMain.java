package edu.cmu.cmulib.communication;

/**
 * Created by kanghuang on 1/30/15.
 */
public class CMULibMain {
    public static void main(String[] args) throws Exception {
        if(args.length == 0) {
          System.out.println("Wrong arguments for main function");
        }else if(args[0].equals("master")){
            //start master
            MasterNode master = new MasterNode();
            master.startService();
            //System.out.println("finish");
        }else if(args[0].equals("slave")){
            SlaveNode slave = new SlaveNode();
            slave.startService();
        }
    }
}
