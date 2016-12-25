package ncu.sw.gui;

/**
 * Created by onlyfly34 on 2016/11/12.
 */

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import org.controlsfx.control.StatusBar;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import ncu.sw.UDPCM.UDPUpdateServer;
import ncu.sw.gameClient.DynamicObject;
import ncu.sw.gameClient.StaticObject;
import ncu.sw.gameClient.UpdateThread;
import ncu.sw.renderEngine.RenderThread;
import ncu.sw.renderEngine.SpriteRenderEngine;

import java.io.IOException;
import java.util.BitSet;
import java.util.Random;

public class GameFrameController {
    @FXML private Canvas canvas;
    @FXML private Label position;
    @FXML private StatusBar statusBar;
    @FXML private BorderPane borderPane;
    private static GameFrameController instance = null;
    public GraphicsContext gc;
    private Scene scene;
    private BitSet keyboardBitSet = new BitSet();

    private GameFrameController(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource( "GameFrameView.fxml" ));
        loader.setRoot(this.borderPane);
        loader.setController(this);
        //Parent root = ( Parent ) loader.load();
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static GameFrameController getInstance() {
        if( instance == null ){
            synchronized ( GameFrameController.class ) {
                if( instance == null ){
                    instance = new GameFrameController();
                }
            }
        }
        return instance;
    }

    public void setProperty( Stage stageBuffer, Parent root) {
        stageBuffer.setTitle("Only87-Gaming");
        stageBuffer.setResizable(false);
        scene = new Scene(this.borderPane);
        stageBuffer.setScene(scene);
        stageBuffer.show();

        /**Set Graphics Context 2D ready**/
        gc = canvas.getGraphicsContext2D();

        /**Add keylistener to the scene**/
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
        //DynamicObject.getInstance().updateKeyboardStatus(keyboardBitSet);
        //addKeyListener(scene);

        StaticObject.getInstance().setImage();
        StaticObject.getInstance().setMap();

        UDPUpdateServer.getInstance();
        new RenderThread();
        //new UpdateThread();
    }

    public BorderPane getBorderPane(){
        return borderPane;
    }

    private void addKeyListener(Scene sceneBuffer) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                DynamicObject.getInstance().updateCoordinate(event.getCode());
            }
        });
    }

    /**
     * "Key Pressed" handler for all input events: register pressed key in the bitset
     */
    private EventHandler<KeyEvent> keyPressedEventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {

            // register key down
            keyboardBitSet.set(event.getCode().ordinal(), true);

            DynamicObject.getInstance().updateKeyboardStatus(keyboardBitSet);
        }
    };

    /**
     * "Key Released" handler for all input events: unregister released key in the bitset
     */
    private EventHandler<KeyEvent> keyReleasedEventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {

            // register key up
            keyboardBitSet.set(event.getCode().ordinal(), false);

            DynamicObject.getInstance().updateKeyboardStatus(keyboardBitSet);
        }
    };

    public Canvas getCanvas(){
        return canvas;
    }
    public Label getPositionLabel() { return position; }
    public StatusBar getStatusBar() {
        return statusBar;
    }
}
