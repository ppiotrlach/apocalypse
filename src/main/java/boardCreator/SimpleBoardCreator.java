package boardCreator;

import board.IBoardStatics;
import board.SimpleBoard;

public class SimpleBoardCreator implements IBoardStatics {

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
        if(numberOfAllies + numberOfEnemies <= IBoardStatics.HEIGHT * IBoardStatics.WIDTH){
            return new SimpleBoard(numberOfAllies,numberOfEnemies);
        }
        else{
            System.out.println("You want to add too many characters to the board");
            return null;
        }
    }

}
