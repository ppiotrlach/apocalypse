package move;

import board.IBoardStatics;
import board.SimpleBoard;
import character.Human;
import character.Infected;

public abstract class Move implements IBoardStatics {

    public static void moveRandomlyHuman(Human human, SimpleBoard board){
        RandomMoveGenerator rand = RandomMoveGenerator.randomMove();
        int humanPosX = human.getPosition().getxPosition();
        int humanPosY = human.getPosition().getyPosition();
        if(board.getTile(humanPosX,humanPosY).isInfectedFree()) {
            switch (rand) {
                case UP:
                    if (humanPosY + 1 != IBoardStatics.HEIGHT
                            && board.getTile(humanPosX, humanPosY + 1).isHumanFree()) {
                        board.getTile(humanPosX, humanPosY).setHuman(null);
                        board.getTile(humanPosX, humanPosY + 1).setHuman(human);
                        human.setPosition(humanPosX, humanPosY + 1);
                    }
                    break;
                case DOWN:
                    if (humanPosY != 0
                            && board.getTile(humanPosX, humanPosY - 1).isHumanFree()) {
                        board.getTile(humanPosX, humanPosY).setHuman(null);
                        board.getTile(humanPosX, humanPosY - 1).setHuman(human);
                        human.setPosition(humanPosX, humanPosY - 1);
                    }
                    break;
                case LEFT:
                    if (humanPosX != 0
                            && board.getTile(humanPosX - 1, humanPosY).isHumanFree()) {
                        board.getTile(humanPosX, humanPosY).setHuman(null);
                        board.getTile(humanPosX - 1, humanPosY).setHuman(human);
                        human.setPosition(humanPosX - 1, humanPosY);
                    }
                    break;
                case RIGHT:
                    if (humanPosX + 1 != IBoardStatics.WIDTH
                            && board.getTile(humanPosX + 1, humanPosY).isHumanFree()) {
                        board.getTile(humanPosX, humanPosY).setHuman(null);
                        board.getTile(humanPosX + 1, humanPosY).setHuman(human);
                        human.setPosition(humanPosX + 1, humanPosY);
                    }
                    break;
            }
        }
    }

    public static void moveInfected(Infected infected, SimpleBoard board) {
        RandomMoveGenerator rand = RandomMoveGenerator.randomMove();
        int infectedPosX = infected.getPosition().getxPosition();
        int infectedPosY = infected.getPosition().getyPosition();
        if (board.getTile(infectedPosX, infectedPosY).isHumanFree()) {
            switch (rand) {
                case UP:
                    if (infectedPosY + 1 != IBoardStatics.HEIGHT
                            && board.getTile(infectedPosX, infectedPosY + 1).isInfectedFree()) {
                        board.getTile(infectedPosX, infectedPosY).setInfected(null);
                        board.getTile(infectedPosX, infectedPosY + 1).setInfected(infected);
                        infected.setPosition(infectedPosX, infectedPosY + 1);
                    }
                    break;
                case DOWN:
                    if (infectedPosY != 0
                            && board.getTile(infectedPosX, infectedPosY - 1).isInfectedFree()) {
                        board.getTile(infectedPosX, infectedPosY).setInfected(null);
                        board.getTile(infectedPosX, infectedPosY - 1).setInfected(infected);
                        infected.setPosition(infectedPosX, infectedPosY - 1);
                    }
                    break;
                case LEFT:
                    if (infectedPosX != 0
                            && board.getTile(infectedPosX - 1, infectedPosY).isInfectedFree()) {
                        board.getTile(infectedPosX, infectedPosY).setInfected(null);
                        board.getTile(infectedPosX - 1, infectedPosY).setInfected(infected);
                        infected.setPosition(infectedPosX - 1, infectedPosY);
                    }
                    break;
                case RIGHT:
                    if (infectedPosX + 1 != IBoardStatics.WIDTH
                            && board.getTile(infectedPosX + 1, infectedPosY).isInfectedFree()) {
                        board.getTile(infectedPosX, infectedPosY).setInfected(null);
                        board.getTile(infectedPosX + 1, infectedPosY).setInfected(infected);
                        infected.setPosition(infectedPosX + 1, infectedPosY);
                    }
                    break;
            }
        }
    }

}
