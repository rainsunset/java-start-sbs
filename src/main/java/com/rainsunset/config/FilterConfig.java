package com.rainsunset.config;

import com.cmbi.javacore.filter.HttpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * prometheus http过滤
 * HttpFilter包含能力：针对http接口调用次数和调用耗时上报
 *
 * @author fangpingchou
 * @date 2019/12/16
 */
@Configuration
public class FilterConfig {

    /**
     * 注册filter
     */
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new HttpFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
