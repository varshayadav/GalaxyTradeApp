import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private RomanNumber getRomanNumber(String unit) throws InvalidInterGalacticalUnitString {
        if (unit.equals("glob")) {
            return new IRomanNumber();
        } else if (unit.equals("prok")) {
            return new VRomanNumber();
        } else if (unit.equals("pish")) {
            return  new XRomanNumber();
        } else if (unit.equals("tegj")) {
            return new LRomanNumber();
        } else {
            throw new InvalidInterGalacticalUnitString();
        }
    }

    public Utility createUtility(String name, String units, float credits) throws InvalidInterGalacticalUnitString, InvalidRomanNumeralOperation, InvalidRomanExpression {
        float quantity = calculateQuantity(units);
        float cost = credits / quantity;
        return new Utility(name, cost);
    }

    public float calculateQuantity(String expressionString) throws InvalidInterGalacticalUnitString, InvalidRomanExpression, InvalidRomanNumeralOperation {
        String[] unit_arr = expressionString.split(" ");
        List<RomanNumber> romanNumbers = new ArrayList<>();
        for (String unit : unit_arr) {
            romanNumbers.add(getRomanNumber(unit));
        }
        RomanExpression romanExpression = RomanExpressionFactory.create(romanNumbers);
        return romanExpression.evaluate_expression();
    }
}

