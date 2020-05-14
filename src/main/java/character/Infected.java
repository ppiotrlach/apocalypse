package character;

public class Infected extends Character {

    //private int viewRange;//not done

    public Infected() {
        super(40, 15);
    }

    public void increaseAttack() {
        this.attackDamage += 1;
    }

}


//    public void fight(Character character2) {
//        if(character2 instanceof Human)
//        {
//            if(getIsAlive() && character2.getIsAlive() && isInTheSameLocation(character2))
//            {
//                setHealthPoints(getHealPoints() - character2.getAttackDamage());
//                character2.setHealthPoints(character2.getHealPoints()-getAttackDamage());
//                if(character2.getHealPoints() <= 0) {
//                    character2.setIsInfected(true);
//                    character2 = new Infected();
//
//                }
//            }
//        }
//    }