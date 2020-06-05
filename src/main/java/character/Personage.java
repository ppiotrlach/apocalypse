package character;

public interface Personage {

    public void setCharacterID(int characterID);

    public int getAttackDamage();

    public void takeDamage(int opponentsAttackDamage);

    public int getHealthPoints();

}
