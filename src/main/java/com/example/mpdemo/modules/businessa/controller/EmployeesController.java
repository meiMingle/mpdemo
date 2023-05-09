package com.example.mpdemo.modules.businessa.controller;

import com.example.mpdemo.modules.businessa.domain.Employees;
import com.example.mpdemo.modules.businessa.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
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

    @PostMapping("/batchInsert")
    public void batchInsert(String param) {
        Employees employees = new Employees();
        employees.setEmpNo(1022220);
        employees.setFirstName("TestInsert0");
        employees.setLastName("TestInsert0");
        employees.setBirthDate(new Date());
        employees.setHireDate(new Date());
        Employees employees1 = new Employees();
        employees1.setEmpNo(1022221);
        employees1.setFirstName("TestInsert0");
        employees1.setLastName("TestInsert0");
        employees1.setBirthDate(new Date());
        employees1.setHireDate(new Date());
        List<Employees> list = new ArrayList<>();
        list.add(employees);
        list.add(employees1);
        employeesService.removeBatchByIds(list);
        employeesService.saveBatch(list);
    }
}
