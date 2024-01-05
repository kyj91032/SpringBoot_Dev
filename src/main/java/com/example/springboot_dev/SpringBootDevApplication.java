package com.example.springboot_dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDevApplication {

	/*
	@SpringBootApplication 어노테이션에는 @ComponentScan이 포함
	이는 Spring이 특정 패키지 아래의 컴포넌트들을 찾아서 빈으로 등록하게끔 하는 역할 수행
	@ComponentScan은 @Controller, @Service, @Repository, @Component 어노테이션이 붙은 클래스(@Component 어노테이션이 포함)들을 찾아서
	Spring 컨테이너에 빈으로 등록
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDevApplication.class, args);
		// 스프링부트 어플리케이션을 시작
	}

}
