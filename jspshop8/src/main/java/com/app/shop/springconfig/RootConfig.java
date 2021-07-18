package com.app.shop.springconfig;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.app.shop.DBconfig.ContextDataSource;
import com.app.shop.DBconfig.ContextSqlmapper;
import com.app.shop.config.SecurityConfig;

@Configuration
@Import({SecurityConfig.class, ContextDataSource.class, ContextSqlmapper.class})
@ComponentScan(basePackages = {"com.app.shop.domain.repository"})
public class RootConfig {

	
	
	//ContextDataSource.class
	//	ContextSqlmapper.class
}
