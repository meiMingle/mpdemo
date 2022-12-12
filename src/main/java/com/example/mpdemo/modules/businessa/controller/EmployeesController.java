package com.example.mpdemo.modules.businessa.controller;

import com.example.mpdemo.modules.businessa.domain.Employees;
import com.example.mpdemo.modules.businessa.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    EmployeesService employeesService;

    @PostMapping("/selectByXml")
    public List<Employees> selectByXml(String param) {
        return  employeesService.selectByXml(param);
    }
}
