package character;


public abstract class Character implements Personage {

    protected int characterID;

    protected int healthPoints;
    protected int attackDamage;

    public Character(int healthPoints, int attackDamage){
        this.healthPoints = healthPoints;
        this.attackDamage = attackDamage;
    }

    // ID is set when character is added to the board
    public void setCharacterID(int characterID){
        this.characterID = characterID;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void takeDamage(int opponentsAttackDamage){
        healthPoints -= opponentsAttackDamage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public String toString() {
            return this.getClass() + " ID "+ characterID + " "
                    + " health " + healthPoints + "  attack damage "+ attackDamage;
        }

}

//                    + " (" + characterPosition.getxPosition() + "," + characterPosition.getyPosition() + ")";
//
//    public int getCharacterID(){
//        return characterID;
//    }

//   public void setPosition(int xCoordinate, int yCoordinate) {
//        characterPosition.setPosition(xCoordinate, yCoordinate);
//    }
//
//    public Position getPosition(){
//        return characterPosition;
//    }

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