package game;

import character.Human;
import character.Infected;
import character.Personage;

public class Tile {

    private Human human;
    private Infected infected;

    private boolean isInteractionPossible(){
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

    public void removeHuman(){
        this.human = null;
    }

    public void removeInfected(){
        this.infected = null;
    }

    public void setPersonsCharacterID(Personage person, int characterID){
        person.setCharacterID(characterID);
    }

    public Human getHuman(){
        return human;
    }

    public Infected getInfected(){
        return infected;
    }

    public TileResolver tileFights() {
        boolean didHumanDie = false, didInfectedDie = false;
        if (isInteractionPossible()){
            human.takeDamage(infected.getAttackDamage());
            infected.takeDamage(human.getAttackDamage());
            if (human.getHealthPoints() <= 0) {
                this.removeHuman();
                didHumanDie = true;
            }
            if (infected.getHealthPoints() <= 0) {
                this.removeInfected();
                didInfectedDie = true;
            }
        }
        return new TileResolver(didHumanDie, didInfectedDie);
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
