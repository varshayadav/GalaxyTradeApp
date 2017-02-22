package RomanNumbers;

import RomanNumbers.RomanNumber;

public class CRomanNumber extends RomanNumber {
    public CRomanNumber() {
        super("C", 100);
    }

    @Override
    public int minus(RomanNumber other) throws InvalidRomanNumeralOperation {
        if (other.getClass() == XRomanNumber.class)
            return value - other.value;
        throw new InvalidRomanNumeralOperation();
    }
}
