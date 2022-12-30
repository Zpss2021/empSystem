package com.zpss.controller;

import com.github.pagehelper.PageInfo;
import com.zpss.model.ResponseVo;
import com.zpss.model.Role;
import com.zpss.model.User;
import com.zpss.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("updStatus")
    public ResponseVo updStatus(Integer rid, Integer status) {
        Role role = new Role(rid, status);
        roleService.updStatus(role);
        if (role.getStatus() == 0)
            return new ResponseVo(0, "启动成功");
        return new ResponseVo(0, "禁用成功");
    }

    @GetMapping("delPosition")
    public ResponseVo delPosition(Integer rid) {
        roleService.deleteRole(rid);
        return new ResponseVo(0, "删除成功");
    }

    @PostMapping("addOrUpdPosition")
    public ResponseVo addOrUpdPosition(Role role, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (role.getId() == null) {
            role.setCreateBy(user.getName());
            boolean isExists = roleService.addRole(role);
            if (isExists)
                return new ResponseVo(1, "该角色已存在");
            return new ResponseVo(0, "添加成功");
        }
        boolean isExists = roleService.updateRole(role);
        if (isExists)
            return new ResponseVo(1, "该角色已存在");
        return new ResponseVo(0, "修改成功");
    }

    @GetMapping("gets")
    public ResponseVo gets(@RequestParam(value = "page", defaultValue = "0") Integer pageIndex, @RequestParam(value = "limit", defaultValue = "5") Integer pageSize) {
        PageInfo pageInfo = roleService.get(pageIndex, pageSize);
        return new ResponseVo(0, "成功", pageInfo);
    }

    @GetMapping("getRoles")
    public ResponseVo getRoles() {
        return new ResponseVo(0, "成功", roleService.getRoles());
    }
}
