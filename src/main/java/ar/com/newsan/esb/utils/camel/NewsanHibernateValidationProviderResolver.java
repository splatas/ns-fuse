package ar.com.newsan.esb.utils.camel;

import org.apache.camel.component.bean.validator.HibernateValidationProviderResolver;
import org.springframework.stereotype.Component;

@Component(value = "validationProviderResolver")
public class NewsanHibernateValidationProviderResolver extends HibernateValidationProviderResolver {

}
