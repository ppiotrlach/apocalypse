package game;

import character.Human;
import character.Infected;

import java.util.List;
import java.util.Map;

public interface Board {

        void addHumanToMap(Human human, int numberOfAllies);

        void addInfectedToMap(Infected infected, int numberOfEnemies);

        List<TileResolver> fight();

        void moveHuman(Position oldPosition, Position newPosition);

        void moveInfected(Position oldPosition, Position newPosition);

        void increaseInfectedAttack();

        boolean isTileInfectedFree(Position position);

        boolean isTileFree(Position position);

        boolean isTileHumanFree(Position position);

        void setTileToHuman(Position position, Human human);

        void setTileToInfected(Position position, Infected infected);

        void removeHumanFromTile(Position position);

        void removeInfectedFromTile(Position position);

        int getMapHeight();

        int getMapWidth();

        Map<Position,Tile> getMap();

        String displayAllCharactersOnMap();


}
