package uk.gov.ons.validation.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutputData {

    public String valueFormula = null;
    public Boolean triggered = null;
    public Object metaData = null;
    public Object error = null;

    public OutputData(String valueFormula, Boolean triggered, Object metaData, Object error) {
        this.valueFormula = valueFormula;
        this.triggered = triggered;
        this.metaData = metaData;
        this.error = error;
    }

    public OutputData() {
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "valueFormula='" + valueFormula + '\'' +
                ", triggered=" + triggered +
                ", metaData=" + metaData +
                ", error=" + error +
                '}';
    }
}
