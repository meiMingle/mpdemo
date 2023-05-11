package com.example.mpdemo.modules.businessa.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mpdemo.modules.businessa.domain.Employees;
import com.example.mpdemo.modules.businessa.service.EmployeesService;
import com.example.mpdemo.modules.businessa.mapper.EmployeesMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author TomXin
* @description 针对表【employees】的数据库操作Service实现
* @createDate 2022-08-18 00:22:42
*/
@Service
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees>
    implements EmployeesService{
    @Transactional
    @Override
    public boolean remove(Wrapper<Employees> queryWrapper) {
        boolean remove = super.remove(queryWrapper);
        int i = 1/0;
        return remove;
    }

    @Override
    public List<Employees> selectByXml(String param) {
        return getBaseMapper().selectByXml(param);
    }

    @Override
    public void insertBatch(List<Employees> list) {
        getBaseMapper().insertList(list);
    }
}




