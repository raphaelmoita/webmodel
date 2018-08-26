package org.moita.sb2.web;

import org.moita.sb2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/company")
public class CompanyWebController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public String root() {
        return "redirect:/web/company/listar";
    }

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("employees");
        mv.addObject("list_employees", companyService.listEmployees());
        return mv;
    }
}
