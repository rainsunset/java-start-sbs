/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.ligw.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ligw
 * @version $Id apiController.java, v 0.1 2018-07-09 17:03 ligw Exp $$
 */
@Api(tags = "框架测试")
@RestController
@RequestMapping("/test")
public class apiController {

    @Value("${demoprop.name}")
    private String demopropName;

    @Value("${demoprop.sex}")
    private Integer demopropSex;

    @Value("${random.int[10,20]}")
    private Integer randomNum;

    @ApiOperation(value = "框架测试")
    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String Hello(){
        return "hellow Spring Cloud";
    }

    @ApiOperation(value = "配置参数测试")
    @RequestMapping(value = "/propTest" ,method = RequestMethod.GET)
    public String propTest(){
        return String.format("name:%s,sex:%d,age:%d", demopropName, demopropSex,randomNum);
    }

}
