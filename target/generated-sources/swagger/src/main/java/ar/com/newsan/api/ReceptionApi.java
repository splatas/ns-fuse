package ar.com.newsan.api;

import ar.com.newsan.model.ApiReception;
import ar.com.newsan.model.InlineResponse200;
import ar.com.newsan.model.InlineResponse404;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/reception")
@Api(description = "the reception API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2019-11-27T16:49:26.689-03:00")
public class ReceptionApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "create a purchase order reception in EBS", notes = "Crea una recepción de orden de compra en EBS", response = InlineResponse200.class, tags={ "receptions" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful Operation", response = InlineResponse200.class),
        @ApiResponse(code = 400, message = "Invalid Parameters", response = InlineResponse404.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = InlineResponse404.class) })
    public Response createReception(@Valid ApiReception reception) {
        return Response.ok().entity("magic!").build();
    }
}
