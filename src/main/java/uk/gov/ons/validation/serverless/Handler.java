package uk.gov.ons.validation.serverless;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import uk.gov.ons.validation.entity.OutputData;
import uk.gov.ons.validation.service.ValueComparison;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = LogManager.getLogger(Handler.class);

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        LOG.info("received: {}", input);

        OutputData response = null;

        try {
            response = new ValueComparison().apply(input.get("body").toString());
            LOG.info("Returned from validation function: " + response.toString());
        } catch (Exception e) {
            LOG.error(e.getStackTrace());
        }

        return ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setObjectBody(response)
                .build();
    }
}
