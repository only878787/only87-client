package ncu.sw.gameUtility;

/**
 * Created by Arson on 2016/11/1.
 */
public class Item extends  GameObject{

    private int efect;
    public Item(int x,int y) {
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
