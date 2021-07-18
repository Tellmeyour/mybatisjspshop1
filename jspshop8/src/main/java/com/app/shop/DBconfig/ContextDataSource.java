package com.app.shop.DBconfig;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class ContextDataSource {
	
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/board1?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("dltkdgudgksgywn0926*");
		dataSource.setDefaultAutoCommit(false);
		return dataSource;
		
	}
	
	// 트랜잭션 매니저 등록
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}


    
}
