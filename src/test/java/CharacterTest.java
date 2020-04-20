import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    Character character = new Human();


    @Test
    public void setHealthPoints() {
       character.setHealthPoints(55);
        assertEquals(55,character.getHealPoints(),0);
    }

    @Test
    public void getHealPoints() {
        // same as in setHealthPoints
    }

    @Test
    public void setAttackDamage() {
        character.setAttackDamage(55);
        assertEquals(55,character.getAttackDamage(),0);
    }

    @Test
    public void getAttackDamage() {
        //same as in setAttackDamage
    }

    @Test
    public void setIsInfected() {
        character.setIsInfected(true);
        assertTrue(character.getIsInfected());
    }

    @Test
    public void getIsInfected() {
        //same as in setIsInfected
    }

    @Test
    public void setLocation() {
        character.setLocation(2,3);
        assertEquals(2,character.getXCoordinate(),0);
        assertEquals(3,character.getYCoordinate(),0);
    }

    @Test
    public void getXCoordinate() {
        //same as in setLocation
    }

    @Test
    public void getYCoordinate() {
        //same as in setLocation
    }

    @Test
    public void moveX() {
        character.setLocation(0,0);
        character.moveX(1);
        assertEquals(1,character.getXCoordinate(),0);
    }

    @Test
    public void moveY() {
        character.setLocation(0,0);
        character.moveY(1);
        assertEquals(1,character.getYCoordinate(),0);
    }

    @Test
    public void setViewRange() {
        character.setViewRange(1);
        assertEquals(1,character.getViewRange(),0);
    }

    @Test
    public void getViewRange() {
        //same as in setViewRange
    }

    @Test
    public void setIsAlive() {
        character.setIsAlive(true);
        assertTrue(character.getIsAlive());
    }

    @Test
    public void getIsAlive() {
        //same as in setIsAlive
    }


    @Test
    public void isInTheSameLocation() {
        Character character2 = new Human();
        Character character3 = new Human();

        character.setLocation(0,0);
        character2.setLocation(0,0);
        character3.setLocation(1,0);

        assertTrue(character.isInTheSameLocation(character2));
        assertFalse(character.isInTheSameLocation(character3));
    }

}