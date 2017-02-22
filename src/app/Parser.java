package app;

import RomanNumbers.*;

public class Parser {


    public RomanNumber buildRomanNumber(String symbol) throws InvalidInterGalacticalUnitString {
        if (symbol.equals("I")) {
            return new IRomanNumber();
        } else if (symbol.equals("V")) {
            return new VRomanNumber();
        } else if (symbol.equals("X")) {
            return new XRomanNumber();
        } else if (symbol.equals("L")) {
            return new LRomanNumber();
        } else if (symbol.equals("C")) {
            return new CRomanNumber();
        } else if (symbol.equals("D")) {
            return new DRomanNumber();
        } else if (symbol.equals("M")) {
            return new MRomanNumber();
        } else {
            throw new InvalidInterGalacticalUnitString();
        }
    }
}

