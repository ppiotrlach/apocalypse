import game.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    Position position1;
    Position position2;
    Position position3;

    @Test
    public void creatingObjectWithSameArguments_returnsSameInstance(){
        position1 = Position.createPosition(1,2);
        position2 = Position.createPosition(1,2);
        position3 = Position.createPosition(position1.getxCoordinate(),position1.getyCoordinate());
        assertTrue(position1 == position2);
        assertTrue(position1 == position3);
        assertTrue(position2 == position3);
    }

    @Test
    public void creatingObjectWithDifferentArguments_returnsOtherInstance(){
        position1 = Position.createPosition(1,2);
        position2 = Position.createPosition(3,4);
        position3 = Position.createPosition(position1.getxCoordinate(),position1.getyCoordinate());
        assertFalse(position1 == position2);
        assertFalse(position2 == position3);
    }
}
