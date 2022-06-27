package designPattern.visitor.model;

import designPattern.visitor.ITotalVisitor;

/**
 * TODO
 *
 * @author : Laizhw@
 * @version : v1.0
 * @className : TotalVisitor
 */
public class TotalVisitor implements ITotalVisitor {

    private final static int MANAGER_COEFFICIENT = 5;
    private final static int COMMONEMPLOYEE_COEFFICIENT = 2;
    private int commonTotalSalary = 0;
    private int managerTotalSalary = 0;

    @Override
    public void getTotalSalary() {
        System.out.println("本公司的月工资总额是" + (this.commonTotalSalary + this.managerTotalSalary));
    }

    @Override
    public void visit(CommonEmployee commonEmployee) {
        this.managerTotalSalary = this.managerTotalSalary + commonEmployee.getSalary()
                * MANAGER_COEFFICIENT;
    }

    @Override
    public void visit(Manager manager) {
        this.commonTotalSalary = this.commonTotalSalary +
                manager.getSalary() * COMMONEMPLOYEE_COEFFICIENT;
    }

}
