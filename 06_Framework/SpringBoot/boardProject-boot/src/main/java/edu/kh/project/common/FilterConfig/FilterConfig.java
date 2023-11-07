package edu.kh.project.common.FilterConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.kh.project.common.fliter.AdminFilter;
import edu.kh.project.common.fliter.LoginFilter;

/*
Filter
- 걸러주기
- 추가하기

클라이언트 요청/응답 <-> Filter 
<-> DispatcherServlet <-> Interceptor <-> Controller 
<-> Service <-> Mapper <-> DB




Spring에서 Filter 사용하기

0. spring-starter-web 추가
1. Filter 생성 -> 필터 동작 작성
2. FilterConfig 생성 
3. FilterConfig에서 생성된 필터를 어떤 요청에 끼워 넣을지 지정
*/

@Configuration // 설정용 클래스(서버 켜지자마자 실행)
public class FilterConfig {

	@Bean // 해당 메서드에서 반환된 객체를 bean으로 등록
	public FilterRegistrationBean<LoginFilter> loginFilter(){
		
		// FilterRegistrationBean : 필터 등록 bean
		FilterRegistrationBean<LoginFilter> filter = new FilterRegistrationBean<>();

		filter.setFilter(new LoginFilter()); // 사용할 필터 객체 추가
		
		String[] filteringUrl = {"/myPage/*", "/editBoard/*"};
		
		//  Arrays.asList(배열) : 배열 -> List로 변환
		filter.setUrlPatterns(Arrays.asList(filteringUrl)); // 필터링할 주소 지정
		
		filter.setName("loginFilter"); // 필터 이름 지정
		
		filter.setOrder(1); // 필터 순서
		
		return filter;
	}
	
	@Bean
	public FilterRegistrationBean<AdminFilter> adminFilter() {
		
		FilterRegistrationBean<AdminFilter> filter = new FilterRegistrationBean<>();
		
		filter.setFilter(new AdminFilter());

		
		// 리스트 이용해서 필터 적용 url 추가
		List<String> filteringUrl = new ArrayList<>();
		filteringUrl.add("/admin/*");
		filter.setUrlPatterns(filteringUrl);
		filter.setName("adminFilter");
		filter.setOrder(2);
		
		return filter;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
