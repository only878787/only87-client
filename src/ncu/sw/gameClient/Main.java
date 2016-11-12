package ncu.sw.gameClient;

/**
 * Created by NiHao on 2016/10/18.
 */

import java.io.*;
import java.net.*;

public class Main{
    public static void main(String [] argv)throws IOException {
        StartClient(9000);
    }

    public static void StartClient(int port)
    {
        try {
            //設定連線的主機位置
            InetAddress add = InetAddress.getByName("localhost");
            SocketAddress isa= new InetSocketAddress(add,port);
            Socket clientSocket = new Socket();
            int timeout = 2000 ; //timeout 2秒

            clientSocket.connect(isa,timeout);
            System.out.println(clientSocket.getLocalAddress() + "連線到" + clientSocket.getInetAddress());

            //傳送資料到Server端
            DataOutputStream outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));
            new Thread( new ListenThread(clientSocket) ).start();

            String str;
            /* User Input */
            while ( true ) {
                str = inFromUser.readLine();
                outToServer.writeUTF(str);
            }
        } catch(SocketTimeoutException e) {
            System.out.println("Timeout");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
