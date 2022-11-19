package com.rkdevblog.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.rkdevblog.interceptors.RedisTraceInterceptor;

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        datadog.trace.api.GlobalTracer.get().addTraceInterceptor(new RedisTraceInterceptor());
        SpringApplication.run(RedisApplication.class, args);
    }
}
