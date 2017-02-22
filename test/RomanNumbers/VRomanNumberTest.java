package RomanNumbers;

import RomanNumbers.*;
import org.junit.Assert;
import org.junit.Test;

public class VRomanNumberTest {
    @Test
    public void should_return_4_when_V_minus_I() throws InvalidRomanNumeralOperation {
        RomanNumber vRomanNumber = new VRomanNumber();
        RomanNumber iRomanNumber = new IRomanNumber();
        Assert.assertEquals(4, vRomanNumber.minus(iRomanNumber));
    }

    @Test(expected = InvalidRomanNumeralOperation.class)
    public void should_throw_exception_when_V_minus_oprand_is_other_than_I() throws InvalidRomanNumeralOperation {
        RomanNumber vRomanNumber = new VRomanNumber();
        RomanNumber xRomanNumber = new XRomanNumber();
        vRomanNumber.minus(xRomanNumber);
    }

}