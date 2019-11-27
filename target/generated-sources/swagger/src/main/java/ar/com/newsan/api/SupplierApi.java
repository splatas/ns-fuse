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

@Path("/supplier")
@Api(description = "the supplier API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2019-11-27T16:49:26.689-03:00")
public class SupplierApi {

    @GET
    @Path("/{category}")
    @Produces({ "application/json" })
    @ApiOperation(value = "list EBS suppliers by vendor category filtered by last update date", notes = "Consulta proveedores en EBS en base a la categoría y ultima fecha de actualización.", response = InlineResponse200.class, tags={ "suppliers" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Operation", response = InlineResponse200.class),
        @ApiResponse(code = 400, message = "Invalid Parameters", response = InlineResponse404.class),
        @ApiResponse(code = 404, message = "Supplier not Found", response = InlineResponse404.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = InlineResponse404.class) })
    public Response listSuppliers(@PathParam("category") @ApiParam("pass a supplier vendor category") String category,@QueryParam("lastUpdated") @NotNull @Pattern(regexp="\\d{4}-\\d{2}-\\d{2}")   @ApiParam("pass last updated date to filter products")  String lastUpdated) {
        return Response.ok().entity("magic!").build();
    }
}
