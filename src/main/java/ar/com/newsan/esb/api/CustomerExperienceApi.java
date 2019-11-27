package ar.com.newsan.esb.api;

import ar.com.newsan.esb.api.constraint.ValidDate;
import ar.com.newsan.esb.security.JWTSecured;
import ar.com.newsan.esb.utils.StandardResponse;
//import ar.com.newsan.model.ApiOrder;
//import ar.com.newsan.model.ApiReception;
import io.swagger.annotations.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Api(description = "Customer Experience API")

//@Path("/custexp")

public class CustomerExperienceApi {

    private static final String DATE_FORMAT_REGEX = "\\d{4}-\\d{2}-\\d{2}";
    private static Logger LOG = LoggerFactory.getLogger(CustomerExperienceApi.class);

    /**
     *  PRODUCT API
     *      - Get product price
     *      - Get product stock
     *      - List products components
     *      - List products
     */
//
//    @GET
//    @Path("/product/{sku}/price")
//
//    @Produces({ "application/json" })
//    @ApiOperation(value = "find a product price in EBS", notes = "Consulta el precio de un producto en EBS", response = StandardResponse.class, tags={ "products",  })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successful Operation", response = StandardResponse.class),
//            @ApiResponse(code = 404, message = "Product not Found", response = StandardResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardResponse.class) })
//    @JWTSecured
    public StandardResponse findProductPrice(@QueryParam("headerName") @NotNull String headerName,
                                             @NotNull @PathParam("sku") @ApiParam("pass a product sku for looking up specific product") String sku) {
        return StandardResponse.ok("findProductPrice");
    }

    @GET
    @Path("/product/{sku}/stock")

    @Produces({ "application/json" })
    @ApiOperation(value = "find a product stock in EBS", notes = "Consulta el stock de un producto en EBS", response = StandardResponse.class, tags={ "products",  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation", response = StandardResponse.class),
            @ApiResponse(code = 404, message = "Product not Found", response = StandardResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardResponse.class) })
    @JWTSecured
    public StandardResponse findProductStock(@QueryParam("organization") @NotNull String organization,
                                             @QueryParam("subinventory") @NotNull String subinventory,
                                             @PathParam("sku") @ApiParam("pass a product sku for looking up specific product") String sku) {
        LOG.info("[CustomerExperienceApi.findProductStock]: starts with: sku=" + sku  + ", organization= " + organization + ", subinventory=" + subinventory);

    	return StandardResponse.ok("findProductStock");
    }

//    @GET
//    @Path("/product/{organization}/components")
//
//    @Produces({ "application/json" })
//    @ApiOperation(value = "list EBS product components by organization filtered by last update date", notes = "Consulta despiece de productos en EBS en base a la organización y ultima fecha de actualización.", response = StandardResponse.class, tags={ "products",  })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successful Operation", response = StandardResponse.class),
//            @ApiResponse(code = 400, message = "Invalid Parameters", response = StandardResponse.class),
//            @ApiResponse(code = 404, message = "Product not Found", response = StandardResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardResponse.class) })
//    @JWTSecured
    public StandardResponse listProductComponents(@NotNull @PathParam("organization") @ApiParam("pass a product organization") String organization,
                                                  @QueryParam("lastUpdated") @NotNull @Pattern(regexp=DATE_FORMAT_REGEX) @ValidDate String lastUpdated) {
        return StandardResponse.ok("listProductComponents");
    }

//    @GET
//    @Path("/product/{organization}")
//
//    @Produces({ "application/json" })
//    @ApiOperation(value = "list EBS products by organization filtered by last update date", notes = "Consulta productos en EBS en base a la organización y ultima fecha de actualización.", response = StandardResponse.class, tags={ "products" })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successful Operation", response = StandardResponse.class),
//            @ApiResponse(code = 400, message = "Invalid Parameters", response = StandardResponse.class),
//            @ApiResponse(code = 404, message = "Product not Found", response = StandardResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardResponse.class) })
//    @JWTSecured
    public StandardResponse listProducts(@NotNull @PathParam("organization") @ApiParam("pass a product organization") String organization,
                                         @QueryParam("lastUpdated") @NotNull @Pattern(regexp=DATE_FORMAT_REGEX) @ValidDate String lastUpdated) {
        return StandardResponse.ok("listProducts");
    }


