package ncu.sw.renderGameUtility;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.TextAlignment;
import ncu.sw.gameUtility.GameObject;
import ncu.sw.gameUtility.Player;

/**
 * Created by Arson on 2016/11/1.
 */
public class PlayerR extends GameObjectR {

    private String identity;
    private int point;
    public PlayerR(){}
    public PlayerR ( double x,double y,String id){
        super(x,y,ImageUtility.playerImage.getHeight (),ImageUtility.playerImage.getWidth ());
        identity = id;
        point = 0;
    }
    public String getIdentity(){
        return identity;
    }
    @Override
    public void draw (GraphicsContext ctx, Point ViewPortCenter ) {
        double x = getPosition ().x - ViewPortCenter.x-getWidth ()/2;
        double y = getPosition ().y - ViewPortCenter.y-getHight ()/2;
        ctx.drawImage ( ImageUtility.playerImage , x, y);
        ctx.setTextAlign ( TextAlignment.CENTER );
        ctx.fillText ( identity,x,y-10,getWidth () );
    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Player){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
            identity = ( (Player) cmd ).getId ();
            point = ( (Player) cmd ).getScore ();
        }
    }
}
