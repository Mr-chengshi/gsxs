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

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper mapper;

    public boolean login(User user) throws IOException {

        User denglu = mapper.denglu(user);
        if (denglu!=null){
            //向session中存入信息


            return true;
        }
        return false;
    }

   public boolean register(User user) throws IOException {

       boolean denglu = mapper.zhuce(user);
       return denglu;
   }
   public List<User> findall() throws IOException {

       List<User> findall = mapper.findall();
      return findall;

    }


}
