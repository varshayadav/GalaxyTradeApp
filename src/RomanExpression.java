import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanExpression {

    private List<RomanNumber> romanNumberSequence;

    public RomanExpression(List<RomanNumber> romanNumberSequence) {
        this.romanNumberSequence = romanNumberSequence;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        RomanExpression other = (RomanExpression) obj;
        List<RomanNumber> otherRomanNumberSequence = other.romanNumberSequence;
        if (romanNumberSequence.equals(otherRomanNumberSequence))
            return true;
        return false;
    }


    public float evaluate_expression() throws InvalidRomanNumeralOperation, InvalidRomanExpression {
        List<RomanNumber> tmpRomanNumberSequence = new ArrayList<>(romanNumberSequence);
        float result = 0;
        while (!tmpRomanNumberSequence.isEmpty()) {
            result = result + evaluate(tmpRomanNumberSequence);
        }
        return result;
    }

    private float evaluate(List<RomanNumber> expression) throws InvalidRomanNumeralOperation {
        float result = 0;
        RomanNumber firstRomanNumber = expression.remove(0);
        if (!expression.isEmpty()) {
            RomanNumber secondRomanNumber = expression.get(0);
            if (secondRomanNumber.isGreaterThan(firstRomanNumber)) {
                result = result + secondRomanNumber.minus(firstRomanNumber);
                expression.remove(0);
            } else
                result = result + firstRomanNumber.getValue();
        } else
            result = result + firstRomanNumber.getValue();
        return result;
    }
}
