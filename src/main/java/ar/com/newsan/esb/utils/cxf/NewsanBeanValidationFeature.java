package ar.com.newsan.esb.utils.cxf;

import org.apache.cxf.validation.BeanValidationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "commonValidationFeature")
public class NewsanBeanValidationFeature extends BeanValidationFeature {
	
	@Autowired
	private NewsanBeanValidationProvider provider;

}
