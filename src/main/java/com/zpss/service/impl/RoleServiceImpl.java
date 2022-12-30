package com.zpss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpss.mapper.MenuMapper;
import com.zpss.mapper.RoleMapper;
import com.zpss.model.Role;
import com.zpss.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Role> getRoles() {
        return roleMapper.getRoles();
    }

    @Override
    public PageInfo get(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        return new PageInfo(roleMapper.getRoles());
    }

    @Override
    public boolean addRole(Role role) {
        Role r = roleMapper.getRoleByName(role.getName());
        if (r != null)
            return true;
        roleMapper.addRole(role);
        return false;
    }

    @Override
    public boolean updateRole(Role role) {
        Role r = roleMapper.getRoleByName(role.getName());
        if (r != null)
            return true;
        roleMapper.updateRole(role);
        return false;
    }

    @Override
    public void updStatus(Role role) {
        int status = (role.getStatus() == 0) ? 1 : 0;
        role.setStatus(status);
        roleMapper.updStatus(role);
    }

    @Override
    public void deleteRole(Integer rid) {
        roleMapper.deleteRole(rid);
        menuMapper.deleteRoleMenuByRoleId(rid);
    }
}
