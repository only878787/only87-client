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
        super(x,y,20,20);
    }
    public int getEfect(){
        return efect;
    }
    public void setEfect(int e){
        efect = e;
    }
    @Override
    public void draw (GraphicsContext ctx, Point ViewPortCenter ) {
        double x = getPosition ().x - ViewPortCenter.x;
        double y = getPosition ().y - ViewPortCenter.y;
        ctx.drawImage ( ImageUtility.itemImage , x-50, y-50);
    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Item){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
            setEfect ( ( (Item) cmd ).getEfect () );
        }
    }
}
