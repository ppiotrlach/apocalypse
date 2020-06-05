package displayer;

import character.Personage;
import game.Position;
import game.Tile;

import java.util.Map;

public class PersonageDisplayer {

    private String personageToStringWithPosition(Personage person, Position pos){
        return person.toString() + " and Position (" + pos.getxCoordinate()+ " , " + pos.getyCoordinate() +")";
    }

    public String displayAllLivingCreatures(Map<Position,Tile> map){
        String result = "";
        for (Map.Entry<Position,Tile> entry : map.entrySet()) {
            Position pos = entry.getKey();
            Tile tile = entry.getValue();
            if(!tile.isInfectedFree()) {
                result += this.personageToStringWithPosition(tile.getInfected(), pos);
                result += "\n";
            }
            if(!tile.isHumanFree()) {
                result += this.personageToStringWithPosition(tile.getHuman(), pos);
                result += "\n";
            }
        }
        return result;
    }

}
