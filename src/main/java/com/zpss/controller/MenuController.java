package com.zpss.controller;

import com.zpss.model.Menu;
import com.zpss.model.MenuTree;
import com.zpss.model.ResponseVo;
import com.zpss.model.User;
import com.zpss.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("menu")
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("updMenu")
    public ResponseVo updMenu(Integer roleId, Integer[] midArr) {
        menuService.updMenu(roleId, midArr);
        return new ResponseVo(0, "成功");
    }

    @GetMapping("getTrees")
    public ResponseVo getTrees(Integer rid) {
        List<MenuTree> trees = menuService.getTrees(rid);
        return new ResponseVo(0, "成功", trees);
    }

    @GetMapping("getMenus")
    public ResponseVo getMenus(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Menu> menus = menuService.getMenuTree(user);
        return new ResponseVo(0, "成功", menus);
    }
}
