package com.newtine.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Web 관련 설정
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//자원 설정 
		registry.addResourceHandler("/**").addResourceLocations("C:/Users/SSAFY/Desktop/SSAFIT/ssafit_final_project_chan_woong/newtine_front/public");
	}

	// CORS 에러 전역 처리 
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        	.allowedOriginPatterns("*") // 요청을 보낼 수 있는 도메인
        	.allowedMethods("POST", "GET", "PUT", "DELETE")
        	.allowCredentials(true); // 자격 증명 허용

	}
	
	// 인터셉터 등 처리 가능
//	@Autowired
//	private JwtInterceptor jwtInterceptor;
//	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
//		.excludePathPatterns("/api-user/**", "/swagger-ui/**", "/v3/api-docs/**");
//	}
}
