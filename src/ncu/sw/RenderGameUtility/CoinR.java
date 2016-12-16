package ncu.sw.RenderGameUtility;

/**
 * Created by Arson on 2016/11/1.
 */
public class CoinR extends GameObjectR {
    private int point;
    public CoinR ( double x,double y) {
       super(x,y,20,20);
       setAttribute(0);
   }
   public int getPoint(){
        return point;
   }
   public void setPoint(int p){
        point = p;
    }
}
