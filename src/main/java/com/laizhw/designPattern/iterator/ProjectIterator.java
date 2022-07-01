package com.laizhw.designPattern.iterator;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : ProjectIterator
 */
public class ProjectIterator implements IProjectIterator {

    private ArrayList<IProject> projectList = new ArrayList<>();
    private int currentItem = 0;

    // 构造参数传入
    public ProjectIterator(ArrayList<IProject> projectList) {
        this.projectList = projectList;
    }

    @Override
    public boolean hasNext() {
        return this.currentItem < projectList.size() && this.projectList.get(this.currentItem) != null;
    }

    @Override
    public IProject next() {
        return this.projectList.get(this.currentItem++);
    }

    @Override
    public void remove() {
        IProjectIterator.super.remove();
    }
}
