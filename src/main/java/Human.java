public class Human extends Character {

    Human()
    {
        super(100, 20, 1, false);
    }
    Human(double healthPoints, double attackDamage, int viewRange)
    {
        super.setHealthPoints(healthPoints);
        super.setAttackDamage(attackDamage);
        super.setViewRange(viewRange);
    }

}
