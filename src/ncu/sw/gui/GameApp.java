package ncu.sw.gui;/**
 * Created by onlyfly34 on 2016/11/17.
 */

import javafx.scene.Scene;
import ncu.sw.gameClient.TCPClient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class GameApp extends Application {
    private TCPClient tc;


    public GameApp(){
        tc = new TCPClient( 9000 );
        System.out.println( "TCP Socket has been initialized." );
    }

    @Override
    public void start( Stage primaryStage ) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource( "LoginFrameView.fxml" ));
        Parent root = ( Parent ) loader.load();
        LoginFrameController lfc = loader.getController();
        lfc.setProperty( primaryStage, root );
    }

    //public void test( Stage primaryStage ) throws Exception {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource( "LoginFrameView.fxml" ));

        //primaryStage.show();
        //System.out.println( "oh yeah" );
        //FXMLLoader loader = new FXMLLoader(getClass().getResource( "LoginFrameView.fxml" ));
        //Parent root = loader.getRoot();
        //Parent root = ( Parent ) loader.load();
        //primaryStage.setTitle("Only87-Login");
        //primaryStage.setScene(new Scene(root, 1000, 600));
        //primaryStage.show();
    //}
}
