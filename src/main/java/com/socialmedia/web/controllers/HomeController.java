package com.socialmedia.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/home")
    public @ResponseBody String displaySomething(){
        String sentence = "Today is certainly a great day";
        return sentence;
    }
}
