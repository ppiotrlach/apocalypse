package board;

import character.Human;
import character.Infected;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Grid {

    private Tile[][] grid;

    public Grid(int newAllies, int newEnemies, Map<Integer, Human> mapOfHuman, Map<Integer, Infected> mapOfInfected){
        grid = new Tile[IBoardStatics.HEIGHT][IBoardStatics.WIDTH];
        this.initGrid(newAllies, newEnemies, mapOfHuman, mapOfInfected);
    }

    private void initGrid(int newAllies, int newEnemies, Map<Integer, Human> mapOfHuman, Map<Integer,Infected> mapOfInfected){

        for (int i = 0; i < IBoardStatics.HEIGHT; i++) {
            for (int j = 0; j < IBoardStatics.WIDTH; j++) {
                grid[i][j] = new Tile();
            }
        }

        for (int allyCounter = 0; allyCounter < newAllies; allyCounter++) {
            this.addHuman(new Human(), mapOfHuman, allyCounter);
        }

        for (int enemyCounter = 0; enemyCounter < newEnemies; enemyCounter++) {
            this.addInfected(new Infected(), mapOfInfected ,enemyCounter);
        }
    }

    public void addHuman(Human human, Map<Integer, Human> mapOfHuman, int allyCounter){

        Random rand = new Random();
        int temporary = 0;
        while(temporary < 1){
            int x = rand.nextInt(IBoardStatics.HEIGHT);
            int y = rand.nextInt(IBoardStatics.WIDTH);
            if(grid[x][y].isFree()) {
                grid[x][y].setHuman(human);
                human.setPosition(x, y);
                human.setCharacterID(allyCounter);
                mapOfHuman.put(allyCounter,human);
                temporary++;
            }
        }
    }

    public void addInfected(Infected infected, Map<Integer, Infected> mapOfInfected, int enemyCounter){

        Random rand = new Random();
        int temporary = 0;
        while(temporary<1) {
            int x = rand.nextInt(IBoardStatics.HEIGHT);
            int y = rand.nextInt(IBoardStatics.WIDTH);
            if (grid[x][y].isFree()) {
                grid[x][y].setInfected(infected);
                infected.setPosition(x, y);
                infected.setCharacterID(enemyCounter);
                mapOfInfected.put(enemyCounter,infected);
                temporary++;
            }
        }
    }

    public Tile tile(int x, int y){
        return grid[x][y];
    }

    public void setTileToHuman(int x, int y, Human human){
            grid[x][y].setHuman(human);
    }

    public void setTileToInfected(int x, int y, Infected infected){
        grid[x][y].setInfected(infected);
    }

    public boolean isTileFree(int x, int y){
        return grid[x][y].isFree();
    }

    public boolean isTileHumanFree(int x, int y){
        return grid[x][y].isHumanFree();
    }

    public boolean isTileInfectedFree(int x, int y){
        return grid[x][y].isInfectedFree();
    }

    public void fight(SimpleBoard board){
        for (int i = 0; i < IBoardStatics.HEIGHT; i++) {
            for (int j = 0; j < IBoardStatics.WIDTH; j++) {
                if(grid[i][j].isInteractionPossible()){
                    grid[i][j].interact(board);
                }
            }
        }
    }

}
