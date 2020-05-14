package displayer;

import board.IBoardStatics;
import board.SimpleBoard;

public abstract class BoardDisplayer {


    public static void displayBoard(SimpleBoard board){
        for (int i = 0; i < IBoardStatics.HEIGHT; i++) {
            for (int j = 0; j < IBoardStatics.WIDTH; j++) {
                if(board.isTileFree(i,j)){
                    System.out.print(" 0 ");
                }
                else if(board.isTileHumanFree(i,j)){
                    System.out.print(" I ");
                }
                else if(board.isTileInfectedFree(i,j)){
                    System.out.print(" H ");
                }
                else{
                    System.out.print(" * ");
                }
            }
            System.out.print("\n");
        }
    }


}
