package character;

import position.Position;

public interface ICharacter {

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

//    boolean isInTheSameLocation(Character character2);

}
