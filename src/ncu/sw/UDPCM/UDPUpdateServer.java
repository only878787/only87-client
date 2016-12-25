package ncu.sw.UDPCM;

import ncu.sw.gameUtility.Cmd;

import java.util.Calendar;
import java.util.Timer;


public class UDPUpdateServer {
    private static UDPUpdateServer ourInstance = null;
    private UDPClientThread udpClientThread;
    private Timer timer;

    private UDPUpdateServer() {
        initUDPServer();
    }

    private void initUDPServer() {
        udpClientThread = new UDPClientThread();
        timer = new Timer();
        udpClientThread.start();
       // timer.schedule(udpClientThread, Calendar.getInstance().getTime(),5000);
    }
    public static UDPUpdateServer getInstance() {
        if( ourInstance == null ){
            synchronized ( UDPClientThread.class ) {
                if( ourInstance == null ){
                    ourInstance = new UDPUpdateServer();
                }
            }
        }
        return ourInstance;
    }
    public Cmd getCmd () {
        return  this.udpClientThread.getCmd();
    }

}