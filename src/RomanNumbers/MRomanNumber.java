package RomanNumbers;

public class MRomanNumber extends RomanNumber {
    public MRomanNumber() {
        super("M", 1000);
    }

    @Override
    public int minus(RomanNumber other) throws InvalidRomanNumeralOperation {
        if (other.getClass() == CRomanNumber.class)
            return value - other.value;
        else
            throw new InvalidRomanNumeralOperation();
    }
}
