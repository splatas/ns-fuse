package ar.com.newsan.esb.utils.spring;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.camel.component.mybatis.MyBatisComponent;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import ar.com.newsan.esb.mybatis.NewsanResource;
import ar.com.newsan.esb.mybatis.session.CustomSqlSessionFactory;
import ar.com.newsan.esb.mybatis.session.CustomSqlSessionFactoryBuilder;
import oracle.jdbc.pool.OracleDataSource;

@Configuration
public class DataConfig {
	
	@Bean(name = "dataSource")
	public TransactionAwareDataSourceProxy getDataSource() throws SQLException {

		OracleDataSource newsanDatasource = new OracleDataSource();
		
//		ClassPathResource propertiesFile = new ClassPathResource("ar.com.newsan.properties", NewsanResource.class);
		
		//
		//Datos obtenidos de 'ar.com.newsan.properties'
		//
		//newsanDatasource.setURL("${database.oracle.url}");
		newsanDatasource.setURL("jdbc:oracle:thin:@arrpedb11.newsan.com.ar:1521:PROD");
		//newsanDatasource.setUser("${database.oracle.username}");
		newsanDatasource.setUser("apps");
		//newsanDatasource.setPassword("${database.oracle.password}");
		newsanDatasource.setPassword("appsvvkit");

		TransactionAwareDataSourceProxy dsProxy = new TransactionAwareDataSourceProxy();
		dsProxy.setTargetDataSource(newsanDatasource);

		return dsProxy;
	}
	
	@Bean(name = "mybatisConfig")
	public ClassPathResource getMybatisConfig() {
		
		//"${mybatis.config.location} => ar/com/newsan/esb/mybatis/SqlMapConfig.xml"
		//"${mybatis.config.resource} => ar.com.newsan.esb.mybatis.NewsanResource"
		ClassPathResource mybatisConfig = new ClassPathResource("SqlMapConfig.xml", NewsanResource.class);
													   
		return mybatisConfig;
	}
	
	@Bean(name = "sqlSessionFactoryBean")
	public SqlSessionFactoryBean getSqlSessionFactoryBean(ApplicationContext ctx) {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		DataSource ds = (DataSource) ctx.getBean("dataSource");
		sqlSessionFactoryBean.setDataSource(ds);
		
		// custom factory builder
		CustomSqlSessionFactoryBuilder sqlSessionFactoryBuilder = (CustomSqlSessionFactoryBuilder) ctx.getBean("customSqlSessionFactoryBuilder");
		sqlSessionFactoryBean.setSqlSessionFactoryBuilder(sqlSessionFactoryBuilder);
		
		// standard mybatis config file
		ClassPathResource mybatisConfig = (ClassPathResource) ctx.getBean("mybatisConfig");
		sqlSessionFactoryBean.setConfigLocation(mybatisConfig);
		
        // externalised mappers 
		Resource[] mapperLocations = (Resource[]) ctx.getBean("mapperLocations");
		sqlSessionFactoryBean.setMapperLocations(mapperLocations);
		
		return sqlSessionFactoryBean;
	}
	
	@Bean(name = "mapperLocations")
	public Resource[] getMappersLocations(ApplicationContext ctx) {
		
		Resource order = (ClassPathResource) ctx.getBean("mapperOrder");
		Resource product = (ClassPathResource) ctx.getBean("mapperProduct");
		Resource customer = (ClassPathResource) ctx.getBean("mapperCustomer");
		Resource supplier = (ClassPathResource) ctx.getBean("mapperSupplier");
		
		//
		//Resource reception = (ClassPathResource) ctx.getBean("mapperReception");
		// Al inyectar este object tira:
		//
		// org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sqlSessionFactoryBean' defined in class path resource [ar/com/newsan/esb/utils/spring/DataConfig.class]: 
		// Invocation of init method failed; nested exception is org.springframework.core.NestedIOException: Failed to parse mapping resource: 'class path resource [ar/com/newsan/esb/mybatis/Reception.xml]'; 
		//nested exception is org.apache.ibatis.builder.BuilderException: Error parsing Mapper XML. Cause: org.apache.ibatis.builder.BuilderException: Error resolving class. Cause: 
		//org.apache.ibatis.type.TypeException: Could not resolve type alias 'ReceptionTransaction'.  Cause: java.lang.ClassNotFoundException: 
		//Cannot find class: ReceptionTransaction
		
		Resource[] mapperLocations = {order, product, customer, supplier};
		
//		System.out.println("..........mapperLocations => \n" + mapperLocations[0].toString() + ",  \n" + mapperLocations[1].toString()+ ",  \n"+ mapperLocations[2].toString()
//				+ ",  \n" + mapperLocations[3].toString() + ",  \n"  );
		return mapperLocations;
	}
	
