package ncu.sw.renderEngine;

import javafx.scene.canvas.GraphicsContext;
import ncu.sw.gameUtility.GameObject;
import ncu.sw.renderGameUtility.GameObjectR;
import ncu.sw.renderGameUtility.Point;
import ncu.sw.gameClient.GameModel;

import java.util.ArrayList;

/**
 * Created by chenpu on 2016/12/17.
 */
public class SpriteRenderEngine {
    private GraphicsContext ctx;
    private Point ViewPortCenter;
    public SpriteRenderEngine(GraphicsContext ctx){
        ViewPortCenter = new Point (  );
        this.ctx = ctx;
    }
    public void renderSprites(){
        if(GameModel.getInstance ().getPlayerXY ()!=null) {
            ViewPortCenter.x = GameModel.getInstance().getPlayerXY().x - 500;
            ViewPortCenter.y = GameModel.getInstance().getPlayerXY().y - 300;
            //ctx.clearRect(0, 0, 1000, 600);

            ArrayList<GameObjectR> game = new ArrayList<>();
            game.addAll(GameModel.getInstance().getDynamicObjectList());
            for (GameObjectR obj : game) {
                if(obj!=null) {
                    if (obj.inViewPort(ViewPortCenter))
                        obj.draw(ctx, ViewPortCenter);
                }
            }
        }
    }
}
