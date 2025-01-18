package grywojenne;

import org.junit.Test;
import static org.junit.Assert.*;

public class RankTest {
    @Test
    public void testGetValue() {
        assertEquals(1, Rank.PRIVATE.getValue());
        assertEquals(4, Rank.MAJOR.getValue());
    }
}