package ncu.sw.UDPCM;

import ncu.sw.TCPCM.TCPClient;
import ncu.sw.gameClient.GameModel;
import ncu.sw.gameUtility.Cmd;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by nwlabclub on 2016/12/8.
 */
public class UDPClientThread extends Thread  {
    protected boolean check = true;
    protected DatagramSocket socket;
    private Cmd cmd;
    final  int size = 20480;
    public UDPClientThread () {
        try {
            System.out.println( "port = "+TCPClient.getInstance().getClientPort() );
            socket = new DatagramSocket( TCPClient.getInstance().getClientPort() );
        } catch ( SocketException e) {
            e.printStackTrace();
        }

        cmd = new Cmd();
    }
    public UDPClientThread(Cmd cmd) {
        this.cmd = cmd;
    }
    public  Cmd getCmd() {
        return  cmd;
    }
    public void receive () {
        try {
            byte[] incomingData = new byte[size];
            DatagramPacket packet = new DatagramPacket(incomingData, incomingData.length );
            socket.receive(packet);
            byte[] data = packet.getData();
            System.out.print(data.length);
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
        //socket.close();
    }

    public synchronized void run() {
        while (check) {
            this.receive();
        }
    }
}
