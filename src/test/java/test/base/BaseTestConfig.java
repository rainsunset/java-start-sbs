package test.base;

import com.rainsunset.Starter;
import lombok.extern.slf4j.Slf4j;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.PostConstruct;

/**
 * 单元测试基础配置
 * 针对第三方框架的客户端mock在此处理，如PulsarClient、RedisTemplate等
 *
 * @author ChenYanRui
 * @since 2020/3/2
 */
@PropertySource({"classpath:application-local.yml"})
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class,
        KafkaAutoConfiguration.class
})
@ComponentScan(basePackages = "com.cmbi", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Starter.class),
        @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.rainsunset.dal.*"),
        @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.rainsunset.config.*")
})
@Slf4j
public class BaseTestConfig {

    @MockBean
    private RedisTemplate<String, String> redisTemplate;

    @MockBean
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void init() throws Exception {
        log.info("mock redisTemplate ...");
        mockRedisTemplate();
        log.info("mock kafkaTemplate ...");
        mockKafkaTemplate();
    }

    /**
     * 预设kafkaTemplate行为，具体单元测试需自定义返回可在对应测试类中@SpyBean引入kafkaTemplate做mock
     */
    private void mockKafkaTemplate() throws Exception {
        // demo
        ListenableFuture mockFuture = Mockito.mock(ListenableFuture.class);
        Mockito.doReturn(null).when(mockFuture).get();
        // mock kafkaTemplate.send(topic, data) return mockFuture which will get null
        Mockito.doReturn(mockFuture).when(kafkaTemplate).send(Mockito.anyString(), Mockito.anyString());
    }

    /**
     * 预设redisTemplate行为，具体单元测试需自定义返回可在对应测试类中@SpyBean引入redisTemplate做mock
     */
    private void mockRedisTemplate() {
        // demo
        ValueOperations mockValueOps = Mockito.mock(ValueOperations.class);
        Mockito.doReturn("6666666").when(mockValueOps).get(Mockito.anyString());
        Mockito.doReturn(mockValueOps).when(redisTemplate).opsForValue();
    }
}
