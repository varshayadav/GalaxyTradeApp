package RomanNumbers;

import RomanNumbers.*;
import org.junit.Assert;
import org.junit.Test;

public class XRomanNumberTest {

    @Test
    public void should_return_9_when_X_minus_I() throws InvalidRomanNumeralOperation {
        RomanNumber xRomanNumber = new XRomanNumber();
        RomanNumber iRomanNumber = new IRomanNumber();
        Assert.assertEquals(9, xRomanNumber.minus(iRomanNumber));
    }

    @Test(expected = InvalidRomanNumeralOperation.class)
    public void should_throw_exception_when_X_minus_oprand_is_other_than_I() throws Exception, InvalidRomanNumeralOperation {
        RomanNumber xRomanNumber = new XRomanNumber();
        RomanNumber vRomanNumber = new VRomanNumber();
        xRomanNumber.minus(vRomanNumber);
    }

}