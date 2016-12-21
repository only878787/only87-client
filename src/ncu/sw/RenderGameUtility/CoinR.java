package ncu.sw.renderGameUtility;

import javafx.scene.canvas.GraphicsContext;
import ncu.sw.gameUtility.Coin;
import ncu.sw.gameUtility.GameObject;

public class CoinR extends GameObjectR {
    private int point;
    public CoinR(){}
    public CoinR ( double x,double y) {
       super(x,y,ImageUtility.coinImage.getHeight (),ImageUtility.coinImage.getWidth ());
    }
    public int getPoint(){
        return point;
   }
    public void setPoint(int p){
        point = p;
    }
    @Override
    public void draw(GraphicsContext ctx, Point ViewPortCenter ){
        double x = getPosition ().x - ViewPortCenter.x-getWidth ()/2;
        double y = getPosition ().y - ViewPortCenter.y-getHight ()/2;
        ctx.drawImage ( ImageUtility.coinImage , x, y);
    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Coin){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
            setPoint ( ( (Coin) cmd ).getPoint () );
        }
    }
}
