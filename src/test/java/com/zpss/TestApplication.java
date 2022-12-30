package com.zpss;

import com.zpss.mapper.MenuMapper;
import com.zpss.mapper.DeptMapper;
import com.zpss.model.Dept;
import com.zpss.model.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:springmvc.xml", "classpath:mybatis.xml"})
public class TestApplication {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void test1() {
        List<Menu> gets = menuMapper.gets(2);
        gets.forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<Dept> depts = deptMapper.getDepts();
        depts.forEach(System.out::println);
    }
}
