public interface Tilable {

    boolean isInteractionPossible();

    boolean isInfectedFree();

    boolean isHumanFree();

    boolean isFree();

    Human getHuman();

    Infected getInfected();

    void setHuman(Human human);

    void setInfected(Infected infected);

}
