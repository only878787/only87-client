package ncu.sw.renderEngine;

import javafx.scene.canvas.GraphicsContext;
import ncu.sw.gui.GameFrameController;
import ncu.sw.renderGameUtility.GameObjectR;
import ncu.sw.renderGameUtility.PlayerR;
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
        ArrayList<PlayerR> plList = GameModel.getInstance().getPlayerRList();
        if(plList.size()>=1)
            GameFrameController.getInstance().firstLabel.setText(
                    plList.get(0).getIdentity()+"  "
                            +plList.get(0).getCount87()+" "+
            plList.get(0).getScore());
        if(plList.size()>=2)
            GameFrameController.getInstance().secondLabel.setText(
                    plList.get(1).getIdentity()+"  "+plList.get(1).getCount87()+" "+
                            plList.get(1).getScore());
        if(plList.size()>=3)
            GameFrameController.getInstance().thirdLabel.setText(
                    plList.get(2).getIdentity()+"  "+plList.get(2).getCount87()+" "+
                            plList.get(2).getScore());
    }
}
