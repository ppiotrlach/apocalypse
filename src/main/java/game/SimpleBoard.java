package game;

import character.Human;
import character.Infected;
import character.Personage;
import displayer.PersonageDisplayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Maps Positions to Tiles
 * Contains information about map Size
 * Has abilities to add specified characters to map
 * Can command Personage to Move, fight or increase its attack
 */
public class SimpleBoard implements Board {

    private Map<Position,Tile> map;
    public final int mapHeight;
    public final int mapWidth;
    private RandomPositionGenerator randomPosGen;
    private PersonageDisplayer personDisplay = new PersonageDisplayer();

    public SimpleBoard(int mapHeight, int mapWidth){
        randomPosGen = new RandomPositionGenerator();
        this.map = new HashMap<>(mapHeight * mapWidth);
        this.mapHeight = mapHeight;
        this.mapWidth = mapWidth;
        this.initBoard();
    }


    private void initBoard(){
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                Position pos = Position.createPosition(i,j);
                map.put(pos, new Tile());
            }
        }
    }

    public void addHumanToMap(Human human, int numberOfAllies){
        if(this.isPossibleToAddNewCharacter(numberOfAllies)) {
            int temporary = numberOfAllies;
            while (temporary < numberOfAllies + 1) {
                Position randomPos = randomPosGen.generateRandomPosition(this);
                if (this.isTileHumanFree(randomPos)) {
                    this.setTileToHuman(randomPos, human);
                    setPersonsCharacterID(randomPos, human, numberOfAllies);
                    temporary++;
                }
            }
        }
        else{
            throw new NullPointerException();
        }
    }

    public void addInfectedToMap(Infected infected, int numberOfEnemies){
        if(isPossibleToAddNewCharacter(numberOfEnemies)) {
            int temporary = numberOfEnemies;
            while (temporary < numberOfEnemies + 1) {
                Position randomPos = randomPosGen.generateRandomPosition(this);
                if (isTileInfectedFree(randomPos)) {
                    setTileToInfected(randomPos,infected);
                    setPersonsCharacterID(randomPos, infected, numberOfEnemies);
                    temporary++;
                }
            }
        }
        else{
            throw new NullPointerException();
        }
    }
    

    private boolean isPossibleToAddNewCharacter(int numberOfSpecifiedNation) {
        if (numberOfSpecifiedNation <= mapHeight * mapWidth) {
            return true;
        } else {
            return false;
        }
    }
    
    public List<TileResult> fight(){
        List<TileResult> resolvers = new ArrayList<>(mapHeight * mapWidth);
        for (Map.Entry<Position, Tile> entry : map.entrySet()) {
            Tile tile = entry.getValue();
            TileResult resolver = tile.tileFights();
            resolvers.add(resolver);
        }
        return resolvers;
    }

    private void setPersonsCharacterID(Position position, Personage person, int characterID){
        map.get(position).setPersonsCharacterID(person, characterID);
    }

    public boolean isTileInfectedFree(Position position){
        return map.get(position).isInfectedFree();
    }

    public boolean isTileFree(Position position){
        return map.get(position).isFree();
    }

    public boolean isTileHumanFree(Position position){
        return map.get(position).isHumanFree();
    }

    public void setTileToHuman(Position position, Human human){
        map.get(position).setHuman(human);
    }

    public void setTileToInfected(Position position, Infected infected){
        map.get(position).setInfected(infected);
    }

    public void removeHumanFromTile(Position position){
        map.get(position).removeHuman();
    }

    public void removeInfectedFromTile(Position position){
        map.get(position).removeInfected();
    }

    public int getMapHeight(){
        return mapHeight;
    }

    public int getMapWidth(){
        return mapWidth;
    }

    public Map<Position,Tile> getMap(){
        return map;
    }

    public void moveHuman(Position oldPosition, Position newPosition){
        Human human = map.get(oldPosition).getHuman();
        removeHumanFromTile(oldPosition);
        setTileToHuman(newPosition, human);
    }

    public void moveInfected(Position oldPosition, Position newPosition){
        Infected infected = map.get(oldPosition).getInfected();
        removeInfectedFromTile(oldPosition);
        setTileToInfected(newPosition, infected);
    }

    public void increaseInfectedAttack(){
        for (Map.Entry<Position,Tile> entry : map.entrySet()) {
            Position pos = entry.getKey();
            Tile tile = entry.getValue();
            if(!isTileInfectedFree(pos))
            tile.getInfected().increaseAttack();
        }
    }

    public String displayAllCharactersOnMap(){
        return personDisplay.displayAllLivingCreatures(map);
    }

}
