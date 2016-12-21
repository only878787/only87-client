package ncu.sw.TCPCMCommand;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by NiHao on 2016/12/13.
 */
public class TurnNorthCommand extends Command {
    public TurnNorthCommand(DataOutputStream outToServer) {
        super(outToServer);
    }

    public void execute() {
        try{
            outToServer.writeUTF("TURN "+ String.valueOf(TURNNORTH));
        } catch( IOException e){
            e.printStackTrace();
        }
    }
}