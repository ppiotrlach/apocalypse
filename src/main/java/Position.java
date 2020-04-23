public class Position implements Positionable{

    private int xPosition;
    private int yPosition;

    public Position(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    @Override
    public void setxPosition(int xPosition){
        this.xPosition = xPosition;
    }

    @Override
    public void setyPosition(int yPosition){
        this.yPosition = yPosition;
    }

    @Override
    public void setPosition(int xPosition, int yPostion){
        this.xPosition = xPosition;
        this.yPosition = yPostion;
    }

    @Override
    public int getxPosition(){
       return xPosition;
    }

    @Override
    public int getyPosition(){
        return yPosition;
    }


}
