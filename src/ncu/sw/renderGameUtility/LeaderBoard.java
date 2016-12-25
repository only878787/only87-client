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
                        if (o1.getScore()>o2.getScore())
                            return 1;
                        else if (o1.getScore()==o2.getScore())
                            return 0;
                        return -1;
                    }
                });
    }

    @Override
    public void copyFromCmd(GameObject cmd) {

    }
}
