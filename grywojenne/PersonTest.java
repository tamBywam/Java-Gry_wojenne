package grywojenne;

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void testGetStrength() {
        Person p = new Soldier(Rank.PRIVATE);
        assertEquals(1, p.getStrength());
    }

    @Test
    public void testIsAlive() {
        Person p = new Soldier(Rank.PRIVATE);
        assertTrue(p.isAlive());
        ((Soldier) p).decreaseExperience();
        assertFalse(p.isAlive());
    }
}
