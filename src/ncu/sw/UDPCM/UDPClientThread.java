package ncu.sw.UDPCM;


import ncu.sw.gameClient.GameModel;
import ncu.sw.gameUtility.Cmd;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.TimerTask;

/**
 * Created by nwlabclub on 2016/12/8.
 */
public class UDPClientThread extends Thread {
    protected boolean check = true;
    protected DatagramSocket socket;
    private DatagramPacket packet;
    byte [] tests = new byte[0];
    private Cmd cmd;
    final  int size = 20480;
    private InetAddress address;
    public UDPClientThread () {
        try {
            address = InetAddress.getByName("140.115.59.83");
            socket = new DatagramSocket();
            packet = new DatagramPacket(tests, tests.length,address,5000);
            socket.send(packet);
            System.out.print("I send the test\n");
        } catch ( SocketException e) {
            e.printStackTrace();
        } catch (IOException e ){
            e.printStackTrace();
        }
        cmd = new Cmd();
    }
    public  Cmd getCmd() {
        return  cmd;
    }
    public void receive () {
        try {
            byte[] incomingData = new byte[size];
            packet.setData(incomingData);
            packet.setLength(size);
            socket.receive(packet);
            byte[] data = packet.getData();

            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);
            try {
                cmd = (Cmd) is.readObject();
                GameModel.getInstance().update( cmd );
                //System.out.println(" object received = "+cmd);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                check = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            check = false;
        }
    }
    public synchronized void run() {
        while (check) {
            this.receive();
        }
        socket.close();
    }
}
