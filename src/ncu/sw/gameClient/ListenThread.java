package ncu.sw.gameClient;

/**
 * Created by NiHao on 2016/10/18.
 */

import java.io.*;
import java.net.*;
import java.util.Timer;

public class ListenThread implements Runnable{
    Socket cli;
    public  ListenThread( Socket cli){
        this.cli = cli;
    }
    public void run(){
        try{
            BufferedReader inFromServer = new BufferedReader(new
                    InputStreamReader(cli.getInputStream()));
            String str;
            while ( true ){
                str = inFromServer.readLine();
                System.out.println( str );
                cmd( str );
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public void cmd(String str){
        String[] token = str.split(" ");
        /*if( token[0].equals("Yes") ) {

        }*/
    }
}
