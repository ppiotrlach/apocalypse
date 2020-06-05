package character;

public interface Personage {
    void setCharacterID(int characterID);

    int getAttackDamage();

    void takeDamage(int opponentsAttackDamage);

    int getHealthPoints();

}
