package ncu.sw.renderGameUtility;

import javafx.scene.canvas.GraphicsContext;
import ncu.sw.gameUtility.GameObject;
import ncu.sw.gameUtility.Item;

/**
 * Created by Arson on 2016/11/1.
 */
public class ItemR extends GameObjectR {

    private int efect;
    public ItemR(){}
    public ItemR ( double x,double y) {
        super(x,y,ImageUtility.itemImage.getHeight (),ImageUtility.itemImage.getWidth ());
    }
    public int getEfect(){
        return efect;
    }
    public void setEfect(int e){
        efect = e;
    }
    @Override
    public void draw (GraphicsContext ctx, Point ViewPortCenter ) {
        double x = getPosition ().x - ViewPortCenter.x-getWidth ()/2;
        double y = getPosition ().y - ViewPortCenter.y-getHight ()/2;
        ctx.drawImage ( ImageUtility.itemImage , x, y);
    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Item){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
            setEfect ( ( (Item) cmd ).getEfect () );
        }
    }
}
