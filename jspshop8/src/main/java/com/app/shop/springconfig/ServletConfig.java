package com.app.shop.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.shop.DBconfig.ContextDataSource;
import com.app.shop.DBconfig.ContextSqlmapper;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.app.shop"})
@Import({ContextDataSource.class, ContextSqlmapper.class })
public class ServletConfig implements WebMvcConfigurer{

//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		
//		InternalResourceViewResolver bean = new InternalResourceViewResolver();
//		bean.setPrefix("/WEB-INF/views/");
//		bean.setSuffix(".jsp");
//		registry.viewResolver(bean);
//	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	

}
