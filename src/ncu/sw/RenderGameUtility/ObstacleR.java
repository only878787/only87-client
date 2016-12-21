package ncu.sw.renderGameUtility;

import javafx.scene.canvas.GraphicsContext;
import ncu.sw.gameUtility.GameObject;
import ncu.sw.gameUtility.Obstacle;

/**
 * Created by Arson on 2016/11/1.
 */
public class ObstacleR extends GameObjectR {
    public  ObstacleR(){}
    public ObstacleR ( double x,double y ) {
        super ( x,y,20,20 );
    }

    @Override
    public void draw (GraphicsContext ctx, Point ViewPortCenter ) {
        double x = getPosition ().x - ViewPortCenter.x;
        double y = getPosition ().y - ViewPortCenter.y;
        ctx.drawImage ( ImageUtility.obstacleImage , x-50, y-50);
    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Obstacle){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
        }
    }
}