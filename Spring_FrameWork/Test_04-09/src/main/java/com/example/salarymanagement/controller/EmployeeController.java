package com.example.salarymanagement.controller;

import com.example.salarymanagement.model.Employee;
import com.example.salarymanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", service.getAllEmployees());
        return "index";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        String message = service.saveEmployee(employee);

        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", service.getAllEmployees());

        if (message.startsWith("Error")) {
            model.addAttribute("errorMessage", message);
        } else {
            model.addAttribute("successMessage", message);
        }

        return "index";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", service.getEmployeeById(id));
        model.addAttribute("employees", service.getAllEmployees());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model) {
        service.deleteEmployee(id);
        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", service.getAllEmployees());
        return "index";
    }
}
