package ncu.sw.RenderGameUtility;


import ncu.sw.CmdGameUtility.GameObject;

/**
 * Created by Vincent on 10/10/2016.
 */
public abstract class GameObjectR {
    private double positionX;
    private double positionY;
    private double height;
    private double width;
    public GameObjectR () {
        positionX = 0;
        positionY = 0;
        height = 0;
        width = 0;
    }
    public GameObjectR ( double x,double y,double h,double w) {
        positionX = x;
        positionY = y;
        height = h;
        width = w;
    }
    public void setPosition(double X,double Y) {
        this.positionX = X;
        this.positionY = Y;
    }
    public void setHightandWidth(double height,double width) { //for test
        this.height = height;
        this.width = width;
    }
    public double getPositionX() {
        return  this.positionX;
    }
    public double getPositionY() {
        return  this.positionY;
    }
    public double getHight() {
        return  height;
    }
    public double getWidth() {
        return  width;
    }
    public abstract void draw();
    public abstract void copyFromCmd( GameObject cmd);
}
