package ncu.sw.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.File;

public class LoginFrameController{
    @FXML
    private Pane loginPane;
    @FXML
    private Button startButton;

    public LoginFrameController() {
    }

    @FXML
    private void StartButtonOnClicked() throws Exception {
        Stage currentStage = (Stage) loginPane.getScene().getWindow();
        FXMLLoader newLoader = new FXMLLoader( getClass().getResource( "GameFrameView.fxml" ) );
        Parent newRoot = (Parent) newLoader.load();
        GameFrameController gfc = newLoader.getController();
        gfc.setProperty( currentStage, newRoot );
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
