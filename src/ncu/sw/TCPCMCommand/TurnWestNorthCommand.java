package ncu.sw.TCPCMCommand;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by NiHao on 2016/12/17.
 */
public class TurnWestNorthCommand extends Command {

    public TurnWestNorthCommand(DataOutputStream outToServer) {
        super(outToServer);
    }

    public void execute() {
        try{
            outToServer.writeUTF("TURN "+ String.valueOf(TURNWESTNORTH));
        } catch( IOException e){
            e.printStackTrace();
        }
    }
}