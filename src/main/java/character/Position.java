package character;

public class Position{

    private int xPosition;
    private int yPosition;

    public Position(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void setPosition(int xPosition, int yPostion){
        this.xPosition = xPosition;
        this.yPosition = yPostion;
    }


    public int getxPosition(){
       return xPosition;
    }


    public int getyPosition(){
        return yPosition;
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