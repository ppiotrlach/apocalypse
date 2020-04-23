public class Infected extends Character implements Fightable{

    private int viewRange;//not done

    public Infected(){
        super();
    }

    @Override
    public void fight(Human human) {
        //not done

    }

    @Override
    public void findClosestEnemy() {
        //not done

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
}
