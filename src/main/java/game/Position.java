package game;

import java.util.ArrayList;
import java.util.List;

public class Position{

    private int xPosition;
    private int yPosition;
    private static List<Position> positionList = new ArrayList<>();

    private Position(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public static Position createPosition(int x, int y){
        Position newPosition = new Position(x,y);
        for (Position position : positionList) {
            if(position.equals(newPosition)){
                return position;
            }
        }
        positionList.add(newPosition);
        return newPosition;
    }

    public int getxCoordinate(){
       return xPosition;
    }

    public int getyCoordinate(){
        return yPosition;
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(!(object instanceof Position)){
            return false;
        }
        Position position = (Position)object;
        return (this.xPosition==((Position) object).xPosition
                && this.yPosition == ((Position) object).yPosition);
    }

}


//
//    public void setxPosition(int xPosition){
//        this.xPosition = xPosition;
//    }
//
//
//    public void setyPosition(int yPosition){
//        this.yPosition = yPosition;
//    }