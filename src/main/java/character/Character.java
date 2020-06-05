package character;

/***
 * Character is a object on Tile it can be a Human or Infected,
 * It has character ID Attack damage and healthPoints
 */
public abstract class Character implements Personage {

    protected int characterID;

    protected int healthPoints;
    protected int attackDamage;

    public Character(int healthPoints, int attackDamage){
        this.healthPoints = healthPoints;
        this.attackDamage = attackDamage;
    }

    /***
     *     // ID is set when character is added to the board
     * @param characterID it's number of its nation at the time
     */
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