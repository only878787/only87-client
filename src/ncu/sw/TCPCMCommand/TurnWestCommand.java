package ncu.sw.TCPCMCommand;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by NiHao on 2016/12/13.
 */
public class TurnWestCommand extends Command {
    public TurnWestCommand(DataOutputStream outToServer) {
        super(outToServer);
    }

    public void execute() {
        try{
            outToServer.writeUTF("TURN "+ String.valueOf(TURNWEST));
        } catch( IOException e){
            e.printStackTrace();
        }
    }
}