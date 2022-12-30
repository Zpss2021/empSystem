package com.zpss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpss.mapper.UserMapper;
import com.zpss.model.User;
import com.zpss.model.UserRole;
import com.zpss.model.UserVo;
import com.zpss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer getStatus(String loginName) {
        return userMapper.getStatus(loginName);
    }

    @Override
    public User login(User user) {
        User u = userMapper.login(user);
        return u;
    }

    @Override
    public PageInfo<User> getUsers(UserVo userVo, Integer pageIndex, Integer pageSize) {
        //设置第几页，页大小
        PageHelper.startPage(pageIndex, pageSize);
        List<User> users = userMapper.gets(userVo);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
        Integer userId = userMapper.getUserId();
        UserRole ur = new UserRole(userId, user.getRole().getId());
        userMapper.addUserRole(ur);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
        UserRole ur = new UserRole(user.getId(), user.getRole().getId());
        userMapper.updateUserRole(ur);
    }

    @Override
    public void updateStatus(Integer uid, Integer status) {
        userMapper.updateStatus(uid, (status == 0) ? 1 : 0);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }
}
