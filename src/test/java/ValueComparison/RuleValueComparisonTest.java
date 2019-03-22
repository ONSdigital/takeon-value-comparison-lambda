package ValueComparison;

import junit.framework.TestCase;
import uk.gov.ons.validation.entity.InputData;
import uk.gov.ons.validation.service.RuleValueComparison;

public class RuleValueComparisonTest extends TestCase {

    public void test_value1_NotEqualTo_value2_Triggers()  {
        InputData inputData = new InputData("2","1");
        RuleValueComparison rule = new RuleValueComparison(inputData);
        assertTrue(rule.run());
    }

    public void test_value1_EqualTo_value2_NotTriggered() {
        InputData inputData = new InputData("1.000001","1.000001");
        RuleValueComparison rule = new RuleValueComparison(inputData);
        assertFalse(rule.run());
    }

    public void test_value1_DecimalPlaces_EqualTo_value2_NotTriggered() {
        InputData inputData = new InputData("1.000000","1.00");
        RuleValueComparison rule = new RuleValueComparison(inputData);
        assertFalse(rule.run());
    }

    public void test_value1_Blanks_NotEqualTo_value2_NotTriggered() {
        InputData inputData = new InputData(""," ");
        RuleValueComparison rule = new RuleValueComparison(inputData);
        assertFalse(rule.run());
    }

    public void test_value1_Negative_NotEqualTo_value2_Triggers()  {
        InputData inputData = new InputData("-2","-1");
        RuleValueComparison rule = new RuleValueComparison(inputData);
        assertTrue(rule.run());
    }
}
