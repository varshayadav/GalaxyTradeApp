package RomanNumbers;

import RomanNumbers.IRomanNumber;
import RomanNumbers.RomanNumber;

public class VRomanNumber extends RomanNumber {
    public VRomanNumber() {
        super("V", 5);
    }

    @Override
    public int minus(RomanNumber other) throws InvalidRomanNumeralOperation {
        if (other.getClass() == IRomanNumber.class)
            return value - other.value;
        throw new InvalidRomanNumeralOperation();
    }
}
