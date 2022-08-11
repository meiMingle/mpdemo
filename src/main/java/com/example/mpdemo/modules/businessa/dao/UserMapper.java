package com.example.mpdemo.modules.businessa.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.modules.businessa.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
