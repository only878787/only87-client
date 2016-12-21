package ncu.sw.TCPCMCommand;

import java.io.DataOutputStream;

/**
 * Created by NiHao on 2016/12/12.
 */
public abstract class Command {
    public final static int TURNEAST = 0;
    public final static int TURNSOUTH = 1;
    public final static int TURNNORTH = 2;
    public final static int TURNWEST = 3;
    public final static int GET = 4;
    public final static int TURNEASTNORTH = 5;
    public final static int TURNEASTSOUTH = 6;
    public final static int TURNWESTNORTH = 7;
    public final static int TURNWESTSOUTH = 8;
    public final static int DISCONNECT = 9;

    protected DataOutputStream outToServer;
    public Command(DataOutputStream outToServer){
        this.outToServer = outToServer;
    }
    public abstract void execute();
}





