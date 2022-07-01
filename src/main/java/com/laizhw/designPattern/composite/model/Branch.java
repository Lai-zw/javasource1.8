package com.laizhw.designPattern.composite.model;

import com.laizhw.designPattern.composite.Corp;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : Branch
 */
public class Branch extends Corp {

    // 子节点
    ArrayList<Corp> subordinateList = new ArrayList<>();

    public Branch(String _name, String _position, int _salary) {
        super(_name, _position, _salary);
    }

    /**
     * 添加子节点
     *
     * @param corp 子节点可以是叶子节点也可以是分支节点
     */
    public void addSubordinate(Corp corp) {
        corp.setParent(this);
        this.subordinateList.add(corp);
    }

    /**
     * 获取所有子节点
     *
     * @return subordinateList
     */
    public ArrayList<Corp> getSubordinate() {
        return this.subordinateList;
    }

}
