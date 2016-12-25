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
    private double canvasX;
    private double canvasY;
    private SpriteRenderEngine sre;

    public RenderThread(){
        canvasX = GameFrameController.getInstance().getCanvas().getWidth();
        canvasY = GameFrameController.getInstance().getCanvas().getHeight();
        sre = new SpriteRenderEngine( GameFrameController.getInstance().gc );

        Thread renderThread = new Thread(() -> {
            while (true) {
                long start = System.currentTimeMillis();
                Platform.runLater(() -> procedure() );
                try {
                    Thread.sleep(50);
                } catch (InterruptedException exc) {
                    throw new Error("Unexpected interruption", exc);
                }
                long end = System.currentTimeMillis();
                GameFrameController.getInstance().getStatusBar().setText("@@@123");
            }
        });
        renderThread.setDaemon(true);
        renderThread.start();
    }

    private void procedure(){
        GameFrameController.getInstance().gc.clearRect(0, 0, canvasX, canvasY);
        SceneRenderEngine.getInstance().updateScene(
                GameModel.getInstance().getPlayerXY().x,
                GameModel.getInstance().getPlayerXY().y
        );
        sre.renderSprites();
    }
}
