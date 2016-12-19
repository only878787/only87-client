package ncu.sw.renderGameUtility;

import javafx.scene.canvas.GraphicsContext;
import ncu.sw.gameUtility.GameObject;
import ncu.sw.gameUtility.Player;

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
    public String getIdentity(){
        return identity;
    }
    @Override
    public void draw (GraphicsContext ctx, Point ViewPortCenter ) {
        double x = getPosition ().x - ViewPortCenter.x-100;
        double y = getPosition ().y - ViewPortCenter.y-100;
        ctx.drawImage ( ImageUtility.playerImage , x, y);
    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Player){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
            identity = ( (Player) cmd ).getId ();
        }
    }
}
