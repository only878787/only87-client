package ncu.sw.renderEngine;

import javafx.scene.canvas.GraphicsContext;
import ncu.sw.renderGameUtility.GameObjectR;
import ncu.sw.renderGameUtility.Point;
import ncu.sw.gameClient.GameModel;

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
            ctx.clearRect(0, 0, 1000, 600);
            for (GameObjectR obj : GameModel.getInstance().getDynamicObjectList()) {
                if (obj.inViewPort(ViewPortCenter))
                    obj.draw(ctx, ViewPortCenter);
            }
        }
    }
}
