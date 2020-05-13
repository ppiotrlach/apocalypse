package application;

import board.Move;
import board.SimpleBoard;
import boardCreator.SimpleBoardCreator;
import character.Human;
import character.Infected;
import displayer.BoardDisplayer;

public class Application{

    private SimpleBoard board;

    private Application(SimpleBoardCreator boardCreat){
        board = boardCreat.createBoard();
    }

    private void runApplication(){
        BoardDisplayer.displayBoard(board);
        while(board.isNotSimulationOver()){
            for (Human human : board.getListOfHuman()) {

                System.out.println(board.getListOfHuman().indexOf(human));
                System.out.println(human.toString());
                Move.moveRandomlyHuman(human,board);

            }
            for (Infected infected : board.getListOfInfected()) {

                System.out.println(board.getListOfInfected().indexOf(infected));
                System.out.println(infected.toString());
                Move.moveInfected(infected,board);
            }
            board.fight();
            System.out.println(" ");
            BoardDisplayer.displayBoard(board);
        }
    }

    public static void main(String[] args){
        SimpleBoardCreator boardCreator = new SimpleBoardCreator(2,2);
        Application app = new Application(boardCreator);
        app.runApplication();
    }
}
