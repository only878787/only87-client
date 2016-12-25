package ncu.sw.gameClient;

import ncu.sw.gameUtility.*;
import ncu.sw.renderGameUtility.*;

import java.util.ArrayList;

public class GameModel {
    private static GameModel instance= null;
    private ArrayList<GameObjectR> dynamicObjectList;
    private PlayerR mplayer = null;
    private String identity;
    private LeaderBoard leaderBoard;

    private GameModel(){
        dynamicObjectList = new ArrayList<>();
        leaderBoard = new LeaderBoard();
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
    public synchronized void update(Cmd cmd){
        mplayer = null;
        dynamicObjectList.clear ();
        leaderBoard.clear();
        for( Player player:cmd.getPlayerArrayList ()){
            leaderBoard.add(player);
            PlayerR playerR = new PlayerR (  );
            playerR.copyFromCmd ( player );
            dynamicObjectList.add ( playerR );
            if(identity.equals(playerR.getIdentity())){
                mplayer = playerR;
            }
        }
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
        System.out.println(id);
    }
    public Point getPlayerXY() {
        if(mplayer!= null)
            return mplayer.getPosition();
        return null;
    }
}
