package com.nb.mapper;

import com.nb.domain.User;

import java.util.List;

public interface UserMapper {

    //    登录
    User denglu(User user);

    //    注册
    boolean zhuce(User user);

    //    查询所有
    List<User> findall();

    //    根据id查
    User findbyid(String username);

    //更新用户信息
    Boolean updateById(User user);

}
