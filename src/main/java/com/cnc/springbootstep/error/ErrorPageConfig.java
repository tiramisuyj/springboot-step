package com.cnc.springbootstep.error;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/** 
* @author yj 
* @date 2019-02-18 
*/
@Configuration
public class ErrorPageConfig {
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			
			@Override
			public void customize(ConfigurableEmbeddedServletContainer arg0) {
				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
				arg0.addErrorPages(error404Page);
			}
		};
	}

}
