package ncu.sw.renderEngine;

import javafx.application.Platform;
import javafx.scene.Scene;
import ncu.sw.gameClient.DynamicObject;
import ncu.sw.gameClient.GameModel;
import ncu.sw.gameClient.StaticObject;
import ncu.sw.gui.GameFrameController;

/**
 * Created by onlyfly34 on 2016/12/12.
 */
public class RenderThread {
    public RenderThread(){
        double canvasX = GameFrameController.getInstance().getCanvas().getWidth();
        double canvasY = GameFrameController.getInstance().getCanvas().getHeight();

        SpriteRenderEngine sre = new SpriteRenderEngine( GameFrameController.getInstance().gc );
        Thread renderThread = new Thread(() -> {
            while (true) {
                GameFrameController.getInstance().gc.clearRect(0, 0, canvasX, canvasY);
                Platform.runLater(() -> SceneRenderEngine.getInstance().updateScene(
                        (int) GameModel.getInstance().getPlayerXY().x,
                        (int) GameModel.getInstance().getPlayerXY().y)
                );
                sre.renderSprites();
                //GameFrameController.getInstance().gc.clearRect(0, 0, canvasX, canvasY);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException exc) {
                    throw new Error("Unexpected interruption", exc);
                }
            }
        });
        renderThread.setDaemon(true);
        renderThread.start();
    }
}
