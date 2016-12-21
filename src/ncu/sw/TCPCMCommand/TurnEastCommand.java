package ncu.sw.TCPCMCommand;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by NiHao on 2016/12/13.
 */
public class TurnEastCommand extends Command {
    public TurnEastCommand(DataOutputStream outToServer) {
        super(outToServer);
    }

    public void execute() {
        try{
            outToServer.writeUTF("TURN "+ String.valueOf(TURNEAST));
        } catch( IOException e){
            e.printStackTrace();
        }
    }
}