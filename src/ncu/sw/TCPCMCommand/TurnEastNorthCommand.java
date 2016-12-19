package ncu.sw.TCPCMCommand;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by NiHao on 2016/12/17.
 */
public class TurnEastNorthCommand extends Command {

    public TurnEastNorthCommand(DataOutputStream outToServer) {
        super(outToServer);
    }

    public void execute() {
        try{
            outToServer.writeUTF("TURN "+ String.valueOf(TURNEASTNORTH));
        } catch( IOException e){
            e.printStackTrace();
        }
    }
}