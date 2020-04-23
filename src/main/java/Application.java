public class Application {

    public static void main(String[] args){

        Board board = new Board();
//        board.initBoard(10,10);
        board.initBoard();
        for (int i = 0; i < 10; i++) {
            board.addHuman(new Human());
            board.addInfected(new Infected());
        }

        board.displayBoard();

        System.out.println(" ");

        for(Human human : board.getReferenceToListOfHuman()){
            System.out.println(human.displayCharacter());
            Move.moveRandomlyHuman(human,board);
            System.out.println(human.displayCharacter());
        }

        board.displayBoard();



    }
}
