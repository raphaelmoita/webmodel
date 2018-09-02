package org.moita.sb2.web;

import org.moita.sb2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/employee")
public class EmployeeWebController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String root() {
        return "redirect:/web/employee/listar";
    }

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("employees");
        mv.addObject("list_employees", employeeService.listEmployees());
        return mv;
    }
}
