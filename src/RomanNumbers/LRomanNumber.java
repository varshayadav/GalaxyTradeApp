package RomanNumbers;

public class LRomanNumber extends RomanNumber {
    public LRomanNumber() {
        super("L", 50);
    }

    @Override
    public int minus(RomanNumber other) throws InvalidRomanNumeralOperation {
        if (other.getClass() == XRomanNumber.class)
            return value - other.value;
        throw new InvalidRomanNumeralOperation();
    }
}
