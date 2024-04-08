package com.SpringBootThymeleaf.controller;

import com.SpringBootThymeleaf.model.StudentInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentInfoController {

    @RequestMapping(value = "/")
    public  String viewPage(){
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView stdPage(@ModelAttribute StudentInfo studentInfo){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("showPage");
        modelAndView.addObject("sInfo", studentInfo);
        return modelAndView;
    }
}
