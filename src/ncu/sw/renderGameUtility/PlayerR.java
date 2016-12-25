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
    private int score;
    private int count87;
    public PlayerR(){
        identity = "";
        score = 0;
        count87 = 0;
    }
    public PlayerR ( double x,double y,String id){
        super(x,y,ImageUtility.playerImage.getHeight(),ImageUtility.playerImage.getWidth());
        identity = id;
        score = 0;
    }
    public String getIdentity(){
        return identity;
    }
    @Override
    public void draw (GraphicsContext ctx, Point ViewPortCenter ) {
        setHightandWidth(ImageUtility.playerImage.getHeight(),ImageUtility.playerImage.getWidth());
        double x = getPosition ().x - ViewPortCenter.x-getWidth()/2;
        double y = getPosition ().y - ViewPortCenter.y-getHight()/2;
        ctx.drawImage ( ImageUtility.playerImage , x, y);
        ctx.setTextAlign ( TextAlignment.CENTER );
        ctx.fillText ( identity+"  score: "+score+"  87: "+count87,x+getWidth ()/2,y-10);
    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Player){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
            identity = ( (Player) cmd ).getId ();
            score = ((Player)cmd).getScore();
            count87 = ((Player)cmd).getCount87();
        }
    }
}
