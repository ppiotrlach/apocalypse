package character;

import position.Position;

public abstract class Character {

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

    public void setPosition(int xCoordinate, int yCoordinate) {
        characterPosition.setPosition(xCoordinate, yCoordinate);
    }

    public Position getPosition(){
        return characterPosition;
    }


    public void setCharacterID(int characterID){
        this.characterID = characterID;
    }

    @Override
    public String toString() {
        return "character " + this.getClass() + " ID - " + characterID
                + " ,health, attackdamage and Position " + healthPoints + " " + attackDamage
                + " " + characterPosition.getxPosition() + "," + characterPosition.getyPosition();

    }
}


//
//    public void setHealthPoints(int healthPoints) {
//        this.healthPoints = healthPoints;
//    }
//
//
//    public int getHealthPoints() {
//        return healthPoints;
//    }
//
//    public void setAttackDamage(int attackDamage) {
//        this.attackDamage = attackDamage;
//    }
//
//
//    public int getAttackDamage() {
//        return attackDamage;
//    }



//    @Override
//    public boolean isInTheSameLocation(Character character2) {
//        return x == character2.getXCoordinate() && y == character2.getYCoordinate();
//    }