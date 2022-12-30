package com.zpss.service;

import com.github.pagehelper.PageInfo;
import com.zpss.model.User;
import com.zpss.model.UserVo;

public interface UserService {//定义标准的
    Integer getStatus(String loginName);

    User login(User user);

    PageInfo<User> getUsers(UserVo userVo, Integer pageIndex, Integer pageSize);

    void addUser(User user);

    void updateUser(User user);

    void updateStatus(Integer uid, Integer status);

    void deleteUser(Integer id);
}
