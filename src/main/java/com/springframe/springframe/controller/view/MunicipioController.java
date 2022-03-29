package com.springframe.springframe.controller.view;

import com.springframe.springframe.model.form.MunicipioForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MunicipioController {

    @RequestMapping(method = RequestMethod.GET, value = "municipio/novo")
    public String form(Model model){
        model.addAttribute("form", new MunicipioForm());
        return "/cadastros/municipio/form";
    }
}
