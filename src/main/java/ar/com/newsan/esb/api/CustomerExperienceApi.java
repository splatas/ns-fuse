package ar.com.newsan.esb.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.newsan.esb.routes.NewsanRouteBuilder;
import ar.com.newsan.esb.utils.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@Api(description = "Customer Experience API")
//@Path("/custexp")
public class CustomerExperienceApi {

    private static Logger LOG = LoggerFactory.getLogger(CustomerExperienceApi.class);
    
    @Autowired
    private NewsanRouteBuilder routeBuilder;

    @GET
    @Path("/product/{sku}/stock")
    @Produces({ "application/json" })
    @ApiOperation(value = "find a product stock in EBS", notes = "Consulta el stock de un producto en EBS", response = StandardResponse.class, tags={ "products",  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Operation", response = StandardResponse.class),
            @ApiResponse(code = 404, message = "Product not Found", response = StandardResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardResponse.class) })
    //@JWTSecured
    public StandardResponse findProductStock(@QueryParam("organization") @NotNull String organization,
                                             @QueryParam("subinventory") @NotNull String subinventory,
                                             @PathParam("sku") @ApiParam("pass a product sku for looking up specific product") String sku) {
        LOG.info("[CustomerExperienceApi.findProductStock]: starts with: sku=" + sku  + ", organization= " + organization + ", subinventory=" + subinventory);

        routeBuilder.getRouteCollection().
        
    	return StandardResponse.ok("findProductStock");
    }

}
