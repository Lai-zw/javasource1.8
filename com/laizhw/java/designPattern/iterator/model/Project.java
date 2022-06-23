package designPattern.iterator.model;

import designPattern.iterator.IProject;
import designPattern.iterator.IProjectIterator;
import designPattern.iterator.ProjectIterator;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : Project
 */

public class Project implements IProject {

    // 存放项目
    private final ArrayList<IProject> projectList = new ArrayList<>();

    private String name = "";
    private int num = 0;
    private int cost = 0;

    public Project() {
    }

    public Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }


    @Override
    public void add(String name, int num, int cost) {
        this.projectList.add(new Project(name, num, cost));
    }

    @Override
    public String getProjectInfo() {
        String info = "";

        // 项目名称
        info = info + "项目名称是：" + this.name;
        // 项目人数
        info = info + "项目人数是：" + this.num;
        // 项目费用
        info = info + "项目费用是：" + this.cost;

        return info;
    }

    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projectList);
    }
}
