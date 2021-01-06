package com.rainsunset.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka consumer示例
 *
 * @author ChenYanRui
 * @since 2020/5/28
 */
@Slf4j
@Component
public class DemoKafkaConsumer {
    @KafkaListener(topics = "java_starter_topic")
    public void consume(ConsumerRecord<String, String> record) {
        log.info("[consumer1]" + record.toString());
    }
    @KafkaListener(topics = "java_starter_topic2")
    public void consume2(ConsumerRecord<String, String> record) {
        log.info("[consumer2]" + record.toString());
    }
}
