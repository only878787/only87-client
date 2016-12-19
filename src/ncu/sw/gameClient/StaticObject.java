package ncu.sw.gameClient;

import javafx.scene.image.Image;
import java.util.Random;

/**
 * Created by onlyfly34 on 2016/12/12.
 * StaticObject is also scene objects, including character avatar
 */
public class StaticObject {
    private static StaticObject instance = null;
    private Image[] image;
    private int[][] map;

    private StaticObject(){
        map = null;
        image = null;
    }

    public static StaticObject getInstance() {
        if( instance == null ){
            synchronized ( StaticObject.class ) {
                if( instance == null ){
                    instance = new StaticObject();
                }
            }
        }
        return instance;
    }

    public Boolean setMap(){
        map = new int [20][50];
        System.out.println("Map content:");
        for (int i=0; i<20; i++){
            for (int j=0; j<50; j++) {
                //Random rand = new Random();
                map[i][j] = 1;
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        return true;
    }

    public Boolean setImage(){
        image = new Image[5];
        for(int i=0 ; i<5 ; i++){ //Read five element images
            image[i] = new Image("file:image/staticObject/0"+(i+1)+".png");
        }
        return true;
    }

    public Image[] getImage() {
        if( image == null ){
            throw new NullPointerException();
        }
        return image;
    }

    public int[][] getMap() {
        if( map == null ){
            throw new NullPointerException();
        }
        return map;
    }

    public int getMapBlockX(){
        return map[0].length;
    }

    public int getMapBlockY(){
        return map.length;
    }

    public Boolean setStaticObjectEmpty(){
        map = null;
        image = null;
        return true;
    }
}