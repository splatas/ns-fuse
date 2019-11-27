/*
 * Copyright 2016 Red Hat, Inc.
 * <p>
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
package ar.com.newsan.esb;

import java.sql.SQLException;
import java.util.Arrays;

import org.apache.camel.component.bean.validator.HibernateValidationProviderResolver;
import org.apache.cxf.validation.BeanValidationFeature;
import org.apache.cxf.validation.BeanValidationProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.newsan.esb.api.provider.CustomGenericExceptionMapper;
import ar.com.newsan.esb.api.provider.CustomValidationExceptionMapper;
import ar.com.newsan.esb.mybatis.session.CustomSqlSessionFactoryBuilder;
import ar.com.newsan.esb.service.EBSService;
import ar.com.newsan.esb.utils.ExceptionHandler;

@SpringBootApplication
// load regular Spring XML file from the classpath that contains the Camel XML DSL
@ImportResource({ "classpath:spring/camel-context.xml", "classpath:spring/beans.xml"
//				, "classpath:ar/com/newsan/esb/mybatis/SqlMapConfig.xml" 
})
@EnableAutoConfiguration
public class Application {

//	private static EBSService ebs;
//	private static TransactionAwareDataSourceProxy dataSource;
//	private static CustomGenericExceptionMapper customExceptionMapper;
//	private static CustomValidationExceptionMapper validationExceptionMapper;
//	private static ExceptionHandler handler;
//	private static CustomSqlSessionFactoryBuilder customSqlSessionFactoryBuilder;
//	private static ObjectMapper mapper;
//	private static HibernateValidationProviderResolver validationProviderResolver;
//	private static BeanValidationProvider beanValidationProvider;
//	private static BeanValidationFeature commonValidationFeature;
//
//	private static ClassPathResource mybatisConfig;

	/**
	 * A main method to start this application.
	 * 
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

//            System.out.println("\nLet's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println("\tbeanName = " + beanName);
//            }
//
//            ebs = (EBSService) ctx.getBean("ebs");
//            dataSource = (TransactionAwareDataSourceProxy) ctx.getBean("dataSource");
//            customExceptionMapper = (CustomGenericExceptionMapper) ctx.getBean("customExceptionMapper");
//            validationExceptionMapper = (CustomValidationExceptionMapper) ctx.getBean("validationExceptionMapper");
//            handler =  (ExceptionHandler) ctx.getBean("handler");
//            customSqlSessionFactoryBuilder= (CustomSqlSessionFactoryBuilder) ctx.getBean("customSqlSessionFactoryBuilder");
//            mapper = (ObjectMapper) ctx.getBean("mapper");
//            validationProviderResolver = (HibernateValidationProviderResolver) ctx.getBean("validationProviderResolver");
//            beanValidationProvider = (BeanValidationProvider) ctx.getBean("beanValidationProvider");
//            commonValidationFeature = (BeanValidationFeature) ctx.getBean("commonValidationFeature");
//            
//            mybatisConfig = (ClassPathResource) ctx.getBean("mybatisConfig");
		};
	}

}