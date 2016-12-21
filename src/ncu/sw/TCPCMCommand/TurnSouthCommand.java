package ncu.sw.TCPCMCommand;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by NiHao on 2016/12/13.
 */
public class TurnSouthCommand extends Command {
    public TurnSouthCommand(DataOutputStream outToServer) {
        super(outToServer);
    }

    public void execute() {
        try{
            outToServer.writeUTF("TURN "+ String.valueOf(TURNSOUTH));
        } catch( IOException e){
            e.printStackTrace();
        }
    }
}