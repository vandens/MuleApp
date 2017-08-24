package com.my.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    
    @RequestMapping("/testonk")
    public ModelAndView getRequest(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Nooooothing");
        String message = "notihign";
        ModelAndView model = new ModelAndView();
        model.addObject("message",message);
        return model;
    }
    
    public String power(String value) {

        return "nothing";
    }    
}
