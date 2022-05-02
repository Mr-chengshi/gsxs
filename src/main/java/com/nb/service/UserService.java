package com.nb.service;

import com.nb.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserService {


    public boolean login(User user) throws IOException;


    public boolean register(User user) throws IOException;


    public List<User> findall() throws IOException;
}
