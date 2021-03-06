package com.laizhw.designPattern.visitor.model;

import com.laizhw.designPattern.visitor.Employee;
import com.laizhw.designPattern.visitor.IVisitor;

public class Manager extends Employee {

    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    protected String getOtherInfo() {
        return "业绩：" + this.performance + "\t";
    }
}