package application;

import board.SimpleBoard;
import boardCreator.SimpleBoardCreator;
import board.Move;
import character.Human;
import character.Infected;

public class Application{

    private SimpleBoard board;

    private Application(SimpleBoardCreator boardCreat){
        board = boardCreat.createBoard();
    }

    private void runApplication(){
        board.initBoard();
        for (int i = 0; i < 10; i++) {
            board.addHuman(new Human());
            board.addInfected(new Infected());
        }

        board.displayBoard();

        System.out.println(" ");


        for(Human human : board.getReferenceToListOfHuman()){
            System.out.println(human.displayCharacter());
            Move.moveRandomlyHuman(human,board);
            System.out.println(human.displayCharacter());
        }

        board.displayBoard();

    }

    public static void main(String[] args){
        SimpleBoardCreator boardCreator = new SimpleBoardCreator();
        Application app = new Application(boardCreator);
        app.runApplication();
    }
}