    /**
     *  SUPPLIER API
     *      - List suppliers
     */

//    @GET
//    @Path("/supplier/{category}")
//
//    @Produces({ "application/json" })
//    @ApiOperation(value = "list EBS suppliers by vendor category filtered by last update date", notes = "Consulta proveedores en EBS en base a la categoría y ultima fecha de actualización.", response = StandardResponse.class, tags={ "suppliers" })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successful Operation", response = StandardResponse.class),
//            @ApiResponse(code = 400, message = "Invalid Parameters", response = StandardResponse.class),
//            @ApiResponse(code = 404, message = "Supplier not Found", response = StandardResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardResponse.class) })
//    @JWTSecured
    public StandardResponse listSuppliers(@NotNull @PathParam("category") @ApiParam("pass a supplier vendor category") String category,
                                          @QueryParam("lastUpdated") @NotNull @Pattern(regexp=DATE_FORMAT_REGEX) @ValidDate String lastUpdated) {
        return StandardResponse.ok("listSuppliers");
    }


    /**
     *  CUSTOMER API
     *      - List customers
     */

//    @GET
//    @Path("/customer")
//
//    @Produces({ "application/json" })
//    @ApiOperation(value = "list EBS customers filtered by last update date", notes = "Consulta clientes en EBS en base a la ultima fecha de actualización.", response = StandardResponse.class, tags={ "customers" })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successful Operation", response = StandardResponse.class),
//            @ApiResponse(code = 400, message = "Invalid Parameters", response = StandardResponse.class),
//            @ApiResponse(code = 404, message = "Customer not Found", response = StandardResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardResponse.class) })
//    @JWTSecured
    public StandardResponse listCustomers(@QueryParam("lastUpdated") @NotNull @Pattern(regexp=DATE_FORMAT_REGEX) @ValidDate String lastUpdated) {
        return StandardResponse.ok("listCustomers");
    }


    /**
     *  ORDER API
     *      - Get order
     *      - Create order
     */

//    @GET
//    @Path("/order/{type}/{id}")
//
//    @Produces({ "application/json" })
//    @ApiOperation(value = "find an order in EBS", notes = "Consulta un pedido en EBS", response = StandardResponse.class, tags={ "orders" })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successful Operation", response = StandardResponse.class),
//            @ApiResponse(code = 404, message = "Order not Found", response = StandardResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardResponse.class) })
//    @JWTSecured
    public StandardResponse findOrder(@NotNull @PathParam("id") @ApiParam("pass an order id for looking up specific order") BigDecimal id,
                                      @NotNull @PathParam("type") @ApiParam("pass an order type for looking up specific order") String type,
                                      @QueryParam("unit") @NotNull String unit) {
        return StandardResponse.ok("findOrder");
    }

//    @POST
//    @Path("/order")
//
//    @Consumes({ "application/json" })
//    @Produces({ "application/json" })
//    @ApiOperation(value = "create an order in EBS", notes = "Crea un pedido en EBS", response = StandardResponse.class, tags={ "orders" })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successful Operation", response = StandardResponse.class),
//            @ApiResponse(code = 400, message = "Invalid Parameters", response = StandardResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardResponse.class) })
//    @JWTSecured
//    public StandardResponse createOrder(@NotNull @Valid ApiOrder order) {
//        return StandardResponse.ok("createOrder");
//    }


    /**
     *  RECEPTION API
     *      - Create reception
     *      - Lookup reception errors
     */

//    @POST
//    @Path("/reception")
//
//    @Consumes({ "application/json" })
//    @Produces({ "application/json" })
//    @ApiOperation(value = "create a purchase order reception in EBS", notes = "Crea una recepción de orden de compra en EBS", response = StandardResponse.class, tags={ "receptions" })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successful Operation", response = StandardResponse.class),
//            @ApiResponse(code = 400, message = "Invalid Parameters", response = StandardResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardResponse.class) })
//    @JWTSecured
//    public StandardResponse createReception(@NotNull @Valid ApiReception reception) {
//        return StandardResponse.ok("createReception");
//    }
//
//    @GET
//    @Path("/reception/error/{groupId}")
//
//    @Consumes({ "application/json" })
//    @Produces({ "application/json" })
//    @ApiOperation(value = "create a purchase order reception in EBS", notes = "Obtiene errores asociados a una recepción de orden de compra en EBS", response = StandardResponse.class, tags={ "receptions" })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successful Operation", response = StandardResponse.class),
//            @ApiResponse(code = 400, message = "Invalid Parameters", response = StandardResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardResponse.class) })
//    @JWTSecured
//    public StandardResponse getErrors(@NotNull @PathParam("groupId") @ApiParam("pass reception groupId for looking up related errors") BigDecimal groupId) {
//        return StandardResponse.ok("getErrors");
//    }

    /**
     *  AUTH API
     *      - Get token
     */
//    @GET
//    @Path("/auth")
//    @Produces({ "application/json" })
    public Response authenticate() {
        return Response.ok().build();
    }
}
