import java.util.ArrayList;

public interface Boardable {

    void initBoard();

    void addHuman(Human human);

    void addInfected(Infected infected);

    ArrayList<Human> getReferenceToListOfHuman();

    ArrayList<Infected> getReferenceToListOfInfected();

    void displayBoard();

    Tile[][] getReferenceToGrid();

    boolean isSimulationOver();
}
