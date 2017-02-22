package app;

import RomanExpression.InvalidRomanExpression;
import RomanNumbers.InvalidRomanNumeralOperation;
import GalactialUtilities.InvalidUtilityException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws InvalidInterGalacticalUnitString, InvalidRomanNumeralOperation, InvalidRomanExpression, IOException {
        Parser parser = new Parser();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TraderApplication traderApplication = new TraderApplication(parser);

        traderApplication.setupApp();
        List utilityNames = traderApplication.getUtilitiesName();
        List unitNames = traderApplication.getUnitNames();

        System.out.println("Now you can ask your queries");
        System.out.println("Enter Exit for exiting from application");
        System.out.println("how much is ? .... enter query");
        while (true) {
            String query = bufferedReader.readLine();
            if (query.equalsIgnoreCase("Exit")) {
                break;
            }

            String utility = null;
            List<String> units = new ArrayList<>();

            String[] inputs = query.split(" ");

            for (String input : inputs) {
                if (utilityNames.contains(input))
                    utility = input;
                else if (unitNames.contains(input))
                    units.add(input);
                else
                    System.out.println("I have no idea what you are talking about" + input);
            }
            if (!units.isEmpty()) {
                try {
                    System.out.println(traderApplication.calculateCost(units, utility));
                } catch (InvalidUtilityException e1) {
                    System.out.println("Invalid GalactialUtilities.Utility");
                } catch (InvalidRomanNumeralOperation e2) {
                    System.out.println("Invalid Galactial Units");
                } catch (InvalidRomanExpression e3) {
                    System.out.println("Invalid order of Galactial Units");
                }
            }
        }
    }
}

