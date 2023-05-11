package com.example.mpdemo.modules.businessa.service;

import com.example.mpdemo.modules.businessa.domain.Employees;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author TomXin
* @description 针对表【employees】的数据库操作Service
* @createDate 2022-08-18 00:22:42
*/
public interface EmployeesService extends IService<Employees> {

    List<Employees> selectByXml(String param);

    void insertBatch(List<Employees> list);
}
