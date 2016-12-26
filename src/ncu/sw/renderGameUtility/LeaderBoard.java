package ncu.sw.renderGameUtility;

import javafx.scene.canvas.GraphicsContext;
import ncu.sw.gameUtility.GameObject;
import ncu.sw.gameUtility.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by chenpu on 2016/12/25.
 */
public class LeaderBoard extends GameObjectR {
    ArrayList<Player> plarerList;
    public LeaderBoard(){
        plarerList = new ArrayList<>();
    }
    public void add(Player p){
        plarerList.add(p);
    }
    public void clear(){
        plarerList.clear();
    }
    @Override
    public void draw(GraphicsContext ctx, Point ViewPortCenter) {
        Collections.sort(plarerList,
                new Comparator<Player>() {
                    public int compare(Player o1, Player o2) {
                        if(o1.getCount87()!=o2.getCount87())
                            return o1.getCount87()-o2.getCount87();
                        return o1.getScore()-o2.getScore();
                    }
                });
    }

    @Override
    public void copyFromCmd(GameObject cmd) {

    }
}
