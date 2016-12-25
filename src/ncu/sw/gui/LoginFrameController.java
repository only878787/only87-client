package ncu.sw.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import ncu.sw.TCPCM.TCPClient;
import ncu.sw.gameClient.GameModel;
import ncu.sw.gameClient.UpdateThread;
import ncu.sw.renderEngine.RenderThread;

import java.io.File;
import java.net.InetAddress;

public class LoginFrameController{
    //private static final int port = 9487;
    private static final String addr = "140.115.59.83";
    @FXML private Pane loginPane;
    @FXML private Button startButton;
    @FXML private TextField textField;

    public LoginFrameController() {
    }

    @FXML
    private void StartButtonOnClicked() throws Exception {
        if(TCPClient.getInstance().connectServer(InetAddress.getByName(addr))){
            String playerID = textField.getText();
            TCPClient.getInstance().sendClientIdentity(playerID);
            GameModel.getInstance().setMyID(playerID);
            Stage currentStage = (Stage) loginPane.getScene().getWindow();
            GameFrameController.getInstance().setProperty( currentStage, GameFrameController.getInstance() );
            //new RenderThread();
            //new UpdateThread();
        }
    }

    @FXML
    private void initialize() {
        File imageFile = new File("image/background.jpg");
        Image image = new Image(imageFile.toURI().toString());
        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(1000, 600, true, true, true, false);
        // new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        loginPane.setBackground(background);
    }

    public void setProperty( Stage stageBuffer, Parent root) {
        stageBuffer.setTitle("Only87-Login");
        stageBuffer.setScene(new Scene(root, 1000, 600));
        stageBuffer.show();
    }
}
