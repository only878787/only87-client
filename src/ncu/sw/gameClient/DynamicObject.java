package ncu.sw.gameClient;

import javafx.scene.input.KeyCode;
import ncu.sw.TCPCM.TCPClient;
import ncu.sw.TCPCMCommand.Command;

import java.util.BitSet;

/**
 * Created by onlyfly34 on 2016/12/12.
 */
public class DynamicObject {
    private static DynamicObject instance = null;
    private int dx = 250;
    private int dy = 150;
    private int cx = 2500;
    private int cy = 1000; //Character's X and Y coordinate
    private int moveSteps = 25;
    private DynamicObject() {

    }

    public static DynamicObject getInstance() {
        if( instance == null ){
            synchronized ( DynamicObject.class ) {
                if( instance == null ){
                    instance = new DynamicObject();
                }
            }
        }
        return instance;
    }

    public void updateCoordinate(KeyCode keycode){
        switch ( keycode ) {
            case UP:    if(cy>0){/*dy+=moveSteps; cy-=moveSteps;*/ TCPClient.getInstance().inputMoves(Command.TURNNORTH); } break;
            case DOWN:  if(cy<StaticObject.getInstance().getMapBlockY()*100){/*dy-=moveSteps; cy+=moveSteps;*/ TCPClient.getInstance().inputMoves(Command.TURNSOUTH);} break;
            case LEFT:  if(cx>0){/*dx+=moveSteps; cx-=moveSteps;*/ TCPClient.getInstance().inputMoves(Command.TURNWEST);} break;
            case RIGHT: if(cx<StaticObject.getInstance().getMapBlockX()*100){/*dx-=moveSteps; cx+=moveSteps;*/ TCPClient.getInstance().inputMoves(Command.TURNEAST);} break;
            default: break;
        }
    }

    /**
     * Detect all keys and show them in the label
     */
    public void updateKeyboardStatus(BitSet keyboardBitSet) {
        String buffer = "";
        if(keyboardBitSet.get(KeyCode.UP.ordinal()) && !keyboardBitSet.get(KeyCode.RIGHT.ordinal())){
            buffer += "U";
        }
        if(keyboardBitSet.get(KeyCode.DOWN.ordinal()) && !keyboardBitSet.get(KeyCode.UP.ordinal())) {
            buffer += "D";
        }
        if(keyboardBitSet.get(KeyCode.RIGHT.ordinal()) && !keyboardBitSet.get(KeyCode.LEFT.ordinal())) {
            buffer += "R";
        }
        if(keyboardBitSet.get(KeyCode.LEFT.ordinal()) && !keyboardBitSet.get(KeyCode.RIGHT.ordinal())) {
            buffer += "L";
        }
        System.out.println(buffer);

        switch( buffer ){
            case "U" : TCPClient.getInstance().inputMoves(Command.TURNNORTH);break;
            case "D" : TCPClient.getInstance().inputMoves(Command.TURNSOUTH);break;
            case "R" : TCPClient.getInstance().inputMoves(Command.TURNEAST);break;
            case "L" : TCPClient.getInstance().inputMoves(Command.TURNWEST); break;
            case "UR": TCPClient.getInstance().inputMoves(Command.TURNEASTNORTH);break;
            case "UL": TCPClient.getInstance().inputMoves(Command.TURNWESTNORTH);break;
            case "DR": TCPClient.getInstance().inputMoves(Command.TURNEASTSOUTH);break;
            case "DL": TCPClient.getInstance().inputMoves(Command.TURNWESTSOUTH);break;
        }
        //position.setText("Position = " + Cx + "," + Cy);
        //gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //paintMap(x, y);
    }

    public int getDrawCoordinateX(){
        return dx;
    }

    public int getDrawCoordinateY(){
        return dy;
    }

    public int getCharacterCoordinateX(){
        return cx;
    }

    public int getCharacterCoordinateY(){
        return cy;
    }

    public int getMoveSteps(){
        return moveSteps;
    }
}
