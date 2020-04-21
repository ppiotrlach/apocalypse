public interface Characterable {

    public void setHealthPoints(int healhPoints);
    public int getHealPoints();

    public void setAttackDamage(int attackDamage);
    public int getAttackDamage();

    public void setXCoordinate(int xCoordinate);

    public void setYCoordinate(int yCoordinate);

    public void setPosition(int xCoordinate, int yCoordinate);

    public Position getPosition();

    public int getCharacterID();

    public void setCharacterID(int characterID);

    public String displayCharacter();

//    boolean isInTheSameLocation(Character character2);

}
