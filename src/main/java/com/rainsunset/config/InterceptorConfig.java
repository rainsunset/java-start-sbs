package com.rainsunset.config;

import com.cmbi.javacore.interceptor.HttpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * prometheus http拦截
 * HttpInterceptor包含能力：打印http请求url、入参、接口耗时、TRACE_LOG_ID处理等
 *
 * @author fangpingchou
 * @date 2019/12/12
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor());
    }

}
