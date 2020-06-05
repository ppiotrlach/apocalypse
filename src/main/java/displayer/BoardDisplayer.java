package displayer;

import game.Board;
import game.Position;

public class BoardDisplayer {

    public String displayBoard(Board board){
        String result = "";
        for (int i = 0; i < board.getMapHeight(); i++) {
            for (int j = 0; j < board.getMapWidth(); j++) {
                if(board.isTileFree(Position.createPosition(i,j))){
                        result += " 0 ";
                }
                else if(board.isTileHumanFree(Position.createPosition(i,j))){
                        result += " I ";
                }
                else if(board.isTileInfectedFree(Position.createPosition(i,j))){
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
