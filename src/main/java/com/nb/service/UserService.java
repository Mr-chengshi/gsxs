package com.nb.service;

import com.nb.domain.User;

import java.io.IOException;

public interface UserService {


    public boolean login(User user) throws IOException;


    public boolean register(User user) throws IOException;


    public  User selectUser(String xid);

    Boolean updateUser(User user);
}
