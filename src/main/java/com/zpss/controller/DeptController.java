package com.zpss.controller;

import com.github.pagehelper.PageInfo;
import com.zpss.model.Dept;
import com.zpss.model.ResponseVo;
import com.zpss.model.User;
import com.zpss.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("getDepts")
    public ResponseVo getDepts() {
        return new ResponseVo(0, "成功", deptService.getDepts());
    }

    @GetMapping("gets")
    public ResponseVo gets(@RequestParam(defaultValue = "1", value = "page") Integer startIndex, @RequestParam(defaultValue = "5", value = "limit") Integer pageSize) {
        PageInfo gets = deptService.gets(startIndex, pageSize);
        return new ResponseVo(0, "成功", gets);
    }

    @GetMapping("updStatus")
    public ResponseVo updStatus(Dept dept) {
        deptService.updStatus(dept);
        if (dept.getStatus() == 1)
            return new ResponseVo(0, "禁用成功");
        return new ResponseVo(0, "启用成功");
    }

    @GetMapping("delDept")
    public ResponseVo delDept(Integer id) {
        deptService.delDept(id);
        return new ResponseVo(0, "删除成功");
    }

    @PostMapping("addOrUpdPosition")
    public ResponseVo addOrUpdPosition(Dept dept, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (dept.getId() == null) {
            dept.setCreateBy(user.getName());
            boolean isExists = deptService.addDept(dept);
            if (isExists)
                return new ResponseVo(1, "该部门已存在");
            return new ResponseVo(0, "添加成功");
        }
        boolean isExists = deptService.updateDept(dept);
        if(isExists)
            return new ResponseVo(1, "该部门已存在");
        return new ResponseVo(0, "修改成功");
    }
}
