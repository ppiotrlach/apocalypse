package game;

import java.util.List;

public interface Game {

    void everyoneFight();

    void checkIsSimulationOver();

    GameState getStateOfGame();

    String displayGame();

    void everyoneMove();

    void increaseEveryInfectedAttack();

    String displayAllCharactersOnBoard();
}
