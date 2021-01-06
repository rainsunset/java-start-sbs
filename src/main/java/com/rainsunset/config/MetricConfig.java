package com.rainsunset.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Histogram;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 上报必要组件(必需)
 *
 * @author ChenYanRui
 * @since 2020/5/11
 */
@Configuration
public class MetricConfig {
    /**
     * 使用javacore的MetricUtil需创建全局的CollectorRegistry
     */
    @Bean
    public CollectorRegistry collectorRegistry() {
        return CollectorRegistry.defaultRegistry;
    }

    /**
     * 使用@Timed注解需搭配切面
     */
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }
}
