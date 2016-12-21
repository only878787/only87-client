package ncu.sw.renderEngine;

import javafx.application.Platform;
import ncu.sw.gameClient.DynamicObject;
import ncu.sw.gameClient.StaticObject;
import ncu.sw.gui.GameFrameController;

/**
 * Created by onlyfly34 on 2016/12/12.
 */
public class RenderThread {
    public RenderThread(){
        SpriteRenderEngine sre = new SpriteRenderEngine( GameFrameController.getInstance().gc );
        Thread renderThread = new Thread(() -> {
            while (true) {
                /*Platform.runLater(() -> SceneRenderEngine.getInstance().updateScene(DynamicObject.getInstance().getDrawCoordinateX(),
                                                                                  DynamicObject.getInstance().getDrawCoordinateY(),
                                                                                  DynamicObject.getInstance().getCharacterCoordinateX(),
                                                                                  DynamicObject.getInstance().getCharacterCoordinateY(),
                                                                                  StaticObject.getInstance().getMapBlockX(),
                                                                                  StaticObject.getInstance().getMapBlockY()));*/
                sre.renderSprites();
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
