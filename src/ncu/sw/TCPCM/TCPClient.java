package ncu.sw.TCPCM;

/**
 * Created by NiHao on 2016/11/26.
 */

import ncu.sw.TCPCMCommand.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;

public class TCPClient {

    private SocketAddress isa;
    private Socket clientSocket;
    private int port;
    private DataOutputStream outToServer;

    private HashMap<Integer, Command> commandMap;
    private static TCPClient tcpClient;
    protected Command command;

    private TCPClient( int port ){
        this.port = port;
    }

    public static TCPClient getInstance(){
        if( tcpClient == null )
            tcpClient = new TCPClient( 9487 );
        return tcpClient;
    }

    public boolean connectServer( InetAddress serverIP ){
        try {
            isa= new InetSocketAddress( serverIP, port );
            clientSocket = new Socket();
            int timeout = 2000 ; //timeout 2秒

            clientSocket.connect(isa,timeout);
            System.out.println(clientSocket.getLocalAddress() + "連線到" + clientSocket.getInetAddress());

            /* DataOutputStream */
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            /* init command map */
            initMap();

            return true;

        } catch ( IOException e ){
            System.out.println("connectServer IOException : " + e );
            //e.printStackTrace();
            return false;
        }
    }

    public void sendClientIdentity( String identity ){
        sendMsg("IDENTITY " + identity );
    }

    public void sendMsg(String str){
        try{
            outToServer.writeUTF(str);
        } catch( IOException e){
            e.printStackTrace();
        }
    }

    public void inputMoves(int MoveCode){
        command = commandMap.get( MoveCode );
        if( command != null )
            command.execute();
    }

    private void initMap(){
        commandMap = new HashMap<Integer, Command>();
        commandMap.put( Command.GET, new GETCommand(outToServer) );
        commandMap.put( Command.TURNWEST, new TurnWestCommand(outToServer) );
        commandMap.put( Command.TURNEAST, new TurnEastCommand(outToServer) );
        commandMap.put( Command.TURNNORTH, new TurnNorthCommand(outToServer) );
        commandMap.put( Command.TURNSOUTH, new TurnSouthCommand(outToServer) );
        commandMap.put( Command.TURNEASTNORTH, new TurnEastNorthCommand(outToServer) );
        commandMap.put( Command.TURNEASTSOUTH, new TurnEastSouthCommand(outToServer) );
        commandMap.put( Command.TURNWESTNORTH, new TurnWestNorthCommand(outToServer) );
        commandMap.put( Command.TURNWESTSOUTH, new TurnWestSouthCommand(outToServer) );
        commandMap.put( Command.DISCONNECT, new DisconnectCommand(outToServer) );

    }

    public void connectClose() throws IOException {
        inputMoves( Command.DISCONNECT );
        clientSocket.close();
    }

    public int getClientPort() {
        if( clientSocket == null ){
            return -1;
        }
        return clientSocket.getLocalPort();
    }

}
