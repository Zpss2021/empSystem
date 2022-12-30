package com.zpss.model;

import java.util.List;

public class Menu {
    private Integer id;
    private String name;
    private String url;
    private Integer parentId;
    private Role role;
    private List<Menu> children;

    public Menu(){

    }

    public Menu(Integer id, String name, String url, Integer parentId, Role role, List<Menu> children) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.parentId = parentId;
        this.role = role;
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
