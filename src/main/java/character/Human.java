package character;

public class Human extends Character {

    public Human() {
        super(55, 18);
    }

    public Human(int healthPoints, int attackDamage){
        super(healthPoints,attackDamage);
    }

    @Override
    public String toString() {
        return this.getClass() + "    ID "+ characterID + " "
                + " health " + healthPoints + "  attack damage "+ attackDamage;
    }
}
