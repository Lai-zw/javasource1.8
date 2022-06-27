package designPattern.visitor;

import designPattern.visitor.model.CommonEmployee;
import designPattern.visitor.model.Manager;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : IVisitor
 * @createTime : 2022/6/27 10:39
 */
public interface IVisitor {
    //首先定义我可以访问普通员工
    void visit(CommonEmployee commonEmployee);

    //其次定义，我还可以访问部门经理
    void visit(Manager manager);

}
