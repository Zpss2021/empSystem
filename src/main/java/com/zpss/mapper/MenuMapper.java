package com.zpss.mapper;

import com.zpss.model.Menu;
import com.zpss.model.MenuTree;
import com.zpss.model.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    public List<Menu> gets(int roleId);

    List<MenuTree> getTrees();


    List<RoleMenu> getRoleMenuByRoleId(Integer rid);

    void deleteRoleMenuByRoleId(Integer roleId);

    void addRoleMenu(@Param("rid") Integer roleId, @Param("mids") Integer[] midArr);
}
