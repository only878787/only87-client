package ncu.sw.TCPCMCommand;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by NiHao on 2016/12/17.
 */
public class DisconnectCommand extends Command {

    public DisconnectCommand(DataOutputStream outToServer) {
        super(outToServer);
    }

    public void execute() {
        try{
            outToServer.writeUTF("DISCONNECT "+ String.valueOf(DISCONNECT) );
        } catch( IOException e){
            e.printStackTrace();
        }
    }
}