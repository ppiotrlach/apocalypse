package move;

import game.Position;
import game.SimpleBoard;
import game.Tile;

import java.util.Map;

public class RandomMoveGenerator {

    public void moveRandomlyEveryone(SimpleBoard simpleBoard){

        for (Map.Entry<Position,Tile> entry: simpleBoard.getMap().entrySet()){
            Position currentPersonsPos = entry.getKey();
            Position newPosition;
            if(!simpleBoard.isTileHumanFree(currentPersonsPos) && simpleBoard.isTileInfectedFree(currentPersonsPos)){
                Move rand = Move.randomMove();
                int humanPosX = currentPersonsPos.getxCoordinate();
                int humanPosY = currentPersonsPos.getyCoordinate();
                    switch (rand) {
                        case UP:
                            newPosition = Position.createPosition(humanPosX, humanPosY + 1);
                            if (humanPosY + 1 != simpleBoard.getMapHeight()
                                    && simpleBoard.isTileHumanFree(newPosition)) {
                                simpleBoard.moveHuman(currentPersonsPos, newPosition);
                            }
                            break;
                        case DOWN:
                            newPosition = Position.createPosition(humanPosX, humanPosY-1);
                            if (humanPosY != 0
                                    && simpleBoard.isTileHumanFree(newPosition)) {
                                simpleBoard.moveHuman(currentPersonsPos, newPosition);
                            }
                            break;
                        case LEFT:
                            newPosition = Position.createPosition(humanPosX-1, humanPosY);
                            if (humanPosX != 0
                                    && simpleBoard.isTileHumanFree(newPosition)) {
                                simpleBoard.moveHuman(currentPersonsPos, newPosition);
                            }
                            break;
                        case RIGHT:
                            newPosition = Position.createPosition(humanPosX+1, humanPosY);
                            if (humanPosX + 1 != simpleBoard.getMapWidth()
                                    && simpleBoard.isTileHumanFree(newPosition)) {
                                simpleBoard.moveHuman(currentPersonsPos, newPosition);
                            }
                            break;
                        }
                }
            if(!simpleBoard.isTileInfectedFree(currentPersonsPos) && simpleBoard.isTileHumanFree(currentPersonsPos)){
                Move rand = Move.randomMove();
                int infectedPosX = currentPersonsPos.getxCoordinate();
                int infectedPosY = currentPersonsPos.getyCoordinate();
                    switch (rand) {
                        case UP:
                            newPosition = Position.createPosition(infectedPosX, infectedPosY + 1);
                            if (infectedPosY + 1 != simpleBoard.getMapHeight()
                                    && simpleBoard.isTileInfectedFree(newPosition)) {
                                simpleBoard.moveInfected(currentPersonsPos, newPosition);
                            }
                            break;
                        case DOWN:
                            newPosition = Position.createPosition(infectedPosX, infectedPosY-1);
                            if (infectedPosY != 0
                                    && simpleBoard.isTileInfectedFree(newPosition)) {
                                simpleBoard.moveInfected(currentPersonsPos, newPosition);
                            }
                            break;
                        case LEFT:
                            newPosition = Position.createPosition(infectedPosX-1, infectedPosY);
                            if (infectedPosX != 0
                                    && simpleBoard.isTileInfectedFree(newPosition)) {
                                simpleBoard.moveInfected(currentPersonsPos, newPosition);
                            }
                            break;
                        case RIGHT:
                            newPosition = Position.createPosition(infectedPosX+1, infectedPosY);
                            if (infectedPosX + 1 != simpleBoard.getMapWidth()
                                    && simpleBoard.isTileInfectedFree(newPosition)) {
                                simpleBoard.moveInfected(currentPersonsPos, newPosition);
                            }
                            break;
                        }
                }
        }
    }

}
