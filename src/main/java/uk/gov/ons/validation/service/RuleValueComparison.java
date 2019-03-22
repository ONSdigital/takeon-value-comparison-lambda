package uk.gov.ons.validation.service;

import uk.gov.ons.validation.entity.InputData;

import java.math.BigDecimal;

public class RuleValueComparison {

    protected BigDecimal primaryValue;
    protected BigDecimal comparisonValue;

    public RuleValueComparison(InputData sourceInputData) {
        primaryValue = safeConvertToBigDecimal(sourceInputData.primaryValue);
        comparisonValue = safeConvertToBigDecimal(sourceInputData.comparisonValue);
    }

    public String getValueFormula() {
        return primaryValue.toString() + " != " + comparisonValue.toString();
    }

    public boolean run() {
        return primaryValue.compareTo(comparisonValue) != 0;
    }

    // Helper function
    private static BigDecimal safeConvertToBigDecimal(String string) {
        BigDecimal safeDecimal;
        try {
            safeDecimal = new BigDecimal(string);
        } catch (NumberFormatException | NullPointerException e) {
            safeDecimal = new BigDecimal(0);
        }
        return safeDecimal;
    }

}