	@Bean(name = "mapperOrder")
	public ClassPathResource getMapperOrder() {
		
		//"${mybatis.config.location} => ar/com/newsan/esb/mybatis/Order.xml"
		//"${mybatis.config.resource} => ar.com.newsan.esb.mybatis.NewsanResource"
		ClassPathResource mapperOrder = new ClassPathResource("Order.xml", NewsanResource.class);
													   
		return mapperOrder;
	}
	
	@Bean(name = "mapperProduct")
	public ClassPathResource getMapperProduct() {
		
		//"${mybatis.config.location} => ar/com/newsan/esb/mybatis/Product.xml"
		//"${mybatis.config.resource} => ar.com.newsan.esb.mybatis.NewsanResource"
		ClassPathResource mapperProduct = new ClassPathResource("Product.xml", NewsanResource.class);
													   
		return mapperProduct;
	}
	
	@Bean(name = "mapperCustomer")
	public ClassPathResource getMapperCustomer() {
		
		//"${mybatis.config.location} => ar/com/newsan/esb/mybatis/Customer.xml"
		//"${mybatis.config.resource} => ar.com.newsan.esb.mybatis.NewsanResource"
		ClassPathResource mapperCustomer = new ClassPathResource("Customer.xml", NewsanResource.class);
													   
		return mapperCustomer;
	}
	
	@Bean(name = "mapperSupplier")
	public ClassPathResource getMapperSupplier() {
		
		//"${mybatis.config.location} => ar/com/newsan/esb/mybatis/Supplier.xml"
		//"${mybatis.config.resource} => ar.com.newsan.esb.mybatis.NewsanResource"
		ClassPathResource mapperSupplier = new ClassPathResource("Supplier.xml", NewsanResource.class);
													   
		return mapperSupplier;
	}

	@Bean(name = "mapperReception")
	public ClassPathResource getMapperReception() {
		
		//"${mybatis.config.location} => ar/com/newsan/esb/mybatis/Reception.xml"
		//"${mybatis.config.resource} => ar.com.newsan.esb.mybatis.NewsanResource"
		ClassPathResource mapperReception = new ClassPathResource("Reception.xml", NewsanResource.class);
													   
		return mapperReception;
	}
	
	@Bean(name = "mybatis")
	public MyBatisComponent getMyBatisComponent(ApplicationContext ctx) {
		
		MyBatisComponent mybatisComp = new MyBatisComponent();
		
		CustomSqlSessionFactory sqlSessionFactory = (CustomSqlSessionFactory) ctx.getBean("sqlSessionFactory");
		mybatisComp.setSqlSessionFactory(sqlSessionFactory);
		
		return mybatisComp;
	}
	
	
	@Bean(name = "configuration")
	public org.apache.ibatis.session.Configuration getConfiguration(ApplicationContext ctx) throws InstantiationException, IllegalAccessException {
		
		//"${mybatis.config.location} => ar/com/newsan/esb/mybatis/Reception.xml"
		//"${mybatis.config.resource} => ar.com.newsan.esb.mybatis.NewsanResource"
		//ClassPathResource configFile = new ClassPathResource("configuration.xml", NewsanResource.class);
		
		CustomSqlSessionFactory bean = (CustomSqlSessionFactory)ctx.getBean("sqlSessionFactoryBean"); 
		org.apache.ibatis.session.Configuration configuration = bean.getConfiguration();
		
		return configuration;
	}
	
	
}
