package RomanNumbers;

import RomanNumbers.IRomanNumber;
import RomanNumbers.InvalidRomanNumeralOperation;
import RomanNumbers.RomanNumber;
import RomanNumbers.XRomanNumber;
import org.junit.Assert;
import org.junit.Test;

public class IRomanNumberTest {

    @Test
    public void should_return_0_when_I_minus_I() throws InvalidRomanNumeralOperation {
        RomanNumber iRomanNumber = new IRomanNumber();
        RomanNumber otherIRomanNumber = new IRomanNumber();
        Assert.assertEquals(0, iRomanNumber.minus(otherIRomanNumber));
    }

    @Test(expected = InvalidRomanNumeralOperation.class)
    public void should_throw_exception_when_I_minus_oprand_is_other_than_I() throws InvalidRomanNumeralOperation {
        RomanNumber iRomanNumber = new IRomanNumber();
        RomanNumber xRomanNumber = new XRomanNumber();
        iRomanNumber.minus(xRomanNumber);
    }
}