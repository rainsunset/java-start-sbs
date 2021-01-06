package com.rainsunset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author develop
 */
@EnableKafka
@RestController
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@EnableTransactionManagement
@SpringBootApplication(
        scanBasePackages = "com.cmbi"
)
@ImportResource({
            "classpath:/spring/druid.xml",
            "classpath:/spring/datasource-parent.xml",
            "classpath:/spring/datasource-db1.xml",
            "classpath:/spring/datasource-db2.xml"
})
public class Starter extends SpringBootServletInitializer {

    /**
     * 服务启动方法
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Starter.class);
    }
}
