package RomanNumbers;

import RomanNumbers.*;
import org.junit.Assert;
import org.junit.Test;

public class DRomanNumberTest {

    @Test
    public void should_return_400_when_D_minus_C() throws InvalidRomanNumeralOperation {
        RomanNumber dRomanNumber = new DRomanNumber();
        RomanNumber cRomanNumber = new CRomanNumber();
        Assert.assertEquals(400, dRomanNumber.minus(cRomanNumber));
    }

    @Test(expected = InvalidRomanNumeralOperation.class)
    public void should_throw_exception_when_D_minus_oprand_is_other_than_C() throws InvalidRomanNumeralOperation {
        RomanNumber dRomanNumber = new DRomanNumber();
        RomanNumber vRomanNumber = new VRomanNumber();
        dRomanNumber.minus(vRomanNumber);
    }

}