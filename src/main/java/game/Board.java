package game;

import character.Human;
import character.Infected;

import java.util.List;

public interface Board {

        void addHumanToMap(Human human, int numberOfAllies);

        void addInfectedToMap(Infected infected, int numberOfEnemies);

        List<TileResolver> fight();

        void moveHuman(Position oldPosition, Position newPosition);

        void moveInfected(Position oldPosition, Position newPosition);

        void increaseInfectedAttack();

}
