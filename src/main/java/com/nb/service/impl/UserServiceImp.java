package com.nb.service.impl;

import com.nb.mapper.UserMapper;
import com.nb.domain.User;
import com.nb.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper mapper;

    public boolean login(User user) throws IOException {

        User denglu = mapper.denglu(user);
        if (denglu!=null){

            return true;
        }
        return false;
    }

   public boolean register(User user) throws IOException {

       boolean denglu = mapper.zhuce(user);
       return denglu;
   }

    @Override
    public User selectUser(String xid) {


        User user = mapper.findbyid(xid);


        return user;
    }

    @Override
    public Boolean updateUser(User user) {

        return mapper.updateById(user);
    }


}
