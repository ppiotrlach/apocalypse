package board;

import character.Human;
import character.Infected;
import displayer.IDisplayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// objects of this class are meant to be created by class SimpleBoardCreator
public class SimpleBoard implements IBoard, IBoardStatics, IDisplayer {


    private Tile[][] grid;
    private List<Human> listOfHuman;
    private List<Infected> listOfInfected;
    private int numberOfAllies;
    private int numberOfEnemies;

    public SimpleBoard(){
        this(0,0);
    }

    public SimpleBoard(int numberOfAllies, int numberOfEnemies){
        this.numberOfAllies = numberOfAllies;
        this.numberOfEnemies = numberOfEnemies;
        listOfHuman = new ArrayList<>(10);
        listOfInfected = new ArrayList<>(10);
        grid = new Tile[IBoardStatics.HEIGHT][IBoardStatics.WIDTH];
        this.initBoard(numberOfAllies,numberOfEnemies);
    }

    private void initBoard(int numberOfAllies, int numberOfEnemies){

        for (int i = 0; i < IBoardStatics.HEIGHT; i++) {
            for (int j = 0; j < IBoardStatics.WIDTH; j++) {
                grid[i][j] = new Tile();
            }
        }

        while(this.numberOfAllies<numberOfAllies){
                this.addHuman(new Human());
            }

        while(this.numberOfEnemies<numberOfEnemies) {
            this.addInfected(new Infected());
        }

    }


    //this method adds a Human to a random Tile on board
    @Override
    public void addHuman(Human human){

        Random rand = new Random();
        int temporary = numberOfAllies + 1;
        while(numberOfAllies < temporary){
            int x = rand.nextInt(IBoardStatics.HEIGHT);
            int y = rand.nextInt(IBoardStatics.WIDTH);
            if(grid[x][y].isHumanFree()) {
                grid[x][y].setHuman(human);
                human.setPosition(x, y);
                listOfHuman.add(human);
                human.setCharacterID(numberOfAllies);
                numberOfAllies++;
            }
        }
    }


    //this method adds an Infected to a random tile on board
    @Override
    public void addInfected(Infected infected){

        Random rand = new Random();
        int temporary = numberOfEnemies + 1;
        while(numberOfEnemies<temporary){
            int x = rand.nextInt(IBoardStatics.HEIGHT);
            int y = rand.nextInt(IBoardStatics.WIDTH);
            if(grid[x][y].isInfectedFree()) {
                grid[x][y].setInfected(infected);
                infected.setPosition(x, y);
                listOfInfected.add(infected);
                infected.setCharacterID(numberOfEnemies);
                numberOfEnemies++;
            }
        }
    }

    public List<Human> getReferenceToListOfHuman() {
        return listOfHuman;
    }

    public List<Infected> getReferenceToListOfInfected() {
        return listOfInfected;
    }

    @Override
    public void display(){
        for (int i = 0; i < IBoardStatics.HEIGHT; i++) {
            for (int j = 0; j < IBoardStatics.WIDTH; j++) {
                if(grid[i][j].isFree()){
                    System.out.print(" 0 ");
                }
                else if(grid[i][j].isHumanFree()){
                    System.out.print(" I ");
                }
                else if(grid[i][j].isInfectedFree()){
                    System.out.print(" H ");
                }
                else{
                    System.out.print(" * ");
                }
            }
            System.out.print("\n");
        }
    }

    public Tile[][] getReferenceToGrid(){
        return grid;
    }
//
//    public void findClosestEnemy() {
//        //not done
//
//    }

    @Override
    public boolean isSimulationOver(){
        return true;
        //not done
    }
}


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
//    }