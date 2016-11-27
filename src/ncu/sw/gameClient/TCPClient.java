package ncu.sw.gameClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by NiHao on 2016/11/16.
 */

public class TCPClient {
    private InetAddress add;
    private SocketAddress isa;
    private Socket clientSocket;
    private int port;
    private DataOutputStream outToServer;


    public TCPClient(int port ){
        this.port = port;
    }

    public void connectServer( ){
        try {
            add = InetAddress.getByName("localhost");
            isa= new InetSocketAddress( add, port );
            clientSocket = new Socket();
            int timeout = 2000 ; //timeout 2秒

            clientSocket.connect(isa,timeout);
            System.out.println(clientSocket.getLocalAddress() + "連線到" + clientSocket.getInetAddress());

            /* create listen thread */
            new Thread( new ListenThread(clientSocket) ).start();

            /* DataOutputStream */
            outToServer = new DataOutputStream(clientSocket.getOutputStream());

        } catch ( IOException e ){
            e.printStackTrace();
        }
    }

    public void sendUTFStrToServer( String str ){
        try{
            outToServer.writeUTF(str);
        } catch( IOException e){
            e.printStackTrace();
        }
    }

}
