package RomanExpression;

import RomanNumbers.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanExpressionTest {
    
    @Test
    public void should_return_true_if_expression_is_same() throws Exception, InvalidRomanExpression {
        RomanNumber vRomanNumber = new VRomanNumber();
        List roman_number_sequence1 = new ArrayList(Arrays.asList(vRomanNumber));
        List roman_number_sequence2 = new ArrayList(Arrays.asList(vRomanNumber));
        RomanExpression romanExpression1 = new RomanExpression(roman_number_sequence1);
        RomanExpression romanExpression2 = new RomanExpression(roman_number_sequence2);
        Assert.assertEquals(romanExpression1, romanExpression2);
    }

    @Test
    public void should_return_false_if_expression_is_not_same() {
        RomanNumber vRomanNumber = new VRomanNumber();
        RomanNumber iRomanNumber = new IRomanNumber();
        List roman_number_sequence1 = new ArrayList(Arrays.asList(vRomanNumber));
        List roman_number_sequence2 = new ArrayList(Arrays.asList(iRomanNumber));
        RomanExpression romanExpression1 = new RomanExpression(roman_number_sequence1);
        RomanExpression romanExpression2 = new RomanExpression(roman_number_sequence2);

        Assert.assertNotEquals(romanExpression1, romanExpression2);
    }

    @Test
    public void evaluate_expression_V() throws Exception, InvalidRomanNumeralOperation, InvalidRomanExpression {
        RomanNumber vRomanNumber = new VRomanNumber();
        List<RomanNumber> roman_number_sequence1 = new ArrayList(Arrays.asList(vRomanNumber));
        RomanExpression romanExpression = new RomanExpression(roman_number_sequence1);
        Assert.assertEquals(5, romanExpression.evaluateExpression(), 0);

    }

    @Test
    public void evaluate_expression() throws Exception, InvalidRomanNumeralOperation, InvalidRomanExpression {
        RomanNumber vRomanNumber = new VRomanNumber();
        RomanNumber iRomanNumber = new IRomanNumber();
        RomanNumber mRomanNumber = new MRomanNumber();
        RomanNumber cRomanNumber = new CRomanNumber();
        RomanNumber xRomanNumber = new XRomanNumber();
        RomanNumber lRomanNumber = new LRomanNumber();

        List<RomanNumber> roman_number_sequence = new ArrayList(Arrays.asList(mRomanNumber, cRomanNumber, mRomanNumber, xRomanNumber,
                lRomanNumber, iRomanNumber, vRomanNumber));
        RomanExpression romanExpression = new RomanExpression(roman_number_sequence);
        Assert.assertEquals(1944, romanExpression.evaluateExpression(), 0);
    }

    @Test
    public void shoul_validate_if_CCC() throws Exception, InvalidRomanExpression {
        RomanNumber cRomanNumber = new CRomanNumber();
        List<RomanNumber> roman_number_sequence = new ArrayList(Arrays.asList(cRomanNumber, cRomanNumber, cRomanNumber));
        RomanExpression romanExpression = new RomanExpression(roman_number_sequence);
    }

    @Test(expected = InvalidRomanExpression.class)
    public void shoul_not_validate_if_IIII() throws Exception, InvalidRomanExpression {
        RomanNumber iRomanNumber = new IRomanNumber();
        List<RomanNumber> roman_number_sequence = new ArrayList(Arrays.asList(iRomanNumber, iRomanNumber, iRomanNumber, iRomanNumber));
        RomanExpression romanExpression = new RomanExpression(roman_number_sequence);
        romanExpression.evaluateExpression();
    }

    @Test
    public void should_validate_if_MMMCM() throws Exception, InvalidRomanExpression {
        RomanNumber mRomanNumber = new MRomanNumber();
        RomanNumber cRomanNumber = new CRomanNumber();
        List<RomanNumber> roman_number_sequence = new ArrayList(Arrays.asList(mRomanNumber, mRomanNumber, mRomanNumber, cRomanNumber, mRomanNumber));
        RomanExpression romanExpression = new RomanExpression(roman_number_sequence);
    }

    @Test(expected = InvalidRomanExpression.class)
    public void should_not_validate_if_D_is_repeated() throws Exception, InvalidRomanExpression {
        RomanNumber dRomanNumber = new DRomanNumber();
        List roman_number_sequence = new ArrayList(Arrays.asList(dRomanNumber, dRomanNumber));
        RomanExpression romanExpression = new RomanExpression(roman_number_sequence);
        romanExpression.evaluateExpression();
    }

    @Test
    public void should_validate_if_L_is_not_repeated() throws Exception, InvalidRomanExpression {
        RomanNumber cRomanNumber = new CRomanNumber();
        RomanNumber lRomanNumber = new LRomanNumber();
        List roman_number_sequence = new ArrayList(Arrays.asList(cRomanNumber, lRomanNumber));
        RomanExpression romanExpression = new RomanExpression(roman_number_sequence);
    }


}
