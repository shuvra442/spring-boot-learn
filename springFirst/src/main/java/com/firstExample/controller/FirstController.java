package com.firstExample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {
    /**
     * print this return msg
     * @return msg
     */

    @ResponseBody
    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public String sample(){
        System.out.println("I'm sample controller");
        return "I'm sample controller";
    }
}
