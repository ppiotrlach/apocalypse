package displayer;

import game.Position;
import game.SimpleBoard;

public class BoardDisplayer {

    public String displayBoard(SimpleBoard simpleBoard){
        String result = "";
        for (int i = 0; i < simpleBoard.getMapHeight(); i++) {
            for (int j = 0; j < simpleBoard.getMapWidth(); j++) {
                if(simpleBoard.isTileFree(Position.createPosition(i,j))){
                        result += " 0 ";
                }
                else if(simpleBoard.isTileHumanFree(Position.createPosition(i,j))){
                        result += " I ";
                }
                else if(simpleBoard.isTileInfectedFree(Position.createPosition(i,j))){
                        result += " H ";
                }
                else{
                        result += " * ";
                }
            }
            result += "\n";
        }
        result += "\n";
        return result;
    }


}
