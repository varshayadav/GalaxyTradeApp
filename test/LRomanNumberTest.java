import org.junit.Assert;
import org.junit.Test;

public class LRomanNumberTest {
    @Test
    public void should_return_40_when_L_minus_X() throws InvalidRomanNumeralOperation {
        RomanNumber lRomanNumber = new LRomanNumber();
        RomanNumber xRomanNumber = new XRomanNumber();
        Assert.assertEquals(40, lRomanNumber.minus(xRomanNumber));
    }

    @Test(expected = InvalidRomanNumeralOperation.class)
    public void should_throw_exception_when_L_minus_oprand_is_other_than_X() throws InvalidRomanNumeralOperation {
        RomanNumber lRomanNumber = new LRomanNumber();
        RomanNumber cRomanNumber = new CRomanNumber();
        lRomanNumber.minus(cRomanNumber);
    }
}
