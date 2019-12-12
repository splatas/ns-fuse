package ar.com.newsan.esb.routes;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("beanValidator")
public class RestBeanValidator implements Processor {

	@NotNull
    @Size(min = 500, max = 1400, groups = OptionalChecks.class)
	private String sku;
	
	@NotNull
	private String organization;
	
	@NotNull
	private String subinventory;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getSubinventory() {
		return subinventory;
	}

	public void setSubinventory(String subinventory) {
		this.subinventory = subinventory;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("Entró al BEAN VALIDATOR!");
		
	}

}
