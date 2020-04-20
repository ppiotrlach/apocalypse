public class Infected extends Character implements Fightable{

    Infected()
    {
        super(100, 30, 2, true);
    }

    Infected(double healthPoints, double attackDamage, int viewRange)
    {
        super.setHealthPoints(healthPoints);
        super.setAttackDamage(attackDamage);
        super.setViewRange(viewRange);
    }


    public void fight(Character character2) {
        if(character2 instanceof Human)
        {
            if(getIsAlive() && character2.getIsAlive() && isInTheSameLocation(character2))
            {
                setHealthPoints(getHealPoints() - character2.getAttackDamage());
                character2.setHealthPoints(character2.getHealPoints()-getAttackDamage());
                if(character2.getHealPoints() <= 0) {
                    character2.setIsInfected(true);
                    character2 = new Infected();
                }
            }
        }
    }
}
