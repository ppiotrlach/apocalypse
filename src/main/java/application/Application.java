package application;

import game.Game;
import game.GameCreator;
import game.GameState;
import game.ApocalypseCreator;

public class Application{

    private Game game;

    private Application(GameCreator gameCreator){
        game = gameCreator.createBoard();
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

        GameCreator gameCreator = new ApocalypseCreator(arg.getEnteredAmountOfHuman(),arg.getEnteredAmountOfInfected(),
                                                    arg.getEnteredMapHeight() ,arg.getEnteredMapWidth());
        Application app = new Application(gameCreator);
        app.runApplication();

    }

}
