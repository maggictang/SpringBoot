package com.springboot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam("name") String name) {
        return "Hello" + name;
    }

}
