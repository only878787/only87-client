package ncu.sw.gui;

/**
 * Created by onlyfly34 on 2016/11/12.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameFrame extends Application {
    public GameFrame() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load( getClass().getResource("GameFrame.fxml") );
        primaryStage.setTitle( "Only87" );
        primaryStage.setScene( new Scene( root, 1000, 600 ) );
        primaryStage.show();
    }
}
