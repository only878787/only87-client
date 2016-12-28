package ncu.sw.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
import sun.invoke.empty.Empty;

import java.io.File;
import java.net.InetAddress;

public class LoginFrameController{
    //private static final int port = 9487;
    private static final String addr = "140.115.59.83"; //NWLAB
    //private static final String addr = "10.10.10.35"; //NWLAB_my
    //private static final String addr = "10.10.10.153"; //NWLAB內網
    @FXML private Pane loginPane;
    @FXML private Button startButton;
    @FXML private TextField textField;
    @FXML private Label message;

    public LoginFrameController() {
    }

    @FXML
    public void textAction(ActionEvent ae)throws Exception{
        String name = textField.getText();
        if(name == null || "".equals(name)){
            System.out.println("NO INPUT");
            message.setText("使用者ID不可為空");
            message.setVisible(true);
        }else{
            System.out.println("ID: " + name);
            login();
        }
    }

    @FXML
    private void StartButtonOnClicked()throws Exception{
        String name = textField.getText();
        if(name == null || "".equals(name)){
            System.out.println("NO INPUT");
            message.setText("使用者ID不可為空");
            message.setVisible(true);
        }else{
            System.out.println("ID: " + name);
            login();
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

    private void login()throws Exception {
        if (TCPClient.getInstance().connectServer(InetAddress.getByName(addr))) {
            String playerID = textField.getText();
            TCPClient.getInstance().sendClientIdentity(playerID);
            GameModel.getInstance().setMyID(playerID);
            Stage currentStage = (Stage) loginPane.getScene().getWindow();

            GameFrameController.getInstance().setProperty(currentStage);
            //new RenderThread();
            //new UpdateThread();
        }else{
            System.out.println("Connecting error");
            message.setText("Connecting error");
            message.setVisible(true);
        }
    }
}
