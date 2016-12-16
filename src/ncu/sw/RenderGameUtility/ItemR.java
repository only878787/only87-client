package ncu.sw.RenderGameUtility;

/**
 * Created by Arson on 2016/11/1.
 */
public class ItemR extends GameObjectR {

    private int efect;
    public ItemR ( double x,double y) {
        super(x,y,20,20);
        setAttribute(0);
    }
    public int getEfect(){
        return efect;
    }
    public void setEfect(int e){
        efect = e;
    }
}
