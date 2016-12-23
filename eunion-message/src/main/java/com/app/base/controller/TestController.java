package com.app.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by BF100365 on 2016/12/15.
 */
@Controller
@RequestMapping("/")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = {"/","/index"})
    public String getAllData(){
        logger.debug("cceshioshdfoaih");
        return "index";
    }

}
