package ar.com.newsan.esb.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A Camel Java DSL Router
 */
@Component(value = "newsanRouteBuilder")
public class NewsanRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

    	from("direct:findProductStock")
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
        
			
		// ------------------------------------------- // 
		from("timer:simple?period=5000")
			.log("Testing route!")
			.process(new Processor() {
				
				@Override
				public void process(Exchange exchange) throws Exception {
					System.out.println(" MY TESTING PROCESSOR.... STARTS!");
					
						exchange.getOut().setHeader("subinventory", "ALGO");
						exchange.getOut().setHeader("sku", "91LT42DA760");
						exchange.getOut().setHeader("organization", "SPV");
					
					System.out.println(" MY TESTING PROCESSOR.... ENDS!");
				}
			})
			.to("direct:findProductStock")
			.end();
		// ------------------------------------------- // 
		
//		from("rest:get:hello")
//		  .transform().constant("Bye World");
    }

}