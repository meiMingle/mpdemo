package com.example.mpdemo.modules.businessa.mapper;

import com.example.mpdemo.modules.businessa.domain.Employees;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author TomXin
 * @description 针对表【employees】的数据库操作Mapper
 * @createDate 2022-08-18 00:22:42
 * @Entity com.example.mpdemo.modules.businessa.domain.Employees
 */
@Mapper
public interface EmployeesMapper extends BaseMapper<Employees> {
    @Select("select * from employees where first_name like #{firstnameParam}")
    List<Employees> selectByAnnotation(String firstnameParam);

    List<Employees> selectByXml(String firstnameParam);

    void insertList(List<Employees> list);
}




