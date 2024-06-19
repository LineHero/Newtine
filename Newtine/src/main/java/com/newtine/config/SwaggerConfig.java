package com.newtine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

//Swagger 관련 설정 
@Configuration
public class SwaggerConfig {
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info()
	            		  .title("NEWTINE SBB REST API")
	            		  .description("NEWTINE REST API입니다.")
	            		  .version("0.0.1")
	            		  .license(new License().name("SSAFY").url("https://www.ssafy.com"))
	              );
	  }
}
