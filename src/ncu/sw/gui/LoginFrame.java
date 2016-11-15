package ncu.sw.gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;

public class LoginFrame extends Application {
    @FXML
    Pane loginPane;

    public LoginFrame() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginFrame.fxml"));
        primaryStage.setTitle("LoginFrame");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
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
}
