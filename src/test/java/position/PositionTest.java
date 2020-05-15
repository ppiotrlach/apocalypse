package position;

import character.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
    private Position position;

    @Before
    public void setUp(){
        position = new Position(10,15);
    }

    @Test
    public void shouldSayThat10IsXPosition(){
        assertEquals(10, position.getxPosition());
    }

    @Test
    public void shouldSayThat15IsYPosition(){
        assertEquals(15, position.getyPosition());
    }
}