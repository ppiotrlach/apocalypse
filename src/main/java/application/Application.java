package application;

import board.Move;
import board.SimpleBoard;
import boardCreator.SimpleBoardCreator;
import character.Human;
import character.Infected;
import displayer.BoardDisplayer;

import java.util.Map;

public class Application{

    private SimpleBoard board;

    private Application(SimpleBoardCreator boardCreat){
        board = boardCreat.createBoard();
    }

    private void runApplication(){
        BoardDisplayer.displayBoard(board);
        while(board.isNotSimulationOver()){
            for (Map.Entry<Integer, Human> entry : board.getMapOfHuman().entrySet()) {
//                Integer key = entry.getKey();
                Human human = entry.getValue();
                Move.moveRandomlyHuman(human,board);

            }
            for (Map.Entry<Integer, Infected> entry : board.getMapOfInfected().entrySet()) {
//                Integer key = entry.getKey();
                Infected infected = entry.getValue();
                Move.moveInfected(infected,board);
                infected.increaseAttack();
            }
            board.fight();
            System.out.println(" ");
            BoardDisplayer.displayBoard(board);
        }
    }

    public static void main(String[] args){
        SimpleBoardCreator boardCreator = new SimpleBoardCreator(3,3);
        Application app = new Application(boardCreator);
        app.runApplication();
    }
}
