package game;

import character.Human;
import character.Infected;
import character.Personage;

/***
 * Object contains two objects Human and Infected meaning that only one human and one infected can stand on each position
 * Contains system of fighting between two characters and returns TileResolver with true value for every character that died
 */
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

    public TileResult tileFights() {
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
        return new TileResult(didHumanDie, didInfectedDie);
    }

}