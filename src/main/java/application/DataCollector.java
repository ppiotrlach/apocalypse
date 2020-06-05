package application;

public class DataCollector extends ArgumentParser {



    private int amountOfHuman = getNumber(0);
    private int amountOfInfected = getNumber(1);
    private int mapHeight = getNumber(2);
    private int mapWidth = getNumber(3);


    public DataCollector(String[] args) {
        super(args);
    }

    private boolean isPossibleToCreateMap(){
        if(amountOfHuman+amountOfInfected<=mapHeight*mapWidth) return true;
        return false;
    }

    public int getEnteredAmountOfHuman(){
        if(isPossibleToCreateMap()) return amountOfHuman;
        else return 5;
    }

    public int getEnteredAmountOfInfected(){
        if(isPossibleToCreateMap()) return amountOfInfected;
        else return 5;
    }

    public int getEnteredMapHeight(){
        return mapHeight;

    }

    public int getEnteredMapWidth(){
        return mapWidth;

    }
}


