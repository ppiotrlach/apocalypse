package game;

import java.util.Random;

public class RandomPositionGenerator {

    public Position generateRandomPosition(SimpleBoard simpleBoard) {
        Random rand = new Random();
        int x = rand.nextInt(simpleBoard.mapHeight);
        int y = rand.nextInt(simpleBoard.mapWidth);
        return Position.createPosition(x,y);
    }

}
