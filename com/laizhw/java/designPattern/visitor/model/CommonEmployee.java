package designPattern.visitor.model;

import designPattern.visitor.Employee;
import designPattern.visitor.IVisitor;

public class CommonEmployee extends Employee {
    //工作内容，这个非常重要，以后的职业规划就是靠这个了
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    protected String getOtherInfo() {
        return "工作：" + this.job + "\t";
    }
}