package ncu.sw.gameUtility;

import javafx.scene.image.Image;


/**
 * Created by Vincent on 10/10/2016.
 */
public abstract class GameObject {
    private double positionX;
    private double positionY;
    private double height;
    private double width;
    private int attribute; // 加了一個attribute
    public GameObject(double x,double y,double h,double w) {
        positionX = x;
        positionY = y;
        height = h;
        width = w;
    }
    public void setAttribute(int a) {
        this.attribute = a;
    }
    public int getAttribute() {
        return this.attribute;
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
}
