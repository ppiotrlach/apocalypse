package boardCreator;

import board.IBoardStatics;
import board.SimpleBoard;

public class SimpleBoardCreator implements IBoardCreator, IBoardStatics {

    private int numberOfAllies;
    private int numberOfEnemies;

    public SimpleBoardCreator(){
        this(0,0);
    }

    public SimpleBoardCreator(int numberOfAllies, int numberOfEnemies){
        this.numberOfAllies = numberOfAllies;
        this.numberOfEnemies = numberOfEnemies;
    }

    public SimpleBoard createBoard(){

        return new SimpleBoard(numberOfAllies,numberOfEnemies);

    }

}
