package displayer;

import board.IBoardStatics;
import board.SimpleBoard;

public abstract class BoardDisplayer {


    public static void displayBoard(SimpleBoard board){
        for (int i = 0; i < IBoardStatics.HEIGHT; i++) {
            for (int j = 0; j < IBoardStatics.WIDTH; j++) {
                if(board.getTile(i,j).isFree()){
                    System.out.print(" 0 ");
                }
                else if(board.getTile(i,j).isHumanFree()){
                    System.out.print(" I ");
                }
                else if(board.getTile(i,j).isInfectedFree()){
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
