package ncu.sw.gui;

/**
 * Created by onlyfly34 on 2016/11/12.
 */

import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import ncu.sw.renderGameUtility.ImageUtility;
import org.controlsfx.control.StatusBar;
import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import ncu.sw.UDPCM.UDPUpdateServer;
import ncu.sw.gameClient.DynamicObject;
import ncu.sw.gameClient.StaticObject;
import ncu.sw.renderEngine.RenderThread;

import java.io.IOException;
import java.util.BitSet;

public class GameFrameController {
    @FXML private Canvas canvas;
    @FXML private Label position;
    @FXML private StatusBar statusBar;
    @FXML private VBox leaderBoard;
    @FXML private StackPane pane;
    @FXML public Label firstLabel;
    @FXML public Label secondLabel;
    @FXML public Label thirdLabel;
    @FXML private ImageView fImageView;
    @FXML private ImageView sImageView;
    @FXML private ImageView tImageView;
    private static GameFrameController instance = null;
    public GraphicsContext gc;
    private Scene scene;
    private BitSet keyboardBitSet = new BitSet();

    private GameFrameController(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource( "GameFrameView.fxml" ));
        loader.setRoot(this.pane);
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

    public void setProperty( Stage stageBuffer) {
        stageBuffer.setTitle("Only87-Gaming");
        stageBuffer.setResizable(false);
        scene = new Scene(this.pane);
        stageBuffer.setScene(scene);
        stageBuffer.show();

        /**Set Graphics Context 2D ready**/
        gc = canvas.getGraphicsContext2D();

        fImageView.setImage(ImageUtility.goldImage);
        sImageView.setImage(ImageUtility.silverImage);
        tImageView.setImage(ImageUtility.brownImage);
        /**Add keylistener to the scene**/
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
        //DynamicObject.getInstance().updateKeyboardStatus(keyboardBitSet);
        //addKeyListener(scene);

        StaticObject.getInstance().setImage();
        StaticObject.getInstance().setMap();

        UDPUpdateServer.getInstance().initUDPServer();
        new RenderThread();
        //new UpdateThread();
    }

    public StackPane getPane(){
        return pane;
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
    /*public StatusBar getStatusBar() {
        return statusBar;
    }*/
}
