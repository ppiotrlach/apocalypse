package board;

import character.Human;
import character.Infected;

public class Tile {

    private Human human;
    private Infected infected;

    public boolean isInteractionPossible(){
        return (human != null && infected != null);
    }

    public boolean isInfectedFree(){
        return (infected == null);
    }

    public boolean isHumanFree(){
        return (human == null);
    }

    public boolean isFree(){
        return (human == null && infected == null);
    }


    public void setHuman(Human human){
        this.human = human;
    }


    public void setInfected(Infected infected){
        this.infected = infected;
    }

    public void interact(SimpleBoard board){
        human.takeDamage(infected.getAttackDamage());
        infected.takeDamage(human.getAttackDamage());
        if(human.getHealthPoints()<=0){
            board.getMapOfHuman().remove(human.getCharacterID(), human);
            this.setHuman(null);
            board.decreaseNumberOfAllies();
        }
        if(infected.getHealthPoints()<=0){
            board.getMapOfInfected().remove(infected.getCharacterID(), infected);
            this.setInfected(null);
            board.decreaseNumberOfEnemies();
        }
    }

}


//    public void setCharacterable(Characterable characterable){
//        if(characterable instanceof Infected){
//            this.infected = (Infected)characterable;
//        }
//        else if(characterable instanceof Human){
//            this.human = (Human)characterable;
//        }
//        else{
//            throw new ClassNotPreparedException();
//        }
//    }
//
//    public Human getHuman(){
//        return human;
//    }
//
//    public Infected getInfected(){
//        return infected;
//    }