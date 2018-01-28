package com.tutorialCamel.camelErrorHandler.route.defaultErrorHandler;

import com.tutorialCamel.camelErrorHandler.bean.DataModifier;
import org.apache.camel.builder.RouteBuilder;

public class DefaultErrorHandlerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        errorHandler(defaultErrorHandler());

        //Error Logging
        //errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).retryAttemptedLogLevel(LoggingLevel.WARN));

        //Error Logging exponetial back off
        //errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).backOffMultiplier(2).retryAttemptedLogLevel(LoggingLevel.WARN));


        from("direct:input")
                .bean(new DataModifier(), "map")
                .to("log:level=INFO&showBody=true")
                .to("mock:errorqueue");
    }
}
