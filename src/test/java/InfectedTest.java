import org.junit.Test;

import static org.junit.Assert.*;

public class InfectedTest {

    @Test
    public void fight() {
        Human human = new Human();
        Human human2 = new Human(30,20,1);
        Infected infected = new Infected();

        infected.fight(human);

        assertEquals(100-human.getAttackDamage(), infected.getHealPoints(), 0);
        assertEquals(100-infected.getAttackDamage(), human.getHealPoints(), 0);

        infected.fight(human2);

        assertFalse(human.getIsInfected());
        assertTrue(human2.getIsInfected());
    }
}