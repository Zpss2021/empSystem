package com.zpss.controller;

import com.github.pagehelper.PageInfo;
import com.zpss.model.ResponseVo;
import com.zpss.model.User;
import com.zpss.model.UserVo;
import com.zpss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("getSessionData")
    public ResponseVo getSessionData(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return new ResponseVo(0, "成功", user);
    }

    // 更新状态
    @GetMapping("updStatus")
    private ResponseVo updStatus(Integer uid, Integer status, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (uid == user.getId())
            return new ResponseVo(1, "不能修改自己");
        userService.updateStatus(uid, status);
        return new ResponseVo(0, "成功");
    }

    @GetMapping("deleteUser")
    private ResponseVo updStatus(Integer id) {
        userService.deleteUser(id);
        return new ResponseVo(0, "成功");
    }

    // 添加/编辑用户
    @PostMapping("editUser")
    public ResponseVo editUser(User user) {
        if (user.getId() == null) {
            // 添加
            userService.addUser(user);
            return new ResponseVo(0, "添加成功");
        }
        userService.updateUser(user);
        // 修改
        return new ResponseVo(0, "修改成功");
    }

    // 登录
    @PostMapping("login")
    public ResponseVo login(User user, HttpSession session) {
        Integer status = userService.getStatus(user.getUser());
        if (status == 1) {
            return new ResponseVo(1, "账号已被锁定");
        }
        User u = userService.login(user);
        if (u == null) {
            return new ResponseVo(1, "账号密码不一致");
        }
        session.setAttribute("user", u);
        return new ResponseVo(0, "登录成功");
    }

    // 获取所有员工
    @GetMapping("getUsers")
    public ResponseVo getUsers(UserVo userVo, @RequestParam(value = "page", defaultValue = "1") Integer startIndex, @RequestParam(value = "limit", defaultValue = "5") Integer pageSize) {
        PageInfo<User> users = userService.getUsers(userVo, startIndex, pageSize);
        ResponseVo rv = new ResponseVo(0, "成功", users);
        return rv;
    }
}
