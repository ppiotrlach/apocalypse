import com.sun.jdi.ClassNotPreparedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {


    static final int HEIGHT = 10;
    static final int WIDTH = 10;

    private Tile[][] grid = new Tile[HEIGHT][WIDTH];
    private ArrayList<Human> listOfHuman = new ArrayList<Human>(10);
    private ArrayList<Infected> listOfInfected = new ArrayList<Infected>(10);
    private int numberOfAllies;
    private int numberOfEnemies;

    Board(){
        numberOfAllies = 0;
        numberOfEnemies = 0;
    }

//    public void initBoard(int finalNumberOfAllies, int finalNumberOfEnemies){
    public void initBoard(){

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = new Tile();
            }
        }

//        while(numberOfAllies<finalNumberOfAllies){
//                this.addCharacterable(new Human());
//            }
//
//        while(numberOfEnemies<finalNumberOfEnemies){
//            this.addCharacterable(new Infected());
//            }

    }

    public void addCharacterable(Characterable characterable){

        Random rand = new Random();

        if(characterable instanceof Human) {
            int temporary = numberOfAllies + 1;
            while(numberOfAllies < temporary){
                int x = rand.nextInt(HEIGHT);
                int y = rand.nextInt(WIDTH);
                if (grid[x][y].isFree()) {
                    grid[x][y].setCharacterable(characterable);
                    numberOfAllies++;
                }
            }
        }
        else if (characterable instanceof Infected){
            int temporary = numberOfEnemies + 1;
            while(numberOfEnemies<temporary){
                int x = rand.nextInt(HEIGHT);
                int y = rand.nextInt(WIDTH);
                if (grid[x][y].isFree()) {
                    grid[x][y].setCharacterable(characterable);
                    numberOfEnemies++;
                }
            }
        }
        else{
            throw new ClassNotPreparedException();
        }
    }

    public void addHuman(Human human){

        Random rand = new Random();
        int temporary = numberOfAllies + 1;
        while(numberOfAllies < temporary){
            int x = rand.nextInt(HEIGHT);
            int y = rand.nextInt(WIDTH);
            if(grid[x][y].isHumanFree()) {
                grid[x][y].setHuman(human);
                human.setPosition(x, y);
                listOfHuman.add(human);
                human.setCharacterID(numberOfAllies);
                numberOfAllies++;
            }
        }
    }

    public void addInfected(Infected infected){

        Random rand = new Random();
        int temporary = numberOfEnemies + 1;
        while(numberOfEnemies<temporary){
            int x = rand.nextInt(HEIGHT);
            int y = rand.nextInt(WIDTH);
            if(grid[x][y].isInfectedFree()) {
                grid[x][y].setInfected(infected);
                infected.setPosition(x, y);
                listOfInfected.add(infected);
                infected.setCharacterID(numberOfEnemies);
                numberOfEnemies++;
            }
        }
    }

    public ArrayList<Human> getReferenceToListOfHuman() {
        return listOfHuman;
    }

    public ArrayList<Infected> getReferenceToListOfInfected() {
        return listOfInfected;
    }

    public void displayBoard(){
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if(grid[i][j].isFree()){
                    System.out.print(" 0 ");
                }
                else if(grid[i][j].isHumanFree()){
                    System.out.print(" H ");
                }
                else if(grid[i][j].isInfectedFree()){
                    System.out.print(" I ");
                }
                else{
                    System.out.print(" * ");
                }
            }
            System.out.print("\n");
        }
    }
}
