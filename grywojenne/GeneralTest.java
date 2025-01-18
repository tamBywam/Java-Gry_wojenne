
package grywojenne;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class GeneralTest {
    @Test
    public void testBuySoldierAndManeuvers() {
        General g = new General(100);
        g.buySoldier(Rank.PRIVATE);
        int before = g.getTotalStrength();
        g.doManeuvers(g.getArmy());
        Assert.assertTrue(g.getTotalStrength() > before);
    }

    @Test
    public void testAttack() {
        General g1 = new General(100);
        General g2 = new General(100);
        g1.buySoldier(Rank.MAJOR);
        g2.buySoldier(Rank.PRIVATE);
        g1.attack(g2);
        Assert.assertTrue(g1.getGold() != 100 || g2.getGold() != 100);
    }

    @Test
    public void testSaveLoad() throws Exception {
        General g = new General(50);
        g.buySoldier(Rank.CAPTAIN);
        String path = "general_save.dat";
        g.save(path);
        General g2 = General.load(path);
        new File(path).delete();
        Assert.assertEquals(g.getTotalStrength(), g2.getTotalStrength());
        Assert.assertEquals(g.getGold(), g2.getGold());
    }
}