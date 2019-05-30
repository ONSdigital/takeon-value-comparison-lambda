package uk.gov.ons.validation.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.gov.ons.validation.entity.InputData;
import uk.gov.ons.validation.entity.OutputData;

public class ValueComparison {

    private static final Logger LOG = LogManager.getLogger(ValueComparison.class);

    public OutputData apply(InputData input) {
        LOG.info("received: {}", input);
        return runValidationRule(input);
    }

    // Take the given data and invoke the validation rule
    private OutputData runValidationRule(InputData inputData) {
        RuleValueComparison rule = new RuleValueComparison(inputData);
        return new OutputData(rule.getValueFormula(), rule.run(), inputData.metaData, null);
    }
}
