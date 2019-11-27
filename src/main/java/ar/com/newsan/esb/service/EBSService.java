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

        String subinventory = exchange.getIn().getHeader("subinventory", String.class);
 LOG.info("Parametros recibidos: subinventory=" + subinventory);

        // Get sku id and inventory id from Oracle EBS
        ProductStock stock = getIdsByCode(exchange);
        stock.setSubInventory(subinventory);

        LOG.info(String.format("[FIND PRODUCT STOCK] SKU: %s, Organization: %s, Subinventory: %s",
                stock.getInventory(), stock.getOrganization(), subinventory));

        
        LOG.info("[EBSService.requestProductStock]: ends setting out's boyd with stock= " + stock);
        exchange.getOut().setBody(stock);
    }

//    public void requestCreateOrder(Exchange exchange) throws Exception {
//
//        ProducerTemplate template = exchange.getContext().createProducerTemplate();
//        ApiOrder inOrderHeader = exchange.getIn().getBody(ApiOrder.class);
//
//        Map<String, Object> bodyMap = new HashMap<>();
//        bodyMap.put("in_header", inOrderHeader);
//        bodyMap.put("in_lines", inOrderHeader.getLines());
//
//        // Response fields
//        bodyMap.put("out_status", null);
//        bodyMap.put("out_msg_count", 0);
//        bodyMap.put("out_msg_data", null);
//        bodyMap.put("out_header", new OrderHeaderOut());
//        bodyMap.put("out_lines", new ArrayList<OrderLineOut>());
//
//        // Calculated fields
//        Integer custBillTo = template.requestBody("mybatis:Order.getCustomerSiteId?statementType=SelectOne", inOrderHeader.getClientBillRef(), Integer.class);
//        Integer custShipTo = template.requestBody("mybatis:Order.getCustomerSiteId?statementType=SelectOne", inOrderHeader.getClientShipRef(), Integer.class);
//        if (custBillTo == null || custShipTo == null) throw new PersistenceException("Required customer id not found");
//        bodyMap.put("custBillTo", custBillTo);
//        bodyMap.put("custShipTo", custShipTo);
//
//        exchange.getOut().setBody(bodyMap);
//    }

    public void requestGetOrder(Exchange exchange) throws Exception {

        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("type", exchange.getIn().getHeader("type", String.class));
        bodyMap.put("id", exchange.getIn().getHeader("id", String.class));
        bodyMap.put("unit", exchange.getIn().getHeader("unit", String.class));
        exchange.getOut().setBody(bodyMap);
    }

//    public void requestCreateReception(Exchange exchange) {
//
//        // Retrieve original input body
//        ApiReception input = exchange.getIn().getBody(ApiReception.class);
//
//        Map<String, Object> bodyMap = new HashMap<>();
//        // Add original input body
//        bodyMap.put("reception", input);
//        // Header & group sequence values
//        bodyMap.put("headerInterface", getSeqNextVal(exchange, "RCV_HEADERS_INTERFACE_S"));
//        BigDecimal groupId = getSeqNextVal(exchange, "RCV_INTERFACE_GROUPS_S");
//        bodyMap.put("groupId", groupId);
//        // Add field to fill out response
//        bodyMap.put("out", new POReception(groupId));
//
//        exchange.getOut().setBody(bodyMap);
//    }

//    public void retrievePurchaseOrderData(ApiReceptionTransaction inputTransaction, Exchange exchange) { /* Find PO data for every transaction */
//
//        ProducerTemplate template = exchange.getContext().createProducerTemplate();
//        Map<String, Object> body = (Map<String, Object>) exchange.getIn().getHeader("API_PARAMS");
//
//        // Current transaction
//        body.put("transaction", inputTransaction);
//        // Current transaction sequence value
//        body.put("transactionInterface", getSeqNextVal(exchange, "RCV_TRANSACTIONS_INTERFACE_S"));
//
//        // HeaderId and Currency
//        Map<String, Object> header = template.requestBody("mybatis:Reception.getHeaderData?statementType=SelectOne", inputTransaction, Map.class);
//        if(header == null || anyNull(header)) throw new PersistenceException("Required reception header not found");
//        body.put("poHeader", header.get("ID"));
//        body.put("poCurrency", header.get("CURRENCY"));
//
//        // ItemId
//        Long poItem = template.requestBody("mybatis:Reception.getItemId?statementType=SelectOne", inputTransaction, Long.class);
//        if (poItem == null) throw new PersistenceException("Required reception item not found");
//        body.put("poItem", poItem);
//
//        // LineId
//        Long poLine = template.requestBody("mybatis:Reception.getLineId?statementType=SelectOne", body, Long.class);
//        if(poLine == null) throw new PersistenceException("Required reception line not found");
//        body.put("poLine", poLine);
//
//        // LineLocationId and ShipToOrgId
//        Map<String, Object> lineLocation = template.requestBody("mybatis:Reception.getLineLocationData?statementType=SelectOne", body, Map.class);
//        if(lineLocation == null || anyNull(lineLocation)) throw new PersistenceException("Required reception line location not found");
//        body.put("poLineLocation", lineLocation.get("LOCATION"));
//        body.put("poOrg", lineLocation.get("ORG"));
//    }

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

    private ProductStock getIdsByCode(Exchange exchange) {

        Map<String, String> inputParams = new HashMap<>();
        inputParams.put("sku", exchange.getIn().getHeader("sku", String.class));
        inputParams.put("org", exchange.getIn().getHeader("organization", String.class));

        ProducerTemplate template = exchange.getContext().createProducerTemplate();
        
        
        
LOG.info("PARÁMETROS RECIBIDOS: sku=" + inputParams.get("sku") + ", organization=" + inputParams.get("org"));
        
        return template.requestBody("mybatis:Product.getIds?statementType=SelectOne", inputParams, ProductStock.class);
    }

    private Boolean anyNull(Map<String, Object> param) {

        if (param==null) return false;

        Boolean anyNull = false;

        for (Object value : param.values()){

            if(value == null) {
                anyNull = true;
                break;
            }
        }

        return anyNull;
    }

    private BigDecimal getSeqNextVal(Exchange exchange, String sequenceName) {

        ProducerTemplate template = exchange.getContext().createProducerTemplate();
        BigDecimal seqValue = template.requestBody("mybatis:Reception.sequenceId?statementType=SelectOne", sequenceName, BigDecimal.class);
        if(seqValue == null) throw new PersistenceException("Required reception sequence value not found");
        return seqValue;
    }

}
