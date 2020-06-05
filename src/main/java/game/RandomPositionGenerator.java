package game;

import java.util.Random;

/***
 * Generates two random coordinates are passes them to Position to check if there already is Position with these arguments
 */
public class RandomPositionGenerator {

    public Position generateRandomPosition(SimpleBoard simpleBoard) {
        Random rand = new Random();
        int x = rand.nextInt(simpleBoard.mapHeight);
        int y = rand.nextInt(simpleBoard.mapWidth);
        return Position.createPosition(x,y);
    }

}
