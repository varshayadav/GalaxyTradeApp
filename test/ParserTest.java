import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.logging.Level.parse;

public class ParserTest {

    @Test
    public void createUtility() throws InvalidInterGalacticalUnitString, InvalidRomanNumeralOperation, InvalidRomanExpression {
        String quantity_string = "pish pish";
        float utility_value = 1000;
        Parser parser = new Parser();
        Utility gold = parser.createUtility("Gold", quantity_string, utility_value);
        Assert.assertEquals(50, gold.getCost(), 0);
    }

    @Test
    public void calculateQuantity() throws InvalidInterGalacticalUnitString, InvalidRomanNumeralOperation, InvalidRomanExpression {
        String quantity_string = "pish glob";
        Parser parser = new Parser();
        Assert.assertEquals(11, parser.calculateQuantity(quantity_string), 0);
    }

    @Test( expected = InvalidInterGalacticalUnitString.class)
    public void shoul_throw_exception_when_unit_is_invalid() throws InvalidInterGalacticalUnitString, InvalidRomanNumeralOperation, InvalidRomanExpression {
        String quantity_string = "woodchuck chuck";
        Parser parser = new Parser();
        parser.calculateQuantity(quantity_string);
    }
}
