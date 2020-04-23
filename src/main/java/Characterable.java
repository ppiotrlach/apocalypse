public interface Characterable {

    void setHealthPoints(int healhPoints);
    int getHealPoints();

    void setAttackDamage(int attackDamage);
    int getAttackDamage();

    void setXCoordinate(int xCoordinate);

    void setYCoordinate(int yCoordinate);

    void setPosition(int xCoordinate, int yCoordinate);

    Position getPosition();

    int getCharacterID();

    void setCharacterID(int characterID);

    String displayCharacter();

//    boolean isInTheSameLocation(Character character2);

}
