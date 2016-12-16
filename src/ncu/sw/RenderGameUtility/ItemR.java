package ncu.sw.RenderGameUtility;

import ncu.sw.CmdGameUtility.GameObject;
import ncu.sw.CmdGameUtility.Item;

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
    public void draw(){

    }
    @Override
    public void copyFromCmd(GameObject cmd){
        if(cmd instanceof Item){
            setPosition ( cmd.getPositionX (),cmd.getPositionY () );
            setEfect ( ( (Item) cmd ).getEfect () );
        }
    }
}
