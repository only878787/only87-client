package ncu.sw.RenderGameUtility;

import ncu.sw.CmdGameUtility.GameObject;
import ncu.sw.CmdGameUtility.Obstacle;

/**
 * Created by Arson on 2016/11/1.
 */
public class ObstacleR extends GameObjectR {
    public  ObstacleR(){}
    public ObstacleR ( double x,double y ) {
        super ( x,y,20,20 );
    }

    @Override
    public void draw () {
    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Obstacle){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
        }
    }
}