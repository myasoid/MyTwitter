package com.miv.mytwitter.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String mainController() {
        return "Main controller :)";
    }
}
