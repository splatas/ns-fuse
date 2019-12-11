package ar.com.newsan.esb.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A Camel Java DSL Router
 */
@Component(value = "newsanRouteBuilder")
public class NewsanRouteBuilder extends RouteBuilder {

	@Autowired
	RestServiceProcessor restProcessor;
	@Autowired
	RestBeanValidator beanValidator;

    public void configure() {
    	
    	restConfiguration()
	        .component("servlet")
	        .bindingMode(RestBindingMode.json);
	    	
    	
    	// Expose rest service
	    from("servlet:/product/{sku}/stock?")
	    	.routeId("productStockRest")
	    	.log("entró por productStockRestService")
	    	.to("bean-validator://x")
	    	.process(beanValidator)
	    	.process(restProcessor)
	    	.to("direct:findProductStock")
	    	.end();
	
    	// Route findProductStock
	    from("direct:findProductStock")
    		.routeId("findProductStock")
    		.log("<FIND-PRODUCT-STOCK: Starting...>")
    		.to("bean:ebs?method=requestProductStock")
    		.to("mybatis:Product.findProductStock?statementType=SelectOne")
    		.log("[FIND PRODUCT STOCK] EBS Response: ${body}")
    		.choice()
    			.when()
    				.simple("${body.reqStatus} != 'S'")
    					.setBody().simple(null)
    		.log("<FIND-PRODUCT-STOCK: End.>")
    		.end();
		
    }

}