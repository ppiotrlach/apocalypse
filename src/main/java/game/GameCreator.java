package game;

public class GameCreator {

    private int numberOfAllies;
    private int numberOfEnemies;
    private int mapHeight;
    private int mapWidth;

    public GameCreator(int numberOfAllies, int numberOfEnemies, int height, int width){
        this.numberOfAllies = numberOfAllies;
        this.numberOfEnemies = numberOfEnemies;
        this.mapHeight = height;
        this.mapWidth = width;
    }

    public Apocalypse createBoard(){
        if(numberOfAllies + numberOfEnemies <= mapHeight * mapWidth){
            return new Apocalypse(numberOfAllies, numberOfEnemies, mapHeight, mapWidth);
        }
        else{
            throw new NullPointerException();
        }
    }


}
