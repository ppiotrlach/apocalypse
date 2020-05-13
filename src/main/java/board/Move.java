package board;

import character.Human;
import character.Infected;
import position.Position;

public abstract class Move implements IBoardStatics {

    public static void moveRandomlyHuman(Human human, SimpleBoard board){
        RandomMoveGenerator rand = RandomMoveGenerator.randomMove();
        int humanPosX = human.getPosition().getxPosition();
        int humanPosY = human.getPosition().getyPosition();
        if(board.isTileInfectedFree(humanPosX,humanPosY)) {
            switch (rand) {
                case UP:
                    if (humanPosY + 1 != IBoardStatics.HEIGHT
                            && board.isTileHumanFree(humanPosX, humanPosY + 1)) {
                        board.setTileToHuman(humanPosX, humanPosY, null);
                        board.setTileToHuman(humanPosX, humanPosY + 1, human);
                        human.setPosition(humanPosX, humanPosY + 1);
                    }
                    break;
                case DOWN:
                    if (humanPosY != 0
                            && board.isTileHumanFree(humanPosX, humanPosY - 1)) {
                        board.setTileToHuman(humanPosX, humanPosY, null);
                        board.setTileToHuman(humanPosX, humanPosY - 1, human);
                        human.setPosition(humanPosX, humanPosY - 1);
                    }
                    break;
                case LEFT:
                    if (humanPosX != 0
                            && board.isTileHumanFree(humanPosX - 1, humanPosY)) {
                        board.setTileToHuman(humanPosX, humanPosY, null);
                        board.setTileToHuman(humanPosX - 1, humanPosY, human);
                        human.setPosition(humanPosX - 1, humanPosY);
                    }
                    break;
                case RIGHT:
                    if (humanPosX + 1 != IBoardStatics.WIDTH
                            && board.isTileHumanFree(humanPosX + 1, humanPosY)) {
                        board.setTileToHuman(humanPosX, humanPosY, null);
                        board.setTileToHuman(humanPosX + 1, humanPosY, human);
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
        if (board.isTileHumanFree(infectedPosX, infectedPosY)) {
            switch (rand) {
                case UP:
                    if (infectedPosY + 1 != IBoardStatics.HEIGHT
                            && board.isTileInfectedFree(infectedPosX, infectedPosY + 1)) {
                        board.setTileToInfected(infectedPosX, infectedPosY, null);
                        board.setTileToInfected(infectedPosX, infectedPosY + 1, infected);
                        infected.setPosition(infectedPosX, infectedPosY + 1);
                    }
                    break;
                case DOWN:
                    if (infectedPosY != 0
                            && board.isTileInfectedFree(infectedPosX, infectedPosY - 1)) {
                        board.setTileToInfected(infectedPosX, infectedPosY, null);
                        board.setTileToInfected(infectedPosX, infectedPosY - 1, infected);
                        infected.setPosition(infectedPosX, infectedPosY - 1);
                    }
                    break;
                case LEFT:
                    if (infectedPosX != 0
                            && board.isTileInfectedFree(infectedPosX - 1, infectedPosY)) {
                        board.setTileToInfected(infectedPosX, infectedPosY, null);
                        board.setTileToInfected(infectedPosX - 1, infectedPosY, infected);
                        infected.setPosition(infectedPosX - 1, infectedPosY);
                    }
                    break;
                case RIGHT:
                    if (infectedPosX + 1 != IBoardStatics.WIDTH
                            && board.isTileInfectedFree(infectedPosX + 1, infectedPosY)) {
                        board.setTileToInfected(infectedPosX, infectedPosY, null);
                        board.setTileToInfected(infectedPosX + 1, infectedPosY, infected);
                        infected.setPosition(infectedPosX + 1, infectedPosY);
                    }
                    break;
            }
        }
    }

}
