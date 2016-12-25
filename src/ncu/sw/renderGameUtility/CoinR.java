package ncu.sw.renderGameUtility;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import ncu.sw.gameUtility.Coin;
import ncu.sw.gameUtility.GameObject;

public class CoinR extends GameObjectR {
    private int point;
    public CoinR(){
        point = 0;
    }
    public CoinR ( double x,double y) {
       super(x,y,ImageUtility.coinImage.getHeight(),ImageUtility.coinImage.getWidth());
    }
    public int getPoint(){
        return point;
   }
    public void setPoint(int p){
        point = p;
    }
    @Override
    public void draw(GraphicsContext ctx, Point ViewPortCenter ){
        setHightandWidth(ImageUtility.coinImage.getHeight(),ImageUtility.coinImage.getWidth());
        double x = getPosition ().x - ViewPortCenter.x-getWidth()/2;
        double y = getPosition ().y - ViewPortCenter.y-getHight()/2;
        ctx.drawImage ( ImageUtility.coinImage , x, y);
        ctx.setTextAlign ( TextAlignment.CENTER );
        ctx.save();
        ctx.setFill(Color.WHITE);
        ctx.setFont(Font.font(24));
        ctx.fillText ( String.valueOf(point),x+getWidth ()/2,y+getHight()/2+10);
        ctx.restore();
    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Coin){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
            setPoint ( ( (Coin) cmd ).getPoint () );
        }
    }
}
