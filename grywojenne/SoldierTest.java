package grywojenne;

import org.junit.Test;
import static org.junit.Assert.*;

public class SoldierTest {
    @Test
    public void testGetStrength() {
        Soldier s = SoldierFactory.createSoldier(Rank.PRIVATE);
        assertEquals(1, s.getStrength());
    }

    @Test
    public void testIncreaseExperience() {
        Soldier s = SoldierFactory.createSoldier(Rank.PRIVATE);
        s.increaseExperience();
        assertEquals(2, s.getExperience());
    }

    @Test
    public void testDecreaseExperience() {
        Soldier s = SoldierFactory.createSoldier(Rank.CORPORAL);
        s.decreaseExperience();
        assertEquals(0, s.getExperience());
        assertFalse(s.isAlive());
    }

    @Test
    public void testGetRankAndExperience() {
        Soldier s = SoldierFactory.createSoldier(Rank.MAJOR);
        assertEquals(Rank.MAJOR, s.getRank());
        assertEquals(1, s.getExperience());
    }

    @Test
    public void testPromote() {
        Soldier s = SoldierFactory.createSoldier(Rank.PRIVATE);
        for (int i = 0; i < 5; i++) {
            s.increaseExperience();
        }
        assertEquals(Rank.CORPORAL, s.getRank());
        assertEquals(1, s.getExperience());
    }

    @Test
    public void testIsAlive() {
        Soldier s = SoldierFactory.createSoldier(Rank.PRIVATE);
        s.decreaseExperience();
        assertFalse(s.isAlive());
    }
}
