package com.rainsunset.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Druid 监控页面访问配置(不需要可删除)
 * 默认访问uri /druid
 *
 * @author ChenYanRui
 * @since 2019/11/25
 */
@Profile("!prod")
@Configuration
public class DruidUiConfig {

    @Value("#{'${druid.url.mappings:/druid/*}'.split(',')}")
    private String[] druidUrlMappings;
    @Value("#{'${druid.url.patterns:/*}'.split(',')}")
    private String[] druidUrlPatterns;
    @Value("${druid.url.exclusions:*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*}")
    private String druidUrlExclusions;
    @Value("#{'${druid.ip.allows:}'.split(';')}")
    private String[] druidAllowIps;
    @Value("#{'${druid.ip.denys:}'.split(';')}")
    private String[] druidDenyIps;
    @Value("${druid.login.user:}")
    private String druidLoginUser;
    @Value("${druid.login.pwd:}")
    private String druidLoginPwd;
    @Value("${druid.reset.enable:true}")
    private String resetEnable;

    /**
     * 注册一个StatViewServlet
     */
    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        // org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), druidUrlMappings);
        // 添加初始化参数：initParams
        // 白名单：
        if (druidAllowIps != null) {
            for (String druidAllowIp : druidAllowIps) {
                servletRegistrationBean.addInitParameter("allow", druidAllowIp);
            }
        }
        // IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        if (druidAllowIps != null) {
            for (String druidDenyIp : druidDenyIps) {
                servletRegistrationBean.addInitParameter("deny", druidDenyIp);
            }
        }
        // 登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", druidLoginUser);
        servletRegistrationBean.addInitParameter("loginPassword", druidLoginPwd);
        // 是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", resetEnable);
        return servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns(druidUrlPatterns);
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", druidUrlExclusions);
        return filterRegistrationBean;
    }

}