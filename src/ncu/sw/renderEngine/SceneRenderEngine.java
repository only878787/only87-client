package ncu.sw.renderEngine;

import ncu.sw.gameClient.DynamicObject;
import ncu.sw.gameClient.StaticObject;
import ncu.sw.gui.GameFrameController;

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

    public void updateScene(int dx, int dy, int cx, int cy, int mapBlockX, int mapBlockY){
        if(dx<0 || dy<0 || cx<0 || cy<0 || mapBlockX<0 || mapBlockY<0){
            throw new IllegalArgumentException();
        }
        System.out.println("Start rendering");
        int mapSizeX = mapBlockX*100;
        int mapSizeY = mapBlockY*100;
        int bias = 100-DynamicObject.getInstance().getMoveSteps();
        int canvasX = (int)GameFrameController.getInstance().getCanvas().getWidth();
        int canvasY = (int)GameFrameController.getInstance().getCanvas().getHeight();
        int canvasBiasX = canvasX-500;
        int canvasBiasY = canvasY-300;
        GameFrameController.getInstance().gc.clearRect(0, 0, canvasX, canvasY);
        int counter = 0;
        for(int i=0 ; i<mapBlockX ; i++){
            for(int j=0 ; j<mapBlockY ; j++){
                int x_buffer = dx+i*100-mapSizeX/2+canvasBiasX/2;
                int y_buffer = dy+j*100-mapSizeY/2+canvasBiasY/2;
                if(x_buffer >= -bias && x_buffer <= canvasX-DynamicObject.getInstance().getMoveSteps() &&
                y_buffer >= -bias && y_buffer <= canvasY-DynamicObject.getInstance().getMoveSteps()) { //0-75,500+75,0-75,200+75
                    GameFrameController.getInstance().gc.drawImage(StaticObject.getInstance().getImage()[StaticObject.getInstance().getMap()[j][i]], x_buffer, y_buffer);
                    counter++;
                }
            }
        }
        GameFrameController.getInstance().position.setText("Position = "+cx+","+cy);
        //GameFrameController.getInstance().gc.fillOval(250-8, 150, 16, 16);
        System.out.println("DrawImage function is called "+counter+" times");
    }
}
