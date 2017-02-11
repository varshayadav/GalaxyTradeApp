import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanExpressionFactory {
    static List<RomanNumber> romanNumberSequence;

    public static RomanExpression create(List<RomanNumber> romanNumbers) throws InvalidRomanExpression {
        romanNumberSequence = romanNumbers;
        if(is_valid())
            return new RomanExpression(romanNumbers);
        throw new InvalidRomanExpression();
    }

    private static boolean is_valid() {
        return is_succession_of_I_X_M_valid() && is_V_L_D_repeatation_valid();
    }

    private static boolean is_V_L_D_repeatation_valid() {
        List<RomanNumber> V_L_D = new ArrayList<>(Arrays.asList(new VRomanNumber(), new LRomanNumber(),
                new DRomanNumber()));

        for (RomanNumber romanNumber : V_L_D) {
            if (is_repeated(romanNumber))
                return false;
        }
        return true;
    }

    private static boolean is_repeated(RomanNumber target) {
        int targetCount = 0;
        for (RomanNumber romanNumber : romanNumberSequence) {
            if (romanNumber.equals(target))
                targetCount++;
            if (targetCount > 1)
                return true;
        }
        return false;
    }

    private static boolean is_succession_of_I_X_M_valid() {
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

    private static boolean more_than_3_times_in_succession(RomanNumber target) {
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

}
