package ncu.sw.gameClient;

import ncu.sw.gameUtility.*;
import ncu.sw.renderGameUtility.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GameModel {
    private static GameModel instance= null;
    private ArrayList<GameObjectR> dynamicObjectList;
    private ArrayList<PlayerR> playerRList;
    private PlayerR mplayer = null;
    private String identity;

    private GameModel(){
        dynamicObjectList = new ArrayList<>();
        playerRList = new ArrayList<>();
    }
    public static GameModel getInstance() {
        if (instance == null) {
            instance = new GameModel();
        }

        return instance;
    }
    public synchronized ArrayList<GameObjectR> getDynamicObjectList(){
        return dynamicObjectList;
    }
    public synchronized ArrayList<PlayerR> getPlayerRList(){
        return playerRList;
    }
    public synchronized void update(Cmd cmd){
        mplayer = null;
        dynamicObjectList.clear ();
        playerRList.clear();
        for( Player player:cmd.getPlayerArrayList ()){
            PlayerR playerR = new PlayerR (  );
            playerR.copyFromCmd ( player );
            dynamicObjectList.add ( playerR );
            playerRList.add(playerR);
            if(identity.equals(playerR.getIdentity())){
                mplayer = playerR;
            }
        }
        Collections.sort(playerRList,
                new Comparator<PlayerR>() {
                    public int compare(PlayerR p1, PlayerR p2) {
                        if(p1.getCount87()!=p2.getCount87())
                            return p2.getCount87()-p1.getCount87();
                        return p2.getScore()-p1.getScore();
                    }
                });
        for( Coin coin:cmd.getCoinArrayList ()){
            CoinR coinR = new CoinR (  );
            coinR.copyFromCmd ( coin );
            dynamicObjectList.add ( coinR );
        }
        for( Item item:cmd.getItemArrayList ()){
            ItemR itemR = new ItemR (  );
            itemR.copyFromCmd ( item );
            dynamicObjectList.add ( itemR );
        }
        for( Obstacle obstacle:cmd.getObstacleArrayList ()){
            ObstacleR obstacleR = new ObstacleR (  );
            obstacleR.copyFromCmd ( obstacle );
            dynamicObjectList.add ( obstacleR );
        }
    }
    public void setMyID(String id){
        identity = id;
    }
    public String getMyID(){
        return identity;
    }
    public Point getPlayerXY() {
        if(mplayer!= null)
            return mplayer.getPosition();
        return null;
    }
}
