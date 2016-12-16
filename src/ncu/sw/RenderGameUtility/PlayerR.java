package ncu.sw.RenderGameUtility;

/**
 * Created by Arson on 2016/11/1.
 */
public class PlayerR extends GameObjectR {

    private String identity;
    public PlayerR ( double x,double y,String id){
        super(x,y,20,20);
        identity = id;
        setAttribute(0);
    }
}
