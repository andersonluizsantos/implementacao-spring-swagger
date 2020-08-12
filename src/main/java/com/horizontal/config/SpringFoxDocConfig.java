package com.horizontal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxDocConfig implements WebMvcConfigurer{
	
	 private ApiInfo metaData() {
	    return new ApiInfoBuilder()
	        .title("Documentação Horizontal Swagger SpringFox")
	        .description("\"Documentação gerada automaticamente com o swagger springfox \"")
	        .version("1.0.0")
	        .license("Apache License Version 2.0")
	        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
	        .build();
	 }
	
	 @Bean
	 public Docket Api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("com.horizontal.controller"))
	        .build()
	        .apiInfo(metaData());

	  }
	 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html")
	      .addResourceLocations("classpath:/META-INF/resources/");
	 
	    registry.addResourceHandler("/webjars/**")
	      .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
