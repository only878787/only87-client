package ncu.sw.TCPCMCommand;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by NiHao on 2016/12/13.
 */
public class GETCommand extends Command {

    public GETCommand(DataOutputStream outToServer) {
        super(outToServer);
    }

    public void execute() {
        try{
            outToServer.writeUTF("GET "+ String.valueOf(GET));
        } catch( IOException e){
            e.printStackTrace();
        }
    }
}
