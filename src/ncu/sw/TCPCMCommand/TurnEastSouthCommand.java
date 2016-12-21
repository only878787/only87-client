package ncu.sw.TCPCMCommand;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by NiHao on 2016/12/17.
 */
public class TurnEastSouthCommand extends Command {

    public TurnEastSouthCommand(DataOutputStream outToServer) {
        super(outToServer);
    }

    public void execute() {
        try{
            outToServer.writeUTF("TURN "+ String.valueOf(TURNEASTSOUTH) );
        } catch( IOException e){
            e.printStackTrace();
        }
    }
}