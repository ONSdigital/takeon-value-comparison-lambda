package uk.gov.ons.validation.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.gov.ons.validation.entity.InputData;
import uk.gov.ons.validation.entity.OutputData;
import uk.gov.ons.validation.service.ValueComparison;

public class Handler implements RequestHandler<InputData, OutputData> {

    private static final Logger LOG = LogManager.getLogger(Handler.class);

    @Override
    public OutputData handleRequest(InputData input, Context context) {
        LOG.info("received: {}", input);

        OutputData response = null;

        try {
            response = new ValueComparison().apply(input);
            LOG.info("Returned from validation function: " + response);
        } catch (Exception e) {
            LOG.error(e.getStackTrace());
        }

        return response;
    }
}
