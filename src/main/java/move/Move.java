package move;

import java.util.Random;

public enum Move {

    UP, DOWN, LEFT, RIGHT;

    public static Move randomMove() {
        Random rand = new Random();
        int i = rand.nextInt(4);
        if(i == 0){
            return UP;
        }
        else if(i == 1){
            return DOWN;
        }
        else if(i == 2){
            return LEFT;
        }
        else{
            return RIGHT;
        }
    }
}
