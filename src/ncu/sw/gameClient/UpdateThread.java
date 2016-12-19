package ncu.sw.gameClient;

import javafx.application.Platform;
import ncu.sw.UDPCM.UDPUpdateServer;

/**
 * Created by onlyfly34 on 2016/12/17.
 */
public class UpdateThread {
    public UpdateThread(){
        Thread updateThread = new Thread(() -> {
            Platform.runLater(() -> GameModel.getInstance().update(UDPUpdateServer.getInstance().getCmd()));
        });
        updateThread.setDaemon(true);
        updateThread.start();
    }
}
