package com.springframe.springframe.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String form(Model model){
        return "/login/index";
    }
}
