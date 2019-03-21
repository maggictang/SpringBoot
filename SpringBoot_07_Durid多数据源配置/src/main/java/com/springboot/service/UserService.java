package com.springboot.service;

import com.springboot.domain.User;

public interface UserService {

    User findByName(String userName);
}
