package com.gkfcsolution.pstock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2025 at 11:44
 * File: null.java
 * Project: pStock
 *
 * @author Frank GUEKENG
 * @date 06/12/2025
 * @time 11:44
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        return "Hello SpringBoot";
    }

}
