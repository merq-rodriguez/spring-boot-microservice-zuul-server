package com.example.app.zuulserver.config;

import com.example.app.zuulserver.filters.PostElapseTimeFilter;
import com.example.app.zuulserver.filters.PreElapseTimeFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class Config {
  @Bean
	public PreElapseTimeFilter preFilter() {
		return new PreElapseTimeFilter();
	}
	
	@Bean
	public PostElapseTimeFilter postFilter() {
		return new PostElapseTimeFilter();
	}
}
