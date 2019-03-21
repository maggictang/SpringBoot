package com.springboot.dao.master;

import com.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserDao {

    User findByName(@Param("userName") String userName);
}
