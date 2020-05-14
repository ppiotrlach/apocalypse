package character;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {
    private Character human;
    private Character infected;

    @Before
    public void setUp(){
        human = new Human(30,20);
        infected = new Infected(30,30);
    }

    @Test
    public void shouldSayHumanAdIs20(){
        assertEquals(20, human.getAttackDamage());
    }

    @Test
    public void shouldSayHumanDied(){
        human.takeDamage(infected.getAttackDamage());
        assertEquals(0, human.getHealthPoints());
    }




}