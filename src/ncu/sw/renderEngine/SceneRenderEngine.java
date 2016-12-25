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

    public void cxToDx(){

    }

    public void updateScene(int cx, int cy){
        GameFrameController.getInstance().position.setText("Position = "+cx+","+cy);
        //if(dx<0 || dy<0 || cx<0 || cy<0 || mapBlockX<0 || mapBlockY<0){
            //throw new IllegalArgumentException();
        //}
        System.out.println("Start painting rectangle");
        Rectangle rect = new Rectangle(50,50,400,400);
        GameFrameController.getInstance().gc.setFill(Color.WHITE);
        GameFrameController.getInstance().gc.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());

        Rectangle rect2 = new Rectangle(700,300,400,400);
        GameFrameController.getInstance().gc.setFill(Color.BLACK);
        GameFrameController.getInstance().gc.fillRect(rect2.getX(), rect2.getY(), rect2.getWidth(), rect2.getHeight());


        //int canvasX = (int)GameFrameController.getInstance().getCanvas().getWidth();
        //int canvasY = (int)GameFrameController.getInstance().getCanvas().getHeight();
        //int mapSizeX = mapBlockX*100;
        //int mapSizeY = mapBlockY*100;
        //int canvasBiasX = cx-canvasX;
        //int canvasBiasY = canvasY-300;
        //int bias = 100- GameModel.getInstance().;
        //int canvasBiasX = canvasX-500;
        //int canvasBiasY = canvasY-300;*/
        //int counter = 0;
        /*for(int i=0 ; i<mapBlockX ; i++){
            for(int j=0 ; j<mapBlockY ; j++){
                int x_buffer = dx+i*100-mapSizeX/2+canvasBiasX/2;
                int y_buffer = dy+j*100-mapSizeY/2+canvasBiasY/2;
                if(x_buffer >= -bias && x_buffer <= canvasX-DynamicObject.getInstance().getMoveSteps() &&
                y_buffer >= -bias && y_buffer <= canvasY-DynamicObject.getInstance().getMoveSteps()) { //0-75,500+75,0-75,200+75
                    GameFrameController.getInstance().gc.drawImage(StaticObject.getInstance().getImage()[StaticObject.getInstance().getMap()[j][i]], x_buffer, y_buffer);
                    counter++;
                }
            }
        }*/
        //GameFrameController.getInstance().gc.fillOval(250-8, 150, 16, 16);
        //System.out.println("DrawImage function is called "+counter+" times");
    }
}
