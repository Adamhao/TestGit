package com.adam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Adam on 2018/11/29 20:14.
 */
@Controller
public class AliController {

    @RequestMapping(value = "/returnUrl")
    public String returnUrl() {
        return null;
    }

    @RequestMapping(value = "/notifyUrl")
    public String notifyUrl() {
        return null;
    }
}
