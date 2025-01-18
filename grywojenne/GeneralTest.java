package grywojenne;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
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

    @Test
    public void testSetSecretary() {
        General g = new General(50);
        Secretary s = new Secretary();
        g.setSecretary(s);
        g.buySoldier(Rank.PRIVATE);
        Assert.assertNotNull(s.getReports());
    }

    @Test
    public void testGetTotalStrength() {
        General g = new General(70);
        g.buySoldier(Rank.PRIVATE);
        Assert.assertTrue(g.getTotalStrength() > 0);
    }

    @Test
    public void testGetGold() {
        General g = new General(100);
        Assert.assertEquals(100, g.getGold());
    }

    @Test
    public void testGetArmy() {
        General g = new General(100);
        g.buySoldier(Rank.MAJOR);
        Assert.assertEquals(1, g.getArmy().size());
    }

    @Test
    public void testDoManeuvers() {
        General g = new General(100);
        g.buySoldier(Rank.PRIVATE);
        int before = g.getArmy().get(0).getExperience();
        g.doManeuvers(g.getArmy());
        assertTrue(g.getArmy().get(0).getExperience() > before);
    }

    @Test
    public void testShootRandomSoldier() {
        General g = new General(100);
        g.buySoldier(Rank.PRIVATE);
        g.buySoldier(Rank.CORPORAL);
        int before = g.getArmy().size();
        g.attack(new General(100)); // Force a draw
        assertTrue(g.getArmy().size() <= before);
    }
}