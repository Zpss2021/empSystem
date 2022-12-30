package com.zpss.mapper;

import com.zpss.model.Dept;

import java.util.List;

public interface DeptMapper {
    public List<Dept> getDepts();

    void updateStatus(Dept dept);

    void delDept(Integer id);

    Dept getDeptByName(String name);

    void addDept(Dept dept);

    void updateDept(Dept dept);
}