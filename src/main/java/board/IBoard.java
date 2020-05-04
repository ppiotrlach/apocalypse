package board;

import character.Human;
import character.Infected;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.List;

public interface IBoard {

    void addHuman(Human human);

    void addInfected(Infected infected);

    boolean isSimulationOver();
}
