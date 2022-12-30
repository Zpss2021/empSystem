package com.zpss.service;

import com.github.pagehelper.PageInfo;
import com.zpss.model.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getRoles();

    PageInfo get(Integer pageIndex, Integer pageSize);

    boolean addRole(Role role);

    boolean updateRole(Role role);

    void updStatus(Role role);

    void deleteRole(Integer rid);
}
