package game;

public class TileResolver {

    private boolean humanDied;
    private boolean infectedDied;

    public TileResolver(boolean didHumanDie, boolean didInfectedDie){
        this.humanDied = didHumanDie;
        this.infectedDied = didInfectedDie;
    }

    public boolean checkIfHumanDied(){
        return humanDied;
    }
    public boolean checkIfInfectedDied(){
        return infectedDied;
    }
}
