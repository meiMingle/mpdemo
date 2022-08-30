package com.example.mpdemo;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.example.mpdemo.modules.businessa.mapper.EmployeesMapper;
import com.example.mpdemo.modules.businessa.service.EmployeesService;
import com.example.mpdemo.modules.businessa.service.impl.EmployeesServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

@MybatisPlusTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportAutoConfiguration(value = {EmployeesServiceImpl.class})
@Rollback(value = true)//单元测试执行完,默认回滚事务，false不会回滚
class MybatisPlusFastTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    EmployeesMapper employeesMapper;
    @Autowired
    EmployeesService employeesService;


    @Test
    void baseMapperQuery() {
        System.out.println(("----- selectAll method test ------"));
        long count = employeesService.count();
        logger.info("总条数:{}",count);
    }
}
