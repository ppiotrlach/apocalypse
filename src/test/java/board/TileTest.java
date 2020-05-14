package board;

import character.Human;
import character.Infected;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileTest {
    private Tile tile, tile2;
    private Human human;
    private Infected infected;
    private SimpleBoard simpleBoard;

    @Before
    public void setUp(){
        tile = new Tile();
        human = new Human();
        tile.setHuman(human);

    }

    @Test
    public void shouldSayHumanIsHere(){
        assertFalse(tile.isHumanFree());
    }

    @Test
    public void shouldSayInfectedIsNotHere(){
        assertTrue(tile.isInfectedFree());
    }

    @Test
    public void shouldSayInteractionIsNotPossible(){
        assertFalse(tile.isInteractionPossible());
    }

    // missing interact method test





}