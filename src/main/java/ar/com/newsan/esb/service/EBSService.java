package ar.com.newsan.esb.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

//import ar.com.newsan.model.ApiOrder;
//import ar.com.newsan.model.ApiOrderLine;
//import ar.com.newsan.model.ApiReception;
//import ar.com.newsan.model.ApiReceptionTransaction;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.ibatis.exceptions.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ar.com.newsan.esb.model.ProductStock;
import ar.com.newsan.esb.routes.RequestStockDTO;
import ar.com.newsan.esb.utils.StandardResponse;

/**
 * Class which build requests to EBS API.
 *
 * @author Ingenia CA
 * @version 0.1
 * @since 2018-01-18
 */
@Component(value = "ebs")
public class EBSService {

    private static Logger LOG = LoggerFactory.getLogger(EBSService.class);

    public void requestProductsByOrgAndDate(Exchange exchange) throws Exception {

        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("organization", exchange.getIn().getHeader("organization", String.class));
        bodyMap.put("lastUpdated", exchange.getIn().getHeader("lastUpdated", String.class));
        exchange.getOut().setBody(bodyMap);
    }

    public void requestSuppliers(Exchange exchange) throws Exception {

        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("category", exchange.getIn().getHeader("category", String.class));
        bodyMap.put("lastUpdated", exchange.getIn().getHeader("lastUpdated", String.class));
        exchange.getOut().setBody(bodyMap);
    }

    public void requestProductPrice(Exchange exchange) throws Exception {

        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("sku", exchange.getIn().getHeader("sku", String.class));
        bodyMap.put("headerName", exchange.getIn().getHeader("headerName", String.class));
        exchange.getOut().setBody(bodyMap);
    }

    public void requestProductStock(Exchange exchange) throws Exception {

    	LOG.info("[EBSService.requestProductStock]: starting... ");
    	RequestStockDTO body = exchange.getIn().getBody(RequestStockDTO.class);

        // Get sku id and inventory id from Oracle EBS
        ProductStock stock = getIdsByCode(exchange, body);
        stock.setSubInventory(body.getSubinventoryParam());

        LOG.info("[EBSService.requestProductStock]: ends setting out's boyd with stock= " + stock);
        exchange.getOut().setBody(stock);
    }

    public void requestGetOrder(Exchange exchange) throws Exception {

        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("type", exchange.getIn().getHeader("type", String.class));
        bodyMap.put("id", exchange.getIn().getHeader("id", String.class));
        bodyMap.put("unit", exchange.getIn().getHeader("unit", String.class));
        exchange.getOut().setBody(bodyMap);
    }


    //Utils

    public StandardResponse<Object> validateResponse(Exchange exchange) {

        String operation = exchange.getProperty("currentOperation", String.class);
        Object body = exchange.getIn().getBody();

        if (body == null) { //If body is null, requested entity has not been found
            exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, "404");
            StandardResponse<Object> response = StandardResponse.error(operation);
            response.registerError("Not Found", "Requested entity not found");
            return response;
        }

        if (exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE) == null)
            exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, "200");  // Success

        if(exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE).equals("500")) { //Business Error

            StandardResponse<Object> response = StandardResponse.error(operation);
            response.registerError("EBS Error", body.toString());
            return response;
        }

        return StandardResponse.ok(operation, body);
    }

    private ProductStock getIdsByCode(Exchange exchange, RequestStockDTO request) {

        Map<String, String> inputParams = new HashMap<>();
        inputParams.put("sku", request.getSkuParam());
        inputParams.put("org", request.getOrganizationParam());

        ProducerTemplate template = exchange.getContext().createProducerTemplate();
        
        LOG.info("PARÁMETROS RECIBIDOS: sku=" + inputParams.get("sku") + ", organization=" + inputParams.get("org"));
        return template.requestBody("mybatis:Product.getIds?statementType=SelectOne", inputParams, ProductStock.class);
    }

}
