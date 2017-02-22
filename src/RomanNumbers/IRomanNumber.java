package RomanNumbers;

public class IRomanNumber extends RomanNumber {
    public IRomanNumber() {
        super("I", 1);
    }

    @Override
    public int minus(RomanNumber other) throws InvalidRomanNumeralOperation {
        if (other.getClass() == IRomanNumber.class)
            return value - other.value;
        throw new InvalidRomanNumeralOperation();
    }

}
