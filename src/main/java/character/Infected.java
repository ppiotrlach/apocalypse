package character;

public class Infected extends Character {

    public Infected() {

        super(55, 10);
    }

    public void increaseAttack(){
        this.attackDamage += 1;
    }

}
