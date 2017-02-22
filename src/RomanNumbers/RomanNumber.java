package RomanNumbers;

public abstract class RomanNumber {


    protected final String symbol;
    protected final int value;

    public RomanNumber(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        RomanNumber other = (RomanNumber) obj;
        if (value == other.value && symbol.equals(other.symbol))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public boolean isGreaterThan(RomanNumber other) {
        return (value > other.value);
    }

    public int getValue(){
        return value;
    }
    public int plus(RomanNumber other) {
        return value + other.value;
    }

    public abstract int minus(RomanNumber other) throws InvalidRomanNumeralOperation;

}
