package game;

/***
 * Used in Tile
 * Sends To Board And To Game information about who to extract from the board
 * and how many people died to subtract them from numberOfTheirNation in amount of true values
 */
public class TileResolver {

    private final boolean humanDied;
    private final boolean infectedDied;

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
