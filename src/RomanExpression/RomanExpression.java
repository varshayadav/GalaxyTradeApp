package RomanExpression;

import RomanNumbers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanExpression {

    private List<RomanNumber> romanNumberSequence;

    public RomanExpression(List<RomanNumber> romanNumberSequence) {
        this.romanNumberSequence = romanNumberSequence;
    }

    @Override
    public boolean equals(Object obj) {
        RomanExpression other = (RomanExpression) obj;
        List<RomanNumber> otherRomanNumberSequence = other.romanNumberSequence;
        if (romanNumberSequence.equals(otherRomanNumberSequence))
            return true;
        return false;
    }

    private boolean is_valid() {
        return is_succession_of_I_X_M_valid() && is_V_L_D_repeatation_valid();
    }

    private boolean is_V_L_D_repeatation_valid() {
        List<RomanNumber> V_L_D = new ArrayList<>(Arrays.asList(new VRomanNumber(), new LRomanNumber(),
                new DRomanNumber()));

        for (RomanNumber romanNumber : V_L_D) {
            if (is_repeated(romanNumber))
                return false;
        }
        return true;
    }

    private boolean is_repeated(RomanNumber target) {
        int targetCount = 0;
        for (RomanNumber romanNumber : romanNumberSequence) {
            if (romanNumber.equals(target))
                targetCount++;
            if (targetCount > 1)
                return true;
        }
        return false;
    }

    private boolean is_succession_of_I_X_M_valid() {
        if(romanNumberSequence.size() <= 3){
            return true;
        }
        List<RomanNumber> I_X_M = new ArrayList<>(Arrays.asList(new IRomanNumber(), new XRomanNumber(),
                new MRomanNumber()));

        for (RomanNumber romanNumber : I_X_M) {
            if (more_than_3_times_in_succession(romanNumber))
                return false;
        }
        return true;
    }

    private boolean more_than_3_times_in_succession(RomanNumber target) {
        List<RomanNumber> succession_list = new ArrayList<>();

        for (RomanNumber romanNumber : romanNumberSequence) {
            if (romanNumber.equals(target))
                succession_list.add(romanNumber);
            else if (succession_list.size() <= 3) {
                succession_list.clear();
            }
            if (succession_list.size() > 3)
                return true;
        }
        return false;
    }



    public float evaluateExpression() throws InvalidRomanNumeralOperation, InvalidRomanExpression {
        if(!is_valid())
            throw new InvalidRomanExpression();
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
