package grywojenne;

import org.junit.Test;
import static org.junit.Assert.*;

public class SecretaryTest {
    @Test
    public void testLogAction() {
        Secretary s = new Secretary();
        s.logAction("First action");
        assertTrue(s.getReports().contains("First action"));
    }

    @Test
    public void testGetReports() {
        Secretary s = new Secretary();
        s.logAction("Second action");
        assertEquals(1, s.getReports().size());
    }

    @Test
    public void testPrintReports() {
        Secretary s = new Secretary();
        s.logAction("Just logging");
        s.printReports();
    }
}

public class SecretaryTest {
    
}
