package com.zpss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpss.mapper.DeptMapper;
import com.zpss.model.Dept;
import com.zpss.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getDepts() {
        return deptMapper.getDepts();
    }

    @Override
    public PageInfo gets(Integer startIndex, Integer pageSize) {
        PageHelper.startPage(startIndex, pageSize);
        return new PageInfo(deptMapper.getDepts());
    }

    @Override
    public void updStatus(Dept dept) {
        int status = (dept.getStatus() == 0) ? 1 : 0;
        dept.setStatus(status);
        deptMapper.updateStatus(dept);
    }

    @Override
    public void delDept(Integer id) {
        deptMapper.delDept(id);
    }

    @Override
    public boolean addDept(Dept dept) {
        Dept d = deptMapper.getDeptByName(dept.getName());
        if (d != null)
            return true;
        deptMapper.addDept(dept);
        return false;
    }

    @Override
    public boolean updateDept(Dept dept) {
        Dept d = deptMapper.getDeptByName(dept.getName());
        if (d != null)
            return true;
        deptMapper.updateDept(dept);
        return false;
    }
}
