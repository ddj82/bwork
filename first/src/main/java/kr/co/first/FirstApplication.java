package kr.co.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

//	스프링 부트 애플리케이션에서 CORS(Cross-Origin Resource Sharing)를 설정하는 방법임.
//	CORS는 다른 출처(origin)로부터의 요청을 허용하는 메커니즘을 제공하여, 
//	웹 애플리케이션이 동일한 출처 정책(Same Origin Policy)을 우회하여 리소스를 공유할 수 있도록 해준다.
//	- addMapping("/**") : 모든 URL 패턴에 대해 CORS 설정을 적용함을 의미
//	- allowedOrigins("http://localhost:3000")
//	=> http://localhost:3000을 허용할 오리진(origin)항목으로 지정하겠다는 의미임.
//
//	**다시말해 클라이언트 애플리케이션( http://localhost:3000)이 다른 출처(origin)에서 해당 스프링 부트 애플리케이션의 리소스에 접근할 수 있도록 해주는 의미임.
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}
}