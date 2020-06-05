package move;

import game.Board;
import game.Position;
import game.SimpleBoard;
import game.Tile;

import java.util.Map;

/***
 * for each character on board checks if they are not in a fight at the time and if not
 * generates position for them to move one tile distance from where they are standing right now and if the move is possible
 * it commands SimpleBoard to move them
 */
public class RandomMoveGenerator {

    public void moveRandomlyEveryone(Board board){

        for (Map.Entry<Position,Tile> entry: board.getMap().entrySet()){
            Position currentPersonsPos = entry.getKey();
            Position newPosition;
            if(!board.isTileHumanFree(currentPersonsPos) && board.isTileInfectedFree(currentPersonsPos)){
                Move rand = Move.randomMove();
                int humanPosX = currentPersonsPos.getxCoordinate();
                int humanPosY = currentPersonsPos.getyCoordinate();
                    switch (rand) {
                        case UP:
                            newPosition = Position.createPosition(humanPosX, humanPosY + 1);
                            if (humanPosY + 1 != board.getMapHeight()
                                    && board.isTileHumanFree(newPosition)) {
                                board.moveHuman(currentPersonsPos, newPosition);
                            }
                            break;
                        case DOWN:
                            newPosition = Position.createPosition(humanPosX, humanPosY-1);
                            if (humanPosY != 0
                                    && board.isTileHumanFree(newPosition)) {
                                board.moveHuman(currentPersonsPos, newPosition);
                            }
                            break;
                        case LEFT:
                            newPosition = Position.createPosition(humanPosX-1, humanPosY);
                            if (humanPosX != 0
                                    && board.isTileHumanFree(newPosition)) {
                                board.moveHuman(currentPersonsPos, newPosition);
                            }
                            break;
                        case RIGHT:
                            newPosition = Position.createPosition(humanPosX+1, humanPosY);
                            if (humanPosX + 1 != board.getMapWidth()
                                    && board.isTileHumanFree(newPosition)) {
                                board.moveHuman(currentPersonsPos, newPosition);
                            }
                            break;
                        }
                }
            if(!board.isTileInfectedFree(currentPersonsPos) && board.isTileHumanFree(currentPersonsPos)){
                Move rand = Move.randomMove();
                int infectedPosX = currentPersonsPos.getxCoordinate();
                int infectedPosY = currentPersonsPos.getyCoordinate();
                    switch (rand) {
                        case UP:
                            newPosition = Position.createPosition(infectedPosX, infectedPosY + 1);
                            if (infectedPosY + 1 != board.getMapHeight()
                                    && board.isTileInfectedFree(newPosition)) {
                                board.moveInfected(currentPersonsPos, newPosition);
                            }
                            break;
                        case DOWN:
                            newPosition = Position.createPosition(infectedPosX, infectedPosY-1);
                            if (infectedPosY != 0
                                    && board.isTileInfectedFree(newPosition)) {
                                board.moveInfected(currentPersonsPos, newPosition);
                            }
                            break;
                        case LEFT:
                            newPosition = Position.createPosition(infectedPosX-1, infectedPosY);
                            if (infectedPosX != 0
                                    && board.isTileInfectedFree(newPosition)) {
                                board.moveInfected(currentPersonsPos, newPosition);
                            }
                            break;
                        case RIGHT:
                            newPosition = Position.createPosition(infectedPosX+1, infectedPosY);
                            if (infectedPosX + 1 != board.getMapWidth()
                                    && board.isTileInfectedFree(newPosition)) {
                                board.moveInfected(currentPersonsPos, newPosition);
                            }
                            break;
                        }
                }
        }
    }

}
