package com.laizhw.designPattern.visitor.model;

import com.laizhw.designPattern.visitor.Employee;
import com.laizhw.designPattern.visitor.IShowVisitor;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : ShowVisitor
 */
public class ShowVisitor implements IShowVisitor {

    private String info = "";

    @Override
    public void report() {
        System.out.println(this.info);
    }


    @Override
    public void visit(CommonEmployee commonEmployee) {
        this.info = this.info + this.getBasicInfo(commonEmployee) + "工作： " + commonEmployee.getJob() + "\t\n";
    }

    @Override
    public void visit(Manager manager) {
        this.info = this.info + this.getBasicInfo(manager) + "业绩： " + manager.getPerformance() + "\t\n";
    }

    private String getBasicInfo(Employee employee) {
        String info = "姓名：" + employee.getName() + "\t";
        info = info + "性别：" + (employee.getSex() == Employee.FEMALE ? "女" : "男")
                + "\t";
        info = info + "薪水：" + employee.getSalary();
        return info;
    }
}
