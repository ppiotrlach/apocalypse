public abstract class Character implements Characterable {

    private int characterID;

    private int healthPoints;
    private int attackDamage;

    private Position characterPostion;

    public Character()
    {
        this(100,20,-1,-1,-1);
    }

    public Character(int healthPoints, int attackDamage, int x, int y){
        this(healthPoints,attackDamage,x,y,-1);
    }

    public Character(int healthPoints, int attackDamage, int x, int y, int characterID){
        this.healthPoints = healthPoints;
        this.attackDamage = attackDamage;
        this.characterPostion = new Position(x,y);
        this.characterID = characterID;
    }

    @Override
    public void setXCoordinate(int xCoordinate){
        characterPostion.setxPosition(xCoordinate);
    }

    @Override
    public void setYCoordinate(int yCoordinate){
        characterPostion.setyPosition(yCoordinate);
    }

    @Override
    public void setPosition(int xCoordinate, int yCoordinate) {
        characterPostion.setPosition(xCoordinate, yCoordinate);
    }

    @Override
    public Position getPosition(){
        return characterPostion;
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
    public String displayCharacter(){
        return "Character ID- " + characterID
                + " ,health, attackdamage and Position " + healthPoints + " " + attackDamage
                + " " + characterPostion.getxPosition() + "," + characterPostion.getyPosition();
    }

//    @Override
//    public boolean isInTheSameLocation(Character character2) {
//        return x == character2.getXCoordinate() && y == character2.getYCoordinate();
//    }
}
