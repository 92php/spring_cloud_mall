package com.imooc.cloud.mall.practice.cartorder.filter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Feign请求的拦截器（让Feign携带Session信息）
 */
@EnableFeignClients
@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {
  @Override
  public void apply(RequestTemplate requestTemplate) {
    // 通过RequestContextHolder获取到请求
    RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
    if (attributes == null) {
      return;
    }
    //Feign调用不经过网关
    //把网关中的header信息转移到Feign请求中
    HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();
    Enumeration<String> headerNames = request.getHeaderNames();
    if (headerNames != null){
      while (headerNames.hasMoreElements()){
        String name = headerNames.nextElement();
        Enumeration<String> values = request.getHeaders(name);
        while (values.hasMoreElements()){
          String value = values.nextElement();
          requestTemplate.header(name, value);
        }
      }
    }
  }
}
