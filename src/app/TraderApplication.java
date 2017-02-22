package app;

import RomanExpression.InvalidRomanExpression;
import RomanExpression.RomanExpression;
import RomanNumbers.InvalidRomanNumeralOperation;
import RomanNumbers.RomanNumber;
import GalactialUtilities.InvalidUtilityException;
import GalactialUtilities.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TraderApplication {

    Parser parser;
    HashMap<String, RomanNumber> unitToRomanNumberMapping;
    BufferedReader bufferedReader;
    List<Utility> utilities;

    public TraderApplication(Parser parser) {
        this.parser = parser;
        this.unitToRomanNumberMapping = new HashMap<>();
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.utilities = new ArrayList<>();
    }

    public void setupApp() throws IOException, InvalidInterGalacticalUnitString, InvalidRomanNumeralOperation, InvalidRomanExpression {
        buildUnits();
        System.out.println("Congrats All units are setup now");
        buildUtilities();
        System.out.println("Congrats All utilities are setup now");
    }

    public List<String> getUtilitiesName(){
        List<String> utilityNames = new ArrayList<>();
        for(Utility utility: utilities){
            utilityNames.add(utility.getName());
        }
        return utilityNames;
    }

    public List getUnitNames(){
        List unitNames = new ArrayList(unitToRomanNumberMapping.keySet());
        return unitNames;
    }

    private void buildUtilities() throws IOException, InvalidInterGalacticalUnitString, InvalidRomanNumeralOperation, InvalidRomanExpression {
        String units, utilityName;
        List<String> unitList;

        float credits = 0, quantity = 0, costPerUnit;

        System.out.println("Enter utilities information");
        System.out.println("Enter done when done");
        while (true) {
            System.out.println("Enter galactial unit");
            units = bufferedReader.readLine();            // glob glob
            if (units.equalsIgnoreCase("done"))
                break;
            unitList = new ArrayList<>(Arrays.asList(units.split(" ")));
            System.out.println("Enter utility name");
            utilityName = bufferedReader.readLine();     // Silver
            System.out.println("Enter utility credits");
            credits = Integer.parseInt(bufferedReader.readLine());  // 34

            quantity = calculateQuantityFromUnits(unitList);
            costPerUnit = credits / quantity;
            utilities.add(new Utility(utilityName, costPerUnit));
        }
    }

    public void buildUnits() throws InvalidInterGalacticalUnitString, IOException {
        String input, unit, romanSymbol;
        String[] inputs;

        System.out.println("Enter unit information and enter done when done");
        while (true) {
            input = bufferedReader.readLine(); //"glob is I";
            if (input.equalsIgnoreCase("done"))
                break;
            inputs = input.split(" ");
            unit = inputs[0];
            romanSymbol = inputs[2];
            unitToRomanNumberMapping.put(unit.toLowerCase(), parser.buildRomanNumber(romanSymbol));
        }
    }

    public float calculateQuantityFromUnits(List<String> units) throws InvalidRomanNumeralOperation, InvalidRomanExpression {
        RomanExpression romanExpression = buildExpression(units);
        return romanExpression.evaluateExpression();
    }

    private RomanExpression buildExpression(List<String> units) {
        List<RomanNumber> romanNumbers = new ArrayList<>();
        for (String unit: units){
            romanNumbers.add(unitToRomanNumberMapping.get(unit.toLowerCase()));
        }
        return new RomanExpression(romanNumbers);
    }

    public float calculateCost(List<String> units, String utilityName) throws InvalidRomanNumeralOperation, InvalidRomanExpression, InvalidUtilityException {
        float quantity = calculateQuantityFromUnits(units);
        if(utilityName == null)
            return quantity;
        else{
            Utility targetUtility = findUtility(utilityName);
            return targetUtility.calculateCredits(quantity);
        }
    }

    private Utility findUtility(String utilityName) throws InvalidUtilityException {
        for(Utility utility: utilities){
            if (utility.getName().equalsIgnoreCase(utilityName)){
                return utility;
            }
        }
        throw new InvalidUtilityException();
    }


}

