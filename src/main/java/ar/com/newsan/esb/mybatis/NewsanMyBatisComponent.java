package ar.com.newsan.esb.mybatis;

import org.apache.camel.component.mybatis.MyBatisComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.newsan.esb.mybatis.session.CustomSqlSessionFactory;

@Component(value = "mybatis")
//@ImportResource({"classpath:ar/com/newsan/esb/mybatis/SqlMapConfig.xml" })
public class NewsanMyBatisComponent extends MyBatisComponent {
	
//	@Autowired
//	private CustomSqlSessionFactoryBean sqlSessionFactoryBean;
	
//	@Autowired
//	private CustomSqlSessionFactory sqlSessionFactory;

}
