package character;

import position.Position;

public abstract class Character {

    protected int characterID; //yes, it is useless XD

    protected int healthPoints;
    protected int attackDamage;

    protected Position characterPosition;



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


    public int getAttackDamage() {
        return attackDamage;
    }

    public void setCharacterID(int characterID){
        this.characterID = characterID;
    }

    public int getCharacterID(){
        return characterID;
    }

    public void takeDamage(int opponentsAttackDamage){
        healthPoints -= opponentsAttackDamage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public String toString() {
            return "character " + this.getClass() + " ID "+ characterID + " "
                    + ", health, attack damage and Position " + healthPoints + " " + attackDamage
                    + " (" + characterPosition.getxPosition() + "," + characterPosition.getyPosition() + ")";
        }

}


//
//    public void setHealthPoints(int healthPoints) {
//        this.healthPoints = healthPoints;
//    }
//
//    public void setAttackDamage(int attackDamage) {
//        this.attackDamage = attackDamage;
//    }
//
//    @Override
//    public boolean isInTheSameLocation(Character character2) {
//        return x == character2.getXCoordinate() && y == character2.getYCoordinate();
//    }