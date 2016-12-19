package ncu.sw.renderGameUtility;

/**
 * Created by chenpu on 2016/12/17.
 */
public class Point {
    public double x;
    public double y;
    public Point(){
        x = 0;
        y = 0;
    }
    public Point(Point pos){
        x = pos.x;
        y = pos.y;
    }
    public double distance(Point pos) {
        return Math.sqrt((pos.x - x) * (pos.x - x) + (pos.y - y) * (pos.y - y));
    }
}
