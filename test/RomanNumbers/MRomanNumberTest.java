package RomanNumbers;

import RomanNumbers.*;
import org.junit.Assert;
import org.junit.Test;

public class MRomanNumberTest {
    @Test
    public void should_return_900_when_M_minus_C() throws InvalidRomanNumeralOperation {
        RomanNumber mRomanNumber = new MRomanNumber();
        RomanNumber cRomanNumber = new CRomanNumber();
        Assert.assertEquals(900, mRomanNumber.minus(cRomanNumber));
    }

    @Test(expected = InvalidRomanNumeralOperation.class)
    public void should_throw_exception_when_M_minus_oprand_is_other_than_C() throws InvalidRomanNumeralOperation {
        RomanNumber mRomanNumber = new MRomanNumber();
        RomanNumber vRomanNumber = new VRomanNumber();
        mRomanNumber.minus(vRomanNumber);
    }
}