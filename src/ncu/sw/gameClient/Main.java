package ncu.sw.gameClient;
/**
 * Created by NiHao on 2016/10/18.
 */

import ncu.sw.gui.GameApp;
import ncu.sw.renderEngine.RenderThread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;

public class Main{
    public static void main( String[] args ) throws IOException {
        GameApp.launch( GameApp.class );
    }
}