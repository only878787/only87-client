package ncu.sw.renderGameUtility;


import javafx.scene.canvas.GraphicsContext;
import ncu.sw.gameUtility.GameObject;

public abstract class GameObjectR {
    private Point position;
    private double height;
    private double width;
    public GameObjectR () {
        position = new Point();
        height = 0;
        width = 0;
    }
    public GameObjectR ( double x,double y,double h,double w) {
        position = new Point();
        position.x = x;
        position.y = y;
        height = h;
        width = w;
    }
    public void setPosition(double X,double Y) {
        position.x = X;
        position.y = Y;
    }
    public void setHightandWidth(double height,double width) { //for test
        this.height = height;
        this.width = width;
    }
    public Point getPosition(){
        return position;
    }
    public double getHight() {
        return  height;
    }
    public double getWidth() {
        return  width;
    }
    public abstract void draw(GraphicsContext ctx, Point ViewPortCenter);
    public abstract void copyFromCmd( GameObject cmd);
    public boolean inViewPort(Point pos){
        if(position.x > pos.x + 1000 ||position.x < pos.x)
            return false;
        if(position.y > pos.y + 600 ||position.y < pos.y)
            return false;
        return true;
    }
}
