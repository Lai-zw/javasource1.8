package com.laizhw.designPattern.visitor;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : ITotalVisitor
 * @createTime : 2022/6/27 11:32
 */
public interface ITotalVisitor extends IVisitor{
    //统计所有员工工资总和
    void getTotalSalary();

}
