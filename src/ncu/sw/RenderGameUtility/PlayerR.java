package ncu.sw.RenderGameUtility;

import ncu.sw.CmdGameUtility.GameObject;
import ncu.sw.CmdGameUtility.Player;

/**
 * Created by Arson on 2016/11/1.
 */
public class PlayerR extends GameObjectR {

    private String identity;
    public PlayerR(){}
    public PlayerR ( double x,double y,String id){
        super(x,y,20,20);
        identity = id;
    }
    @Override
    public void draw(){

    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Player){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
            identity = ( (Player) cmd ).getId ();
        }
    }
}
