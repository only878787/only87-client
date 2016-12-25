package ncu.sw.renderEngine;

import ncu.sw.gameClient.DynamicObject;
import ncu.sw.gameClient.GameModel;
import ncu.sw.gameClient.StaticObject;
import ncu.sw.gui.GameFrameController;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * Created by onlyfly34 on 2016/12/12.
 */
public class SceneRenderEngine {
    private static SceneRenderEngine instance = null;
    private SceneRenderEngine() {

    }

    public static SceneRenderEngine getInstance() {
        if( instance == null ){
            synchronized ( SceneRenderEngine.class ) {
                if( instance == null ){
                    instance = new SceneRenderEngine();
                }
            }
        }
        return instance;
    }

    public void updateScene(double cx, double cy){
        double dx = 0;
        double dy = 0;
        double rectangleWidth;
        double rectangleHeight;
        double canvasWidth = GameFrameController.getInstance().getCanvas().getWidth();
        double canvasHeight = GameFrameController.getInstance().getCanvas().getHeight();

        if(cx<0 || cy<0){
            throw new IllegalArgumentException();
        }

        /** Check x-coordinate viewport **/
        if( cx-canvasWidth/2 < 0 ){
            dx = canvasWidth/2 - cx;
            rectangleWidth = canvasWidth - dx;
        }
        else if ( cx+canvasWidth/2 > 5000){
            rectangleWidth = canvasWidth/2 + (5000-cx);
        }
        else{
            rectangleWidth = canvasWidth;
        }

        /** Check y-coordinate viewport **/
        if( cy-canvasHeight/2 < 0 ){
            dy = canvasHeight/2 - cy;
            rectangleHeight = canvasHeight - dy;
        }
        else if ( cy+canvasHeight/2 > 3000){
            rectangleHeight = canvasHeight/2 + ( 3000-cy );
        }
        else{
            rectangleHeight = canvasHeight;
        }

        //Update current location of virtual character.
        GameFrameController.getInstance().getPositionLabel().setText("Position = "+cx+","+cy);

        //Draw white rectangle as background scene.
        Rectangle rect = new Rectangle( dx, dy, rectangleWidth, rectangleHeight );
        GameFrameController.getInstance().gc.save();
        GameFrameController.getInstance().gc.setFill(Color.WHITE);
        GameFrameController.getInstance().gc.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
        GameFrameController.getInstance().gc.restore();
    }
}
