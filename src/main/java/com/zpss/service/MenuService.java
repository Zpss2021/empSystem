package com.zpss.service;

import com.zpss.model.Menu;
import com.zpss.model.MenuTree;
import com.zpss.model.User;

import java.util.List;

public interface MenuService {
    public List<Menu> getMenuTree(User user);

    List<MenuTree> getTrees(Integer rid);

    void updMenu(Integer roleId, Integer[] midArr);
}
