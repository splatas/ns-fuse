package ar.com.newsan.api;

import ar.com.newsan.model.InlineResponse200;
import ar.com.newsan.model.InlineResponse404;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/product")
@Api(description = "the product API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2019-11-27T16:49:26.689-03:00")
public class ProductApi {

    @GET
    @Path("/{sku}/price")
    @Produces({ "application/json" })
    @ApiOperation(value = "find a product price in EBS", notes = "Consulta el precio de un producto en EBS", response = InlineResponse200.class, tags={ "products",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Operation", response = InlineResponse200.class),
        @ApiResponse(code = 404, message = "Product not Found", response = InlineResponse404.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = InlineResponse404.class) })
    public Response findProductPrice(@QueryParam("headerName") @NotNull   @ApiParam("pass a product header name for looking up specific product")  String headerName,@PathParam("sku") @ApiParam("pass a product sku for looking up specific product") String sku) {
        return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/{sku}/stock")
    @Produces({ "application/json" })
    @ApiOperation(value = "find a product stock in EBS", notes = "Consulta el stock de un producto en EBS", response = InlineResponse200.class, tags={ "products",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Operation", response = InlineResponse200.class),
        @ApiResponse(code = 404, message = "Product not Found", response = InlineResponse404.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = InlineResponse404.class) })
    public Response findProductStock(@QueryParam("organization") @NotNull   @ApiParam("pass a product organization code for filtering SKU results")  String organization,@QueryParam("subinventory") @NotNull   @ApiParam("pass a product subinventory code for filtering SKU results")  String subinventory,@PathParam("sku") @ApiParam("pass a product sku for looking up specific product") String sku) {
        return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/{organization}/components")
    @Produces({ "application/json" })
    @ApiOperation(value = "list EBS product components by organization filtered by last update date", notes = "Consulta despiece de productos en EBS en base a la organización y ultima fecha de actualización.", response = InlineResponse200.class, tags={ "products",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Operation", response = InlineResponse200.class),
        @ApiResponse(code = 400, message = "Invalid Parameters", response = InlineResponse404.class),
        @ApiResponse(code = 404, message = "Product not Found", response = InlineResponse404.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = InlineResponse404.class) })
    public Response listProductComponents(@PathParam("organization") @ApiParam("pass a product organization") String organization,@QueryParam("lastUpdated") @NotNull @Pattern(regexp="\\d{4}-\\d{2}-\\d{2}")   @ApiParam("pass last updated date to filter products")  String lastUpdated) {
        return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/{organization}")
    @Produces({ "application/json" })
    @ApiOperation(value = "list EBS products by organization filtered by last update date", notes = "Consulta productos en EBS en base a la organización y ultima fecha de actualización.", response = InlineResponse200.class, tags={ "products" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Operation", response = InlineResponse200.class),
        @ApiResponse(code = 400, message = "Invalid Parameters", response = InlineResponse404.class),
        @ApiResponse(code = 404, message = "Product not Found", response = InlineResponse404.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = InlineResponse404.class) })
    public Response listProducts(@PathParam("organization") @ApiParam("pass a product organization") String organization,@QueryParam("lastUpdated") @NotNull @Pattern(regexp="\\d{4}-\\d{2}-\\d{2}")   @ApiParam("pass last updated date to filter products")  String lastUpdated) {
        return Response.ok().entity("magic!").build();
    }
}
