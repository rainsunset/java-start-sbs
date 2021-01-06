package com.rainsunset.controller;

import com.rainsunset.service.request.DemoReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ResponseHeader;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;


/**
 * 接口示例
 *
 * @author ChenYanRui
 * @since 2020/5/9
 */
@Api(tags = "测试接口列表")
@Slf4j
@RestController
public class DemoController {
    @ApiOperation("测试接口1")
    @GetMapping("/demo1")
    public Object demo1() {
        return "ok";
    }

    @ApiOperation("测试接口2")
    @GetMapping("/demo2")
    public Object demo2(String key, String value) {
        log.info("demo2, key={}, value={}", key, value);
        return "ok," + key + value;
    }

    @ApiOperation("测试接口3")
    @PostMapping("/demo3")
    public Object demo3(String key, @RequestParam String value) {
        log.info("demo3, key={}, value={}", key, value);
        return "ok," + key + value;
    }

    @ApiOperation("测试接口4")
    @GetMapping("/demo4")
    public Object demo4(@Validated DemoReq param, int no) {
        log.info("demo4, no={}, param={}", no, param);
        return "ok," + param;
    }

    @ApiOperation("测试接口5")
    @PostMapping("/demo5")
    public Object demo5(DemoReq param) {
        log.info("demo5, param={}", param);
        return "ok," + param;
    }

    @ApiOperation("测试接口6")
    @PostMapping("/demo6")
    public Object demo6(@Validated DemoReq param) {
        log.info("demo6, param={}", param);
        return "ok," + param;
    }

    @ApiOperation("测试接口7")
    @PostMapping("/demo7")
    public Object demo7(@RequestBody @Validated DemoReq param) {
        log.info("demo7, param={}", param);
        return "ok," + param;
    }

    @ApiOperation(value = "测试接口8", responseHeaders = @ResponseHeader())
    @GetMapping("/demo8")
    public void demo7(String path, String downLoadFileName, HttpServletResponse res) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ServletOutputStream outputStream = res.getOutputStream();
        res.setContentType(ContentType.APPLICATION_OCTET_STREAM.getMimeType());
        res.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        res.addHeader("Content-Disposition", "attchement;filename=" + URLEncoder.encode(downLoadFileName, StandardCharsets.UTF_8.toString()));
        // FileCopyUtils.copy(in, out) 内部实现了close逻辑
        FileCopyUtils.copy(fileInputStream, outputStream);
        log.info("文件下载 success");
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @ApiOperation("kafka测试接口1")
    @PostMapping("/kafka/demo1")
    public Object kafkaDemo1(String key, String value) {
        kafkaTemplate.send("java_starter_topic", key, value);
        kafkaTemplate.send("java_starter_topic2", key, value);
        return "ok";
    }

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @ApiOperation("redis测试接口1")
    @PostMapping("/redis/demo1")
    public Object redisDemo1(String key, String value) {
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        valueOps.set(key, value, 30, TimeUnit.SECONDS);
        return valueOps.get(key);
    }
}
