package uk.gov.ons.validation.entity;

public class InputData {

    public String primaryValue = "";
    public String comparisonValue = "";
    public Object metaData = "{}";

    public InputData() {
    }

    public InputData(String primaryValue, String comparisonValue) {
        this.primaryValue = primaryValue;
        this.comparisonValue = comparisonValue;
    }

}
