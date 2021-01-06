package com.rainsunset.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.util.Optional;
import java.util.Set;

/**
 * @author ChenYanRui
 */
@Configuration
public class RedisConfig {

    @Value("${application.server.redis.mode}")
    String redisMode;

    @Value("${application.server.redis.nodes}")
    Set<String> redisHostAndPorts;

    @Value("${application.server.redis.password:#{null}}")
    String redisPwd;

    @Bean
    public RedisConnectionFactory connectionFactory() throws IllegalAccessException {
        if ("Standalone".equalsIgnoreCase(redisMode)) {
            Optional<String> optional = redisHostAndPorts.stream().findFirst();
            if (optional.isPresent()) {
                String[] hostAndPort = optional.get().split(":");
                RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration(hostAndPort[0], Integer.parseInt(hostAndPort[1]));
                standaloneConfig.setPassword(redisPwd);
                return new LettuceConnectionFactory(standaloneConfig);
            } else {
                throw new IllegalAccessException("");
            }
        } else if ("Sentinel".equalsIgnoreCase(redisMode)) {
            RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration("mymaster", redisHostAndPorts);
            sentinelConfig.setPassword(redisPwd);
            return new LettuceConnectionFactory(sentinelConfig);
        } else if ("Cluster".equalsIgnoreCase(redisMode)) {
            RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration(redisHostAndPorts);
            clusterConfig.setMaxRedirects(3);
            clusterConfig.setPassword(redisPwd);
            return new LettuceConnectionFactory(clusterConfig);
        } else {
            throw new IllegalAccessException("不支持的 Redis 启动模式" + redisMode + "，请设置 redis.mode=[ Standalone | Sentinel | Cluster ]");
        }
    }

}