package ncu.sw.RenderGameUtility;

import javafx.scene.canvas.GraphicsContext;
import ncu.sw.CmdGameUtility.Coin;
import ncu.sw.CmdGameUtility.GameObject;

public class CoinR extends GameObjectR {
    private int point;
    public CoinR(){}
    public CoinR ( double x,double y) {
       super(x,y,20,20);
    }
    public int getPoint(){
        return point;
   }
    public void setPoint(int p){
        point = p;
    }
    @Override
    public void draw(GraphicsContext ctx, Point ViewPortCenter ){
        double x = getPosition ().x - ViewPortCenter.x;
        double y = getPosition ().y - ViewPortCenter.y;
        ctx.drawImage ( ImageUtility.coinImage , x-50, y-50);
    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Coin){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
            setPoint ( ( (Coin) cmd ).getPoint () );
        }
    }
}
