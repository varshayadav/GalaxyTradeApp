package RomanNumbers;

import RomanNumbers.IRomanNumber;
import RomanNumbers.RomanNumber;

public class XRomanNumber extends RomanNumber {
    public XRomanNumber() {
        super("X", 10);
    }

    @Override
    public int minus(RomanNumber other) throws InvalidRomanNumeralOperation {
        if (other.getClass() == IRomanNumber.class)
            return value - other.value;
        throw new InvalidRomanNumeralOperation();
    }
}
