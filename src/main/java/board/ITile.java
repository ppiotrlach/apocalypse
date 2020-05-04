package board;

import character.Human;
import character.Infected;

public interface ITile {

    boolean isInteractionPossible();

    boolean isInfectedFree();

    boolean isHumanFree();

    boolean isFree();

    Human getHuman();

    Infected getInfected();

    void setHuman(Human human);

    void setInfected(Infected infected);

}
