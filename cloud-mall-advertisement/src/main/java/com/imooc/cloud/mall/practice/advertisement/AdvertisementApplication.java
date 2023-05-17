package com.imooc.cloud.mall.practice.advertisement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 广告启动类
 */
@SpringBootApplication
@MapperScan("com.imooc.cloud.mall.practice.advertisement.model.dao")
@EnableFeignClients
@EnableRedisHttpSession
public class AdvertisementApplication {
  public static void main(String[] args) {
    SpringApplication.run(AdvertisementApplication.class, args);
  }
}
