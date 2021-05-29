package com.socialmedia.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
    @GetMapping("/test")
    public @ResponseBody String displaySomethingElse(){
//        StringBuilder stringBuilder = new StringBuilder("This is a test");
//        stringBuilder.append("And another one");
//        System.out.println( stringBuilder);
        return "This is a test also...";
    }
}
