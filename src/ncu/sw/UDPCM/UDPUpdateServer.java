package ncu.sw.UDPCM;

import ncu.sw.gameUtility.Cmd;


public class UDPUpdateServer {
    private static UDPUpdateServer ourInstance = null;
    private UDPClientThread udpClientThread;

    private UDPUpdateServer() {
        initUDPServer();
    }

    private void initUDPServer() {
        udpClientThread = new UDPClientThread();
        udpClientThread.start();
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