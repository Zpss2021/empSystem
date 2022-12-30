package com.zpss.mapper;

import com.zpss.model.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> getRoles();

    Role getRoleByName(String name);

    void addRole(Role role);

    void updateRole(Role role);

    void updStatus(Role role);

    void deleteRole(Integer rid);
}
