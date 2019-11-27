package ar.com.newsan.api;

import ar.com.newsan.model.ApiOrder;
import java.math.BigDecimal;
import ar.com.newsan.model.InlineResponse200;
import ar.com.newsan.model.InlineResponse404;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/order")
@Api(description = "the order API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2019-11-27T16:49:26.689-03:00")
public class OrderApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "create an order in EBS", notes = "Crea un pedido en EBS", response = InlineResponse200.class, tags={ "orders",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Operation", response = InlineResponse200.class),
        @ApiResponse(code = 400, message = "Invalid Parameters", response = InlineResponse404.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = InlineResponse404.class) })
    public Response createOrder(@Valid ApiOrder order) {
        return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/{type}/{id}")
    @Produces({ "application/json" })
    @ApiOperation(value = "find an order in EBS", notes = "Consulta un pedido en EBS", response = InlineResponse200.class, tags={ "orders" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Operation", response = InlineResponse200.class),
        @ApiResponse(code = 404, message = "Order not Found", response = InlineResponse404.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = InlineResponse404.class) })
    public Response findOrder(@PathParam("id") @ApiParam("pass an order id for looking up specific order") BigDecimal id,@PathParam("type") @ApiParam("pass an order type for looking up specific order") String type,@QueryParam("unit") @NotNull    String unit) {
        return Response.ok().entity("magic!").build();
    }
}
