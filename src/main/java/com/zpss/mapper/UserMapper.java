package com.zpss.mapper;

import com.zpss.model.User;
import com.zpss.model.UserRole;
import com.zpss.model.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User login(User user);

    List<User> gets(UserVo userVo);

    void addUser(User user);

    Integer getUserId();

    void addUserRole(UserRole ur);

    void updateUser(User user);

    void updateUserRole(UserRole ur);

    void updateStatus(@Param("id") Integer uid, @Param("s") Integer status);

    void deleteUser(Integer id);

    Integer getStatus(String user);
}
