package character;

import displayer.IDisplayer;
import position.Position;

public abstract class Character implements ICharacter, IDisplayer {

    private int characterID; //yes, it is useless XD

    private int healthPoints;
    private int attackDamage;

    private Position characterPosition;

    public Character()
    {
        this(100,20);
    }

    public Character(int healthPoints, int attackDamage){
        this.healthPoints = healthPoints;
        this.attackDamage = attackDamage;
        this.characterPosition = new Position(-1,-1);
        this.characterID = -1;

    }

    @Override
    public void setXCoordinate(int xCoordinate){
        characterPosition.setxPosition(xCoordinate);
    }

    @Override
    public void setYCoordinate(int yCoordinate){
        characterPosition.setyPosition(yCoordinate);
    }

    @Override
    public void setPosition(int xCoordinate, int yCoordinate) {
        characterPosition.setPosition(xCoordinate, yCoordinate);
    }

    @Override
    public Position getPosition(){
        return characterPosition;
    }

    @Override
    public int getCharacterID(){
        return characterID;
    }

    @Override
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public int getHealPoints() {
        return healthPoints;
    }

    @Override
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    @Override
    public int getAttackDamage() {
        return attackDamage;
    }

    @Override
    public void setCharacterID(int characterID){
        this.characterID = characterID;
    }

    @Override
    public void display() {
        System.out.println("character " + this.getClass() + " ID- " + characterID
                + " ,health, attackdamage and Position " + healthPoints + " " + attackDamage
                + " " + characterPosition.getxPosition() + "," + characterPosition.getyPosition());

    }
//    @Override
//    public boolean isInTheSameLocation(Character character2) {
//        return x == character2.getXCoordinate() && y == character2.getYCoordinate();
//    }
}
