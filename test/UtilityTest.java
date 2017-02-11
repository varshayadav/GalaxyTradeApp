import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilityTest {
    @Test
    public void test() throws Exception {
        Utility gold = new Utility("Gold", 1000);
        int gold_quantity = 5;
        Assert.assertEquals(5000, gold.calculateCredits(gold_quantity), 0);
    }
}