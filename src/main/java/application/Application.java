package application;

import board.SimpleBoard;
import boardCreator.SimpleBoardCreator;
import character.Human;
import displayer.BoardDisplayer;

public class Application{

    private SimpleBoard board;

    private Application(SimpleBoardCreator boardCreat){
        board = boardCreat.createBoard();
    }

    private void runApplication(){
        BoardDisplayer.displayBoard(board);
        System.out.println(" ");//empty line
        board.addHuman(new Human());
        BoardDisplayer.displayBoard(board);
        for (Human human:board.getListOfHuman()) {
            System.out.println("Piotrek");
        }
    }

    public static void main(String[] args){
        SimpleBoardCreator boardCreator = new SimpleBoardCreator(10,10);
        Application app = new Application(boardCreator);
        app.runApplication();
    }
}
