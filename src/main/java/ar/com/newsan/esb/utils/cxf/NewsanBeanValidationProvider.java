package ar.com.newsan.esb.utils.cxf;

import org.apache.cxf.validation.BeanValidationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.newsan.esb.utils.camel.NewsanHibernateValidationProviderResolver;

@Component(value = "beanValidationProvider")
public class NewsanBeanValidationProvider extends BeanValidationProvider {

	@Autowired
	public NewsanHibernateValidationProviderResolver validationProviderResolver;
}
