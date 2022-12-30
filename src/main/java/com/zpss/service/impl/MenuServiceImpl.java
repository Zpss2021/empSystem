package com.zpss.service.impl;

import com.zpss.mapper.MenuMapper;
import com.zpss.model.Menu;
import com.zpss.model.MenuTree;
import com.zpss.model.RoleMenu;
import com.zpss.model.User;
import com.zpss.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    // 获得父节点及它子节点集合
    public List<Menu> getMenuTree(User user) {
        // 获得所有菜单
        List<Menu> menus = menuMapper.gets(user.getRole().getId());
        // 获得一级菜单
        List<Menu> firstMenus = new ArrayList<>();
        for (Menu m : menus) {
            if (m.getParentId() == 0) {
                firstMenus.add(m);
            }
        }
        for (Menu menu : firstMenus) {
            menu.setChildren(new ArrayList<>());
            for (Menu m : menus) {
                if (m.getParentId() == menu.getId()) {
                    menu.getChildren().add(m);
                }
            }
        }
        return firstMenus;
    }

    @Override
    public List<MenuTree> getTrees(Integer rid) {
        List<MenuTree> trees = menuMapper.getTrees();
        List<RoleMenu> roleMenus = menuMapper.getRoleMenuByRoleId(rid);
        for (MenuTree tree : trees)
            if (tree.getChildren() != null)
                checkedNode(tree.getChildren(), roleMenus);
        return trees;
    }

    @Override
    public void updMenu(Integer roleId, Integer[] midArr) {
        List<RoleMenu> rms = menuMapper.getRoleMenuByRoleId(roleId);
        if (rms != null && rms.size() != 0)
            menuMapper.deleteRoleMenuByRoleId(roleId);
        if (midArr != null && midArr.length != 0)
            menuMapper.addRoleMenu(roleId, midArr);
    }

    private void checkedNode(List<MenuTree> children, List<RoleMenu> roleMenus) {
        for (MenuTree tree : children)
            for (RoleMenu rm : roleMenus)
                if (tree.getId() == rm.getMid())
                    tree.setChecked(true);
    }
}