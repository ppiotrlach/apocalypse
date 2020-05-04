package board;

import character.Human;
import character.Infected;
import position.Position;

public abstract class Move implements IBoardStatics {

    public static void moveRandomlyHuman(Human human, SimpleBoard board){
        RandomMoveGenerator rand = RandomMoveGenerator.randomMove();
        Position positionOfHuman = human.getPosition();
        switch (rand){
            case UP:
                if(positionOfHuman.getyPosition() + 1 != IBoardStatics.HEIGHT
                        && board.getReferenceToGrid()[positionOfHuman.getxPosition()][positionOfHuman.getyPosition() + 1].isHumanFree()){
                    board.getReferenceToGrid()[positionOfHuman.getxPosition()][positionOfHuman.getyPosition()].setHuman(null);
                    board.getReferenceToGrid()[positionOfHuman.getxPosition()][positionOfHuman.getyPosition()+1].setHuman(human);
                    human.setPosition(positionOfHuman.getxPosition(),positionOfHuman.getyPosition()+1);
                }
                break;
            case DOWN:
                if(positionOfHuman.getyPosition() != 0
                        && board.getReferenceToGrid()[positionOfHuman.getxPosition()][positionOfHuman.getyPosition() - 1].isHumanFree()){
                    board.getReferenceToGrid()[positionOfHuman.getxPosition()][positionOfHuman.getyPosition()].setHuman(null);
                    board.getReferenceToGrid()[positionOfHuman.getxPosition()][positionOfHuman.getyPosition()-1].setHuman(human);
                    human.setPosition(positionOfHuman.getxPosition(),positionOfHuman.getyPosition()-1);
                }
                break;
            case LEFT:
                if(positionOfHuman.getxPosition() != 0
                        && board.getReferenceToGrid()[positionOfHuman.getxPosition() - 1][positionOfHuman.getyPosition()].isHumanFree()){
                    board.getReferenceToGrid()[positionOfHuman.getxPosition()][positionOfHuman.getyPosition()].setHuman(null);
                    board.getReferenceToGrid()[positionOfHuman.getxPosition()-1][positionOfHuman.getyPosition()].setHuman(human);
                    human.setPosition(positionOfHuman.getxPosition()-1,positionOfHuman.getyPosition());
                }
                break;
            case RIGHT:
                if(positionOfHuman.getxPosition() + 1!= IBoardStatics.WIDTH
                        && board.getReferenceToGrid()[positionOfHuman.getxPosition() + 1][positionOfHuman.getyPosition()].isHumanFree()){
                    board.getReferenceToGrid()[positionOfHuman.getxPosition()][positionOfHuman.getyPosition()].setHuman(null);
                    board.getReferenceToGrid()[positionOfHuman.getxPosition()+1][positionOfHuman.getyPosition()].setHuman(human);
                    human.setPosition(positionOfHuman.getxPosition()+1, positionOfHuman.getyPosition());
                }
                break;
        }
    }

    public static void moveInfected(Infected infected, SimpleBoard board){
        RandomMoveGenerator rand = RandomMoveGenerator.randomMove();
        Position positionOfInfected = infected.getPosition();
        switch (rand){
            case UP:
                if(positionOfInfected.getyPosition() + 1 != IBoardStatics.HEIGHT
                        && board.getReferenceToGrid()[positionOfInfected.getxPosition()][positionOfInfected.getyPosition() + 1].isInfectedFree()){
                    board.getReferenceToGrid()[positionOfInfected.getxPosition()][positionOfInfected.getyPosition()].setInfected(null);
                    board.getReferenceToGrid()[positionOfInfected.getxPosition()][positionOfInfected.getyPosition()+1].setInfected(infected);
                    infected.setPosition(positionOfInfected.getxPosition(),positionOfInfected.getyPosition()+1);
                }
                break;
            case DOWN:
                if(positionOfInfected.getyPosition() != 0
                        && board.getReferenceToGrid()[positionOfInfected.getxPosition()][positionOfInfected.getyPosition() - 1].isInfectedFree()){
                    board.getReferenceToGrid()[positionOfInfected.getxPosition()][positionOfInfected.getyPosition()].setInfected(null);
                    board.getReferenceToGrid()[positionOfInfected.getxPosition()][positionOfInfected.getyPosition()-1].setInfected(infected);
                    infected.setPosition(positionOfInfected.getxPosition(),positionOfInfected.getyPosition()-1);
                }
                break;
            case LEFT:
                if(positionOfInfected.getxPosition() != 0
                        && board.getReferenceToGrid()[positionOfInfected.getxPosition() - 1][positionOfInfected.getyPosition()].isInfectedFree()){
                    board.getReferenceToGrid()[positionOfInfected.getxPosition()][positionOfInfected.getyPosition()].setInfected(null);
                    board.getReferenceToGrid()[positionOfInfected.getxPosition()-1][positionOfInfected.getyPosition()].setInfected(infected);
                    infected.setPosition(positionOfInfected.getxPosition()-1,positionOfInfected.getyPosition());
                }
                break;
            case RIGHT:
                if(positionOfInfected.getxPosition() + 1!= IBoardStatics.WIDTH
                        && board.getReferenceToGrid()[positionOfInfected.getxPosition() + 1][positionOfInfected.getyPosition()].isInfectedFree()){
                    board.getReferenceToGrid()[positionOfInfected.getxPosition()][positionOfInfected.getyPosition()].setInfected(null);
                    board.getReferenceToGrid()[positionOfInfected.getxPosition()+1][positionOfInfected.getyPosition()+1].setInfected(infected);
                    infected.setPosition(positionOfInfected.getxPosition()+1,positionOfInfected.getyPosition());
                }
                break;
        }
    }

}
