package ar.com.newsan.esb.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component(value = "restProcessor")
public class RestServiceProcessor implements Processor {

	@Override
	public void process(Exchange exchange) {
		
		String path = exchange.getIn().getHeader(Exchange.HTTP_URI, String.class);

		String skuParam = path.substring((path.lastIndexOf("/product/") + 9), path.lastIndexOf("/"));
		String organizationParam = (String) exchange.getIn().getHeader("organization", String.class);
		String subinventoryParam = (String) exchange.getIn().getHeader("subinventory", String.class);

		// org.apache.camel.RuntimeCamelException: java.io.IOException: UT010029: Stream is closed
		exchange.getOut().setBody(false);
		
		exchange.getOut().setHeader("sku", skuParam);		
		exchange.getOut().setHeader("subinventory", subinventoryParam);
		exchange.getOut().setHeader("organization", organizationParam);

	}

}
