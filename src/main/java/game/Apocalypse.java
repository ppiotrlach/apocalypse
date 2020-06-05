package game;

import character.Human;
import character.Infected;
import displayer.BoardDisplayer;
import move.RandomMoveGenerator;

import java.util.List;

// objects of this class are meant to be created by class SimpleBoardCreator
public class Apocalypse implements Game{

    private SimpleBoard simpleBoard;
    private GameState stateOfGame;
    private int numberOfAllies = 0;
    private int numberOfEnemies = 0;
    private BoardDisplayer boardDisplayer = new BoardDisplayer();
    private RandomMoveGenerator randomMoveGen = new RandomMoveGenerator();


    public Apocalypse(int numberOfNewAllies, int numberOfNewEnemies, int mapHeight, int mapWidth){
        this.simpleBoard = new SimpleBoard(mapHeight, mapWidth);
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
        simpleBoard.addHumanToMap(human, numberOfAllies);
        numberOfAllies++;
    }

// new feature to add - new infected spawns when human dies,
    public void addInfected(Infected infected){
        simpleBoard.addInfectedToMap(infected, numberOfEnemies);
        numberOfEnemies++;
    }

    public void everyoneFight(){
        int amountOfHumanThatDied = 0;
        int amountOfInfectedThatDied = 0;
        List<TileResolver> resolvers = simpleBoard.fight();
        for (TileResolver resolver : resolvers) {
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
        return boardDisplayer.displayBoard(simpleBoard);
    }

    public void everyoneMove(){
        randomMoveGen.moveRandomlyEveryone(simpleBoard);
    }

    public void increaseEveryInfectedAttack(){
        simpleBoard.increaseInfectedAttack();
    }

    public String displayAllCharactersOnBoard(){
        return simpleBoard.displayAllCharactersOnMap();
    }

}


//    //this method adds a Human to a random Tile on board
//    private void addHuman(Human human){
//        if(numberOfAllies + numberOfEnemies <= IBoardStatics.HEIGHT * IBoardStatics.WIDTH) {
//            grid.addHuman(human, mapOfHuman, numberOfAllies);
//            numberOfAllies++;
//        }
//        else{
//            throw new NullPointerException();
//        }
//    }
//
//    //this method adds an Infected to a random tile on board
//    public void addInfected(Infected infected){
//        if(numberOfAllies + numberOfEnemies <= IBoardStatics.HEIGHT * IBoardStatics.WIDTH) {
//            grid.addInfected(infected, mapOfInfected, numberOfEnemies);
//            numberOfEnemies++;
//        }
//        else{
//            throw new NullPointerException();
//        }
//    }

//    private Grid grid;
//    grid = new Grid(numberOfNewAllies, numberOfNewEnemies, mapOfHuman, mapOfInfected);
//    public Tile getTile(int x, int y){
//    return grid.getTile(x,y);
//}
//    public void fight(){
//        grid.fight(this);
//    }

//        grid = new Tile[IBoardStatics.HEIGHT][IBoardStatics.WIDTH];
//        grid.initGrid(numberOfAllies,numberOfEnemies);
//    private void initGrid(int numberOfAllies, int numberOfEnemies){
//
//        for (int i = 0; i < IBoardStatics.HEIGHT; i++) {
//            for (int j = 0; j < IBoardStatics.WIDTH; j++) {
//                grid[i][j] = new Tile();
//            }
//        }
//
//        while(numberOfAllies<numberOfAllies){
//            this.addHuman(new Human());
//        }
//
//        while(this.numberOfEnemies<numberOfEnemies) {
//            this.addInfected(new Infected());
//        }
//
//    }
//        Random rand = new Random();
//        int temporary = numberOfAllies + 1;
//        while(numberOfAllies < temporary){
//            int x = rand.nextInt(IBoardStatics.HEIGHT);
//            int y = rand.nextInt(IBoardStatics.WIDTH);
//            if(grid[x][y].isHumanFree()) {
//                grid[x][y].setHuman(human);
//                human.setPosition(x, y);
//
//    public Tile[][] getReferenceToGrid(){
//        return grid;
//    }
//    public void addCharacterable(Characterable characterable){
//
//        Random rand = new Random();
//
//        if(characterable instanceof Human) {
//            int temporary = numberOfAllies + 1;
//            while(numberOfAllies < temporary){
//                int x = rand.nextInt(HEIGHT);
//                int y = rand.nextInt(WIDTH);
//                if (grid[x][y].isFree()) {
//                    grid[x][y].setCharacterable(characterable);
//                    numberOfAllies++;
//                }
//            }
//        }
//        else if (characterable instanceof Infected){
//            int temporary = numberOfEnemies + 1;
//            while(numberOfEnemies<temporary){
//                int x = rand.nextInt(HEIGHT);
//                int y = rand.nextInt(WIDTH);
//                if (grid[x][y].isFree()) {
//                    grid[x][y].setCharacterable(characterable);
//                    numberOfEnemies++;
//                }
//            }
//        }
//        else{
//            throw new ClassNotPreparedException();
//        }
//
//    public void setTileToHuman(int x, int y, Human human){
//        grid.setTileToHuman(x,y,human);
//    }
//
//    public void setTileToInfected(int x, int y, Infected infected){
//        grid.setTileToInfected(x,y,infected);
//    }
//
//    public boolean isTileFree(int x, int y){
//        return grid.isTileFree(x,y);
//    }
//
//    public boolean isTileHumanFree(int x, int y){
//        return grid.isTileHumanFree(x,y);
//    }
//
//    public boolean isTileInfectedFree(int x, int y){
//        return grid.isTileInfectedFree(x,y);
//    }
//
//    public void findClosestEnemy() {
//        //not done
//
//    }
//    public void findClosestEnemy() {
//        //not done
//
//    }

