import org.junit.Test;

public class Tests {

    @Test
    public void setUp(){
        Board board = new Board();
//        board.initBoard(10,10);
        board.initBoard();
        for (int i = 0; i < 10; i++) {
            board.addHuman(new Human());
            System.out.println(board.getReferenceToListOfHuman().get(i).displayCharacter());
        }
        board.displayBoard();
    }

}
