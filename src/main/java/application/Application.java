package application;

import game.GameState;
import game.Apocalypse;
import game.GameCreator;

public class Application{

    private Apocalypse game;

    private Application(GameCreator boardCreat){
        game = boardCreat.createBoard();
    }

    private void runApplication(){

        System.out.println(game.displayGame());

        while(game.getStateOfGame() == GameState.IN_PROGRESS){
            game.everyoneFight();
            game.everyoneMove();
            System.out.println(game.displayGame());
            game.checkIsSimulationOver();
            game.increaseEveryInfectedAttack();
            System.out.println(game.displayAllCharactersOnBoard());
        }
    }

    public static void main(String[] args){
        DataCollector arg = new DataCollector(args);

        GameCreator boardCreator = new GameCreator(arg.getEnteredAmountOfHuman(),arg.getEnteredAmountOfInfected(),
                                                    arg.getEnteredMapHeight() ,arg.getEnteredMapWidth());
        Application app = new Application(boardCreator);
        app.runApplication();

    }

}
