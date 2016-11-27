package ncu.sw.gui;

/**
 * Created by onlyfly34 on 2016/11/12.
 */

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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.util.Random;

public class GameFrameController{
    @FXML
    private Canvas canvas;
    @FXML
    private Label position;
    private GraphicsContext gc;
    private Image[] image;
    private Scene scene;
    private int[][] map;

    private int x = 250,y = 150, Cx = 2500 ,Cy = 1000; //Character's X and Y coordinate

    public GameFrameController() {

    }

    public void setProperty( Stage stageBuffer, Parent root) {
        stageBuffer.setTitle("Only87-Gaming");
        scene = new Scene(root, 500, 300);
        stageBuffer.setScene(scene);
        stageBuffer.show();

        image = new Image[5];
        position.setText("Position = 2500,1000");
        map = new int [20][50];
        gc = canvas.getGraphicsContext2D();
        addKeyListener(scene);
        for(int i=0 ; i<5 ; i++){ //Read five element images
            image[i] = new Image("file:image/0"+(i+1)+".png");
        }

        for (y=0;y<20; y++){
            for (x=0;x<50; x++) {
                Random rand = new Random();
                map[y][x] = rand.nextInt(4) + 0;
                System.out.print(map[y][x]+" ");
            }
            System.out.println();
        }
        paintMap(x, y);
        //gc.drawImage(image[0], 0, 0);
    }

    private void paintMap(int x, int y){
        int counter = 0;
        for(int i = 0;i<50;i++){
            for(int j= 0;j<20;j++){
                int x_buffer = x+i*100-2500+200; //x+i*100-2500+200
                //int x_buffer = x+i*100-2500;
                int y_buffer = y+j*100-1000+125+5; //y+j*100-1000+130
                //int y_buffer = y+j*100-1000;
                if(x_buffer >= -75 && x_buffer <= 475 && y_buffer >= -75 && y_buffer <= 275) { //0-75,500+75,0-75,200+75 , -100,300
                    gc.drawImage(image[map[j][i]], x_buffer, y_buffer);
                    counter++;
                }
            }
        }
        //gc.fillOval(250-8, 150-8, 16, 16);
        System.out.println("DrawImage function is called "+counter+" times");
    }

    private void addKeyListener(Scene sceneBuffer) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    if(Cy>0){y+=25; Cy-=25; position.setText("Position = "+Cx+","+Cy);} break;
                    case DOWN:  if(Cy<2000){y-=25; Cy+=25; position.setText("Position = "+Cx+","+Cy);} break;
                    case LEFT:  if(Cx>0){x+=25; Cx-=25; position.setText("Position = "+Cx+","+Cy);} break;
                    case RIGHT: if(Cx<5000){x-=25; Cx+=25; position.setText("Position = "+Cx+","+Cy);} break;
                    default: break;
                }
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                paintMap(x, y);
            }
        });
    }
    /*@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load( getClass().getResource("GameFrameController.fxml") );
        primaryStage.setTitle( "Only87" );
        primaryStage.setScene( new Scene( root, 1000, 600 ) );
        primaryStage.show();
    }*/
}
