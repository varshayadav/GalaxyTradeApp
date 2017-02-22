package RomanNumbers;

public class DRomanNumber extends RomanNumber {
    public DRomanNumber() {
        super("D", 500);
    }

    @Override
    public int minus(RomanNumber other) throws InvalidRomanNumeralOperation {
        if (other.getClass() == CRomanNumber.class)
            return value - other.value;
        throw new InvalidRomanNumeralOperation();
    }
}
