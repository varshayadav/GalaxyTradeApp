public class App {

    public static void main(String[] args) throws InvalidInterGalacticalUnitString, InvalidRomanNumeralOperation, InvalidRomanExpression {
        String[] input = {"glob is I",
                "prok is V", "pish is X", "tegj is L",
                "glob glob Silver is 34 Credits",
                "glob prok Gold is 57800 Credits",
                "pish pish Iron is 3910 Credits"};

        Parser parser = new Parser();
        Utility silver = parser.createUtility("Silver", "glob glob", 34);
        Utility gold = parser.createUtility("Gold", "glob prok", 57800);
        Utility iron = parser.createUtility("Iron", "pish pish", 3910);

        float quantity = 0;

        try {
            System.out.println("pish tegj glob glob");
            System.out.println(parser.calculateQuantity("pish tegj glob glob"));

            System.out.println("how many Credits is glob prok Silver ?");
            quantity = parser.calculateQuantity("glob prok");
            System.out.println(silver.calculateCredits(quantity));

            System.out.println("how many Credits is glob prok Gold ?");
            quantity = parser.calculateQuantity("glob prok");
            System.out.println(gold.calculateCredits(quantity));


            System.out.println("how many Credits is glob prok Iron ?");
            quantity = parser.calculateQuantity("glob prok");
            System.out.println(iron.calculateCredits(quantity));

            System.out.println("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
            parser.calculateQuantity("woodchuck chuck");
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}

