package ncu.sw.RenderEngine;

import javafx.scene.canvas.GraphicsContext;
import ncu.sw.RenderGameUtility.GameObjectR;
import ncu.sw.RenderGameUtility.Point;
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
        ViewPortCenter.x = GameModel.getInstance ().getPlayerXY ().x-500;
        ViewPortCenter.y =GameModel.getInstance ().getPlayerXY ().y-300;
        ctx.clearRect ( 0,0,1000,600 );
        for ( GameObjectR obj:GameModel.getInstance ().getDynamicObjectList ()){
            if(obj.inViewPort(ViewPortCenter))
                obj.draw ( ctx, ViewPortCenter);
        }
    }
}
