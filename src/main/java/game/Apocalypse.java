package game;

import character.Human;
import character.Infected;
import displayer.BoardDisplayer;
import move.RandomMoveGenerator;

import java.util.List;

/***
 * Creating Apocalypse takes place in GameCreator, as it is a implementation of Game Interface
 * It is a center of the whole project, it always contains current numbers of allies and enemies and state of the game
 * Checks if simulation has ended every move
 * It gives commands to other classes
 */
public class Apocalypse implements Game{

    private Board board;
    private GameState stateOfGame;
    private int numberOfAllies = 0;
    private int numberOfEnemies = 0;
    private BoardDisplayer boardDisplayer = new BoardDisplayer();
    private RandomMoveGenerator randomMoveGen = new RandomMoveGenerator();


    public Apocalypse(int numberOfNewAllies, int numberOfNewEnemies, int mapHeight, int mapWidth){
        this.board = new SimpleBoard(mapHeight, mapWidth);
        this.initGame(numberOfNewAllies,numberOfNewEnemies);
        stateOfGame = GameState.IN_PROGRESS;
    }

    private void initGame(int numberOfNewAllies,int numberOfNewEnemies){
        for (int allyCounter = 0; allyCounter < numberOfNewAllies; allyCounter++) {
            this.addHuman(new Human());
        }

        for (int enemyCounter = 0; enemyCounter < numberOfNewEnemies; enemyCounter++) {
            this.addInfected(new Infected());
        }
    }

    private void addHuman(Human human){
        board.addHumanToMap(human, numberOfAllies);
        numberOfAllies++;
    }

// new feature to add - new infected spawns when human dies,
    public void addInfected(Infected infected){
        board.addInfectedToMap(infected, numberOfEnemies);
        numberOfEnemies++;
    }

    public void everyoneFight(){
        int amountOfHumanThatDied = 0;
        int amountOfInfectedThatDied = 0;
        List<TileResult> resolvers = board.fight();
        for (TileResult resolver : resolvers) {
            if(resolver.checkIfHumanDied()){
                amountOfHumanThatDied++;
            }
            if(resolver.checkIfInfectedDied()){
                amountOfInfectedThatDied++;
            }
        }
        decreaseNumberOfAllies(amountOfHumanThatDied);
        decreaseNumberOfEnemies(amountOfInfectedThatDied);
    }

    public void checkIsSimulationOver(){

        if(numberOfAllies == 0 && numberOfEnemies == 0){
            System.out.println("Draw");
            stateOfGame = GameState.END;
        }else if(numberOfAllies == 0) {
            System.out.println("Infected win");
            stateOfGame = GameState.END;
        }else if(numberOfEnemies == 0){
            System.out.println("Humans win");
            stateOfGame = GameState.END;
        }

    }

    private void decreaseNumberOfAllies(int number){
        numberOfAllies-=number;
    }

    private void decreaseNumberOfEnemies(int number){
        numberOfEnemies-=number;
    }

    public GameState getStateOfGame(){
        return stateOfGame;
    }

    public String displayGame(){
        return boardDisplayer.displayBoard(board);
    }

    public void everyoneMove(){
        randomMoveGen.moveRandomlyEveryone(board);
    }

    public void increaseEveryInfectedAttack(){
        board.increaseInfectedAttack();
    }

    public String displayAllCharactersOnBoard(){
        return board.displayAllCharactersOnMap();
    }

}
