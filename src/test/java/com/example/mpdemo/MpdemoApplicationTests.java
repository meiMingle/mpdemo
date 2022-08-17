package com.example.mpdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mpdemo.modules.businessa.domain.Employees;
import com.example.mpdemo.modules.businessa.mapper.EmployeesMapper;
import com.example.mpdemo.modules.businessa.service.EmployeesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Rollback(value = false)
class MpdemoApplicationTests {

    @Autowired
    EmployeesMapper employeesMapper;
    @Autowired
    EmployeesService employeesService;

    @Test
    void baseMapperQuery() {
        System.out.println(("----- selectAll method test ------"));
        List<Employees> userList = employeesMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void customAnnotationQuery() {
        System.out.println(("----- Annotation method test ------"));
        List<Employees> userList = employeesMapper.selectByAnnotation("Lim%");
        userList.forEach(System.out::println);
    }
    @Test
    void customXmlQuery() {
        System.out.println(("----- XmlQuery method test ------"));
        List<Employees> userList = employeesMapper.selectByXml("Lim%");
        userList.forEach(System.out::println);
    }

    @Test
    void pagehelpr() {
        System.out.println(("----- pagehelper method test ------"));
        long count = PageHelper.startPage(1, 2).doCount(() -> employeesMapper.selectList(null));
        System.out.println(count);
    }

    @Test
    void pagehelprXml() {
        System.out.println(("----- pagehelperXml method test ------"));
        Page<Object> page = PageHelper.startPage(1, 2).doSelectPage(() -> employeesMapper.selectByXml("Lim%"));
        System.out.println(page);
    }

    @Test
    void TransactionTest() {
        System.out.println(("----- Transactional method test ------"));
        QueryWrapper<Employees> wrapper = new QueryWrapper<>();
        wrapper.likeRight("first_name", "Ji");
        employeesService.remove(wrapper);
    }



}
