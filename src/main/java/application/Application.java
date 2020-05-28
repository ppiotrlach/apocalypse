package application;

import move.Move;
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
        while(!board.isSimulationOver()){
            for (Map.Entry<Integer, Human> entry : board.getMapOfHuman().entrySet()) {
//                Integer key = entry.getKey();
                Human human = entry.getValue();
                Move.moveRandomlyHuman(human,board);
                System.out.println(human.toString());

            }
            for (Map.Entry<Integer, Infected> entry : board.getMapOfInfected().entrySet()) {
//                Integer key = entry.getKey();
                Infected infected = entry.getValue();
                Move.moveInfected(infected,board);
                System.out.println(infected.toString());
                infected.increaseAttack();
            }
            board.fight();
            System.out.println(" ");
            BoardDisplayer.displayBoard(board);

        }
    }

//    public static void main(String[] args){
//        SimpleBoardCreator boardCreator = new SimpleBoardCreator(2,2);
//        Application app = new Application(boardCreator);
//        app.runApplication();
//    }

    public static void main(String[] args){

        DataCollector arg = new DataCollector(args);


        SimpleBoardCreator boardCreator = new SimpleBoardCreator(arg.getEnteredAmountOfHuman(), arg.getEnteredAmountOfInfected());
        Application app = new Application(boardCreator);
        app.runApplication();
//        System.out.println(arg.getEnteredAmountOfHuman());
//        System.out.println(arg.getEnteredAmountOfInfected());
//        System.out.println(arg.getEnteredMapHeight());
//        System.out.println(arg.getEnteredMapWidth());


    }
}
