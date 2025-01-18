package grywojenne;

import org.junit.Test;
import static org.junit.Assert.*;

public class SoldierFactoryTest {
    @Test
    public void testCreateSoldier() {
        Soldier s = SoldierFactory.createSoldier(Rank.PRIVATE);
        assertNotNull(s);
        assertEquals(Rank.PRIVATE, s.getRank());
        assertEquals(1, s.getExperience());
    }

    @Test
    public void testCreateSoldierWithDifferentRanks() {
        Soldier s1 = SoldierFactory.createSoldier(Rank.CORPORAL);
        Soldier s2 = SoldierFactory.createSoldier(Rank.CAPTAIN);
        assertNotNull(s1);
        assertNotNull(s2);
        assertEquals(Rank.CORPORAL, s1.getRank());
        assertEquals(Rank.CAPTAIN, s2.getRank());
    }
}
