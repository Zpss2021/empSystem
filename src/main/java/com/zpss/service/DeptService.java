package com.zpss.service;

import com.github.pagehelper.PageInfo;
import com.zpss.model.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> getDepts();

    public PageInfo gets(Integer startIndex, Integer pageSize);

    void updStatus(Dept dept);

    void delDept(Integer id);

    boolean addDept(Dept dept);

    boolean updateDept(Dept dept);
}