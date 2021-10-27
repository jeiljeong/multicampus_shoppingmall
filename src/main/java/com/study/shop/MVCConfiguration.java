package com.study.shop;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
public class MVCConfiguration implements WebMvcConfigurer {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
 
// URL에 "/admin/"이 들어간 요청은 AdminInterceptor 작동함.
    registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
//  notice에서 게시판 내용을 등록, 수정, 삭제할 경우 Admin이 아니면 login 필요
    registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/notice/create");
    registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/notice/update");
    registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/notice/delete");
  }
}